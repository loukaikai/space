package org.manage.im.client;

import java.nio.charset.Charset;

import org.manage.im.transmission.LoginPacket;
import org.manage.im.transmission.packet.Packet;
import org.manage.im.utils.PacketCoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;

/** 
 * @ClassName: LoginChannel
 * @description: 
 * @author: your loukaikai
 * @Date: 2019年8月29日 下午8:43:28
 */

@Sharable
public class LoginChannel extends ChannelInboundHandlerAdapter{
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		System.out.println("启动");
		Packet packet = getPacket();
		PacketCoder coder = new PacketCoder();
		ByteBuf byteBuf = coder.enCode(packet);
		// 写入传给服务端
		ctx.channel().writeAndFlush(byteBuf);
	}
	
  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) {
	  /*System.out.println("*********************");
	System.out.println(msg.toString());
	msg.toString().equals("true");
	System.out.println("************************************");
//        ctx.fireChannelRead(msg);
 * 
 * 
*/
	  
	  if (msg instanceof ByteBuf) {
          String value = ((ByteBuf) msg).toString(Charset.defaultCharset());
          System.out.println("服务器端返回的数据:" + value);
      }
       
      AttributeKey<String> key = AttributeKey.valueOf("ServerData");
      ctx.channel().attr(key).set("客户端处理完毕");

      //把客户端的通道关闭
      ctx.channel().close();
  
  }
    
 

	
	private Packet getPacket( ) {
		LoginPacket packet = new LoginPacket();
		packet.setUserId(123);
		packet.setUserName("user");
		packet.setPassWord("admin");
		return packet;
		
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
