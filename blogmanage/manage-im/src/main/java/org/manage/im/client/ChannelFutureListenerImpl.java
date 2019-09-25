package org.manage.im.client;

import io.netty.channel.ChannelFuture;
import io.netty.util.concurrent.GenericFutureListener;

/** 
 * @ClassName: ChannelFutureListenerImpl
 * @description: 
 * @author: your loukaikai
 * @Date: 2019年8月30日 下午5:04:52
 */

public class ChannelFutureListenerImpl implements GenericFutureListener<ChannelFuture>{

	@Override
	public void operationComplete(ChannelFuture future) throws Exception {
		if(future.isSuccess()) {
			System.out.println("********************连接成功*****************");
			
		}else {
			System.out.println("********************连接失败*****************");
			future.cause().printStackTrace();
			System.out.println("********************异常打印*****************");
		}
		
		
	}

}
