package org.manage.im.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelHandler.Sharable;

/** 
 * @ClassName: MessageHandle
 * @description: 
 * @author: your loukaikai
 * @Date: 2019年9月4日 上午11:03:53
 */

@Sharable
public class MessageHandle extends ChannelInboundHandlerAdapter{
	  @Override
	  public void channelRead(ChannelHandlerContext ctx, Object msg) {
		  System.out.println("*********************");
		System.out.println(msg.toString());
		msg.toString().equals("true");
		System.out.println("************************************");
		}
}
