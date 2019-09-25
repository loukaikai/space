package org.manage.im.serializa;

import org.manage.im.serializa.impl.JsonSerializa;

import com.alibaba.fastjson.serializer.JSONSerializer;

/** 
 * @ClassName: serializa
 * @description: 
 * @author: your loukaikai
 * @Date: 2019年8月8日 下午5:10:13
 */

public interface Serializa {
	
	/**
	 * 
	 * 默认的序列化对对象
	 */
	Serializa DEFAULT = new JsonSerializa();
	
	int getSerialiAlgorithm();
	
	/**
	 *  序列化
	 * **/
	byte[] serialization(Object obj);
	
	/**
	 *  反序列化
	 * **/
	<T> T deserialization(Class<T> clazz, byte[] bytes);
	
}
