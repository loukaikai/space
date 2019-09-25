package org.manage.im.utils;

import java.lang.reflect.Method;
import java.security.spec.MGF1ParameterSpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.manage.im.serializa.Serializa;
import org.manage.im.serializa.impl.JsonSerializa;
import org.manage.im.transmission.LoginPacket;
import org.manage.im.transmission.packet.Packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/** 
 * @ClassName: PacketCoder
 * @description: 包数据编解码
 * @author: your loukaikai
 * @Date: 2019年8月8日 下午5:59:52
 */

public class PacketCoder {
	// 魔数
	private static final int MAGIC_NUMBER = 0x12345678;
	// 指令 与 数据包 映射
	private final Map<Integer, Class<? super Packet>> packetTypeMap;
	// 序列化算法 与 序列化类 映射
	private final Map<Integer,   Class<? super Serializa>> serializerMap;
	// 单例
	public volatile static PacketCoder INSTANCE = new PacketCoder();
	// 注册Packet集合
	List<Class> packetList = Arrays.asList(new Class[] { LoginPacket.class });
	// 注册序列化算法集合
	List<Class> serializerList = Arrays.asList(new Class[] { JsonSerializa.class });

	/**
	 * 初始化 指令 与 数据包 映射 序列化算法 与 序列化类 映射
	 */
	@SuppressWarnings("unchecked")
	public PacketCoder() {
		packetTypeMap = new HashMap<Integer, Class<? super Packet>>();
		packetList.forEach(clazz -> {
			Method method;
			try {
				method = clazz.getMethod("getCommand");
				int commad = (int) method.invoke(clazz.newInstance());
				packetTypeMap.put(commad, clazz);
				System.out.println(packetTypeMap.get(commad));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		});
		
		serializerMap = new HashMap<Integer, Class<? super Serializa>>();
		serializerList.forEach(clazz -> {
			Method method;
			try {
				method = clazz.getMethod("getSerialiAlgorithm");
				int commad = (int) method.invoke(clazz.newInstance());
				serializerMap.put(commad, clazz);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	/**
	 * 编码
	 * **/
	public ByteBuf enCode(Packet packet) {
		ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();
		int packCommand = packet.getCommand();
		Serializa serializa = null;
		try {
			serializa = (Serializa) serializerMap.get(packCommand).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] bs = serializa.serialization(packet);
		
		// 装载数据
		byteBuf.writeInt(MagicNumberConstant.MAGIC_NUMBER);
		byteBuf.writeInt(VersionConstant.VERSION);
		byteBuf.writeInt(serializa.getSerialiAlgorithm());
		byteBuf.writeInt(packCommand);
		byteBuf.writeInt(bs.length);
		byteBuf.writeBytes(bs);
		return byteBuf;
	}
	
	
	/**
	 * 编码
	 * **/
	public Packet decode(ByteBuf byteBuf) {
		
		// 跳过魔数验证
		int mangic = byteBuf.readInt();
		// 跳过版本验证
		int version = byteBuf.readInt();
		// 获得序列化key值
		int serialiAlgorithm = byteBuf.readInt();
		Serializa serializa = null;
		try {
			serializa = (Serializa) serializerMap.get(serialiAlgorithm).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获得指令
		int command = byteBuf.readInt();
		//获得数据长度
		int dataLength = byteBuf.readInt();
		byte[] bs = new byte[dataLength];
		/*bs= byteBuf.readBytes(byteBuf,0,25-1).array();
		System.out.println(bs);
		bs = new byte[dataLength];*/
		for(int i = 0; i < dataLength; i++) {
			byte b = byteBuf.readByte();
			bs[i] = b;
		}
		System.out.println(bs);
		
		Packet packet =  serializa.deserialization(LoginPacket.class, bs);
		packet.getCommand();
		
		return packet;
		
	}
	
	 public static void main(String[] args) {
		Packet packet = new LoginPacket();
		((LoginPacket) packet).setUserId(123);
		PacketCoder packetCoder = new PacketCoder();
		ByteBuf byteBuf = packetCoder.enCode(packet);
		
		packet = packetCoder.decode(byteBuf);
		System.out.println(((LoginPacket) packet).getUserId());
	 }
	
}
 