package org.manage.im.server;

import java.net.InetSocketAddress;

import org.apache.tomcat.util.net.NioChannel;
import org.jboss.jandex.Main;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

/** 
 * @ClassName: EchoServer
 * @description: 
 * @author: your loukaikai
 * @Date: 2019年8月6日 下午3:39:11
 */

public class EchoServer {
	private final int port;
	
	public EchoServer(int port) {
		this.port = port;
	}
	
	public void start() throws InterruptedException {
		final EchoServerHandler serverHandler = new EchoServerHandler();
		// 1.创建EventLoopGroup
		EventLoopGroup group = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		/*=======================================================
		 | 2.创建ServerBootstrap                                  |
		 | 3.指定所使用的 NIO传输 Channel                               |
		 | 4.使用指定的端口设置套接字地址	                                |
		 | 5.添加一个EchoServerHandler 到子Channel的 ChannelPipeline  |
		 =========================================================*/
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(group,workGroup)
					 	.channel(NioServerSocketChannel.class)
					 	.localAddress(new InetSocketAddress(port))
					 	.option(ChannelOption.SO_BACKLOG, 128)
					 	.childHandler(new ChannelInitializer<SocketChannel>() {

							@Override
							protected void initChannel(SocketChannel ch) throws Exception {
								// TODO Auto-generated method stub
								ch.pipeline().addLast(serverHandler);
							}
					 		
					 	});
//			6.异步地绑定服务器；调用 sync()方法阻塞等待直到绑定完成   
			ChannelFuture f = bootstrap.bind().sync();
//			获取 Channel 的CloseFuture，并且阻塞当前线程直到它完成
			f.channel().closeFuture().sync();		 			
		} finally {
//			关闭 EventLoopGroup，释放所有的资源
			group.shutdownGracefully().sync();
		}
	}
	
	public static void main(String[] args) throws Exception {
		int port = 8080;
		new EchoServer(8080).start();;
	}
}
