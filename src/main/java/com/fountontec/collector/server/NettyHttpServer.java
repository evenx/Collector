package com.fountontec.collector.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fountontec.collector.common.Config;

/**
 * @author wenyi
 *
 */
@Service
public class NettyHttpServer {

	@Autowired
	private Config config;
	
	private EventLoopGroup bossGroup;
	private EventLoopGroup workerGroup;
	private Channel channel;
	
	public void start(){
        // Configure the server.
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        b.option(ChannelOption.SO_BACKLOG, 1024);
        b.option(ChannelOption.TCP_NODELAY, true);
        b.option(ChannelOption.SO_KEEPALIVE, true);
        b.option(ChannelOption.SO_REUSEADDR, true);
        b.group(bossGroup, workerGroup)
         .channel(NioServerSocketChannel.class)
         .childHandler(new NettyHttpServerInitializer());

		try {
			channel = b.bind(config.getLocalIP(), config.getBindPort()).sync().channel();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
	
	
	@PreDestroy
	public void stop(){
		channel.close();
		bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
	}
}
