package com.fountontec.collector.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 
 * @author wenyi
 *
 */
public class NettyHttpServerInitializer extends ChannelInitializer<SocketChannel>{

	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline p = ch.pipeline();

		// Uncomment the following line if you want HTTPS
        //SSLEngine engine = SecureChatSslContextFactory.getServerContext().createSSLEngine();
        //engine.setUseClientMode(false);
        //p.addLast("ssl", new SslHandler(engine));

		p.addLast("codec", new HttpServerCodec());
        p.addLast("handler", new NettyHttpServerHandler());
		
	}

}
