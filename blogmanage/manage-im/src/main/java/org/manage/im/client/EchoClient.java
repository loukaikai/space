package org.manage.im.client;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.manage.im.transmission.LoginPacket;
import org.manage.im.utils.PacketCoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

/** 
 * @ClassName: EchoClient
 * @description: 
 * @author: your loukaikai
 * @Date: 2019年8月6日 下午4:57:50
 */

public class EchoClient {
	private final String host;
	private final int port;
	private EventLoopGroup group;
	public EchoClient(String host, int port, EventLoopGroup group) {
		this.host = host;
		this.port = port;
		this.group = group;
	}
	
	public void start() throws Exception {
	  /* =============================================================
	   | 1.创建EventLoopGroup                                          |
 	   | 2.指定 EventLoopGroup 以处理客户端事件；需要适用于 NIO 的实现                                         |
 	   | 3.适用于 NIO 传输的Channel 类型                                                                                                           |
 	   | 4.设置服务器的InetSocketAddress                                 ||
 	   | 5.在创建Channel时，向 ChannelPipeline中添加一个 EchoClientHandler 实例  |
 		=============================================================*/
//		EventLoopGroup group = new NioEventLoopGroup();
		 
		Bootstrap b = new Bootstrap();
		b.group(group)
			.channel(NioSocketChannel.class)
			.remoteAddress(new InetSocketAddress(host, port))
			.handler(new ChannelInitializerImpl());
//			连接到远程节点，阻塞等待直到连接完成
		ChannelFuture  f = connect(b,host,port);
		
 		 AttributeKey<String> key = AttributeKey.valueOf("ServerData");
	        Object result = f.channel().attr(key).get();
	        System.out.println(result.toString()); 
		cacenl(f);
	 
	}
	
	public static ChannelFuture connect(Bootstrap b, String host, int port) {
		ChannelFuture future = null;
		try {
			b.remoteAddress(new InetSocketAddress(host, port));
			future = b.connect().sync();
		//	future.addListener(new ChannelFutureListenerImpl());
			
			 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*for(int i = 0; i<5; i++) {
			LoginPacket pack = new LoginPacket();
			pack.setUserId(222);
			pack.setUserName("222");
			pack.setPassWord("123");
			ByteBuf byteBuf = PacketCoder.INSTANCE.enCode(pack);
			future.channel().writeAndFlush(byteBuf);
		}*/
		future.channel().read();
		return future;
		
	}
	
	
	public void cacenl(ChannelFuture future) {
		try {
			future.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			group.shutdownGracefully();
		}
	}
	public static void main(String[] args) throws Exception {
		int port = 8080;
		 InetAddress addr = InetAddress.getLocalHost();  
         String hostName=addr.getHostName().toString(); 
		EventLoopGroup group = new NioEventLoopGroup();
		new EchoClient(hostName, port, group).start();
	}
}
