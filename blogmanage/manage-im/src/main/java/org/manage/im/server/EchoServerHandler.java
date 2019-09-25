package org.manage.im.server;

import org.manage.im.transmission.LoginPacket;
import org.manage.im.utils.PacketCoder;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/** 
 * @ClassName: EchoServerHandler
 * @description: 
 * @author: your loukaikai
 * @Date: 2019年8月6日 下午3:30:39
 */
@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter{
	
	@Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("客户端连接成功, 处理的cnannel:  "+ctx.name());
        
       
    }
 
	// 对于每个传入的消息都要调用
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		ByteBuf in = (ByteBuf) msg;
		System.out.println(
				"Server received: " + in.toString(CharsetUtil.UTF_8));
		
		if(loginRespo(in)) {
			System.out.println("登录验证成功");
			ctx.channel().writeAndFlush("登录成功");
		}else {
			System.out.println("登录失败");
		}
		
	}
	
	// 通知ChannelInboundHandler最后一次对channelRead()的调用是当前批量读取中的最后一条消息
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
		.addListener(ChannelFutureListener.CLOSE);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,
	Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
	
	private boolean loginRespo(ByteBuf in) {
		PacketCoder coder = new PacketCoder();
		LoginPacket login = (LoginPacket) coder.decode(in);
		if(null != login) {
			return true;
		}
		return false;
	}

}
