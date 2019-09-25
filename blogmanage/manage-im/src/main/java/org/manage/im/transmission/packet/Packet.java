package org.manage.im.transmission.packet;

/** 
 * @ClassName: AbstractPacket
 * @description: 
 * @author: your loukaikai
 * @Date: 2019年8月8日 下午4:53:44
 */

public interface Packet {
	
	int version = 1;
	
	public abstract int getCommand();
}
