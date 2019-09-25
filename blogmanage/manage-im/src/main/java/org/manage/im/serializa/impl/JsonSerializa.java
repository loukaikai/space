package org.manage.im.serializa.impl;

import org.manage.im.serializa.Serializa;
import org.manage.im.utils.SerializaConstant;

import com.alibaba.fastjson.JSONObject;

/** 
 * @ClassName: JsonSerializa
 * @description: 
 * @author: your loukaikai
 * @Date: 2019年8月8日 下午5:20:33
 */

public class JsonSerializa implements Serializa {

	@Override
	public int getSerialiAlgorithm() {
		// TODO Auto-generated method stub
		return SerializaConstant.JSONSERIALIZA;
	}

	@Override
	public byte[] serialization(Object obj) {
		return JSONObject.toJSONBytes(obj);
	}

	@Override
	public <T> T deserialization(Class<T> clazz, byte[] bytes) {
		// TODO Auto-generated method stub
		return JSONObject.parseObject(bytes, clazz);
	}

}
