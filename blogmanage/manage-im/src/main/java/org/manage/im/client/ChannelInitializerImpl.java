package org.manage.im.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/** 
 * @ClassName: ChannelInitializerImpl
 * @description: 
 * @author: your loukaikai
 * @Date: 2019年8月30日 下午4:51:41
 */

public  class ChannelInitializerImpl extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		// TODO Auto-generated method stub
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast(new LoginChannel()).addLast(new MessageHandle());
		
	}

}
