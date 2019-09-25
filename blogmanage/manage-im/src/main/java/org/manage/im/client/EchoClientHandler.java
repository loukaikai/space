package org.manage.im.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/** 
 * @ClassName: EchoClientHandler
 * @description: 
 * @author: your loukaikai
 * @Date: 2019年8月6日 下午4:38:02
 */

public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
	
	// 在到服务器的连接已经建立之后将被调用
	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		System.out.println("*********************clent 建立连接*********************");
		ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!",
				CharsetUtil.UTF_8));
	}
	// 当从服务器接收到一条消息时被调用
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		System.out.println(
				"Client received: " + msg.toString(CharsetUtil.UTF_8));
		ctx.fireChannelRead(ctx);
	}
	// 在处理过程中引发异常时被调用。
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,
			Throwable cause) {
		System.out.println("处理过程有异常");
		cause.printStackTrace();
		ctx.close();
	}
}
