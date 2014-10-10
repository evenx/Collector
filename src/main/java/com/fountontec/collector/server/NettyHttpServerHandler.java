package com.fountontec.collector.server;

import static io.netty.handler.codec.http.HttpHeaders.is100ContinueExpected;
import static io.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.CONTINUE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders.Values;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.CharsetUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fountontec.collector.common.Common;

/**
 * 
 * @author wenyi
 *
 */
//this class can't be managed by spring
public class NettyHttpServerHandler extends SimpleChannelInboundHandler<HttpObject>   {

	
	private static final Logger logger = LoggerFactory.getLogger(NettyHttpServerHandler.class);
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     
	private ByteBuf buf = Unpooled.buffer();
	
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg)
			throws Exception {
		 if (msg instanceof HttpRequest) {
	            HttpRequest req = (HttpRequest) msg;

	            if (is100ContinueExpected(req)) {
	                ctx.write(new DefaultFullHttpResponse(HTTP_1_1, CONTINUE));
	            }
	            boolean keepAlive = isKeepAlive(req);
	            FullHttpResponse response = new DefaultFullHttpResponse(
	                    HTTP_1_1, msg.getDecoderResult().isSuccess()? OK : HttpResponseStatus.BAD_REQUEST,
	                    Unpooled.copiedBuffer("ok", CharsetUtil.UTF_8));
	            response.headers().set(CONTENT_TYPE, "text/plain");
	            response.headers().set(CONTENT_LENGTH, response.content().readableBytes());

	            if (!keepAlive) {
	                ctx.write(response).addListener(ChannelFutureListener.CLOSE);
	            } else {
	                response.headers().set(CONNECTION, Values.KEEP_ALIVE);
	                ctx.write(response);
	            }
	        }
		 
		 if(msg instanceof HttpContent){
			 
			 HttpContent chunk = (HttpContent)msg;
			 buf.writeBytes(chunk.content());
			 
			 if(chunk instanceof LastHttpContent){
				 
            	String str = buf.toString(CharsetUtil.UTF_8);
            	if(StringUtils.isNotEmpty(str)){
            		try {
            			JSONObject al = new JSONObject();
            			al.put(Common.LOG_CREATED_KEY, simpleDateFormat.format(new Date()));
            			JSONObject json= JSON.parseObject(str);
						if(json.get(Common.MESSAGE_TYPE_KEY)!= null){
                            al.put(Common.LOG_VALUE_KEY, json);
                            logger.info(al.toString());
						}
					}catch (Exception e){
					}
            	}
            	buf.clear();
			 }
		 }
		
	}
}
