package com.manage.web.modules.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

public class RedisMessageListener implements MessageListener{
	
	@Autowired
    private RedisTemplate<String, String> redisTemplate;

	@Override
	public void onMessage(Message message, byte[] pattern) {
		RedisSerializer<?> serializer = redisTemplate.getValueSerializer();
        Object channel = serializer.deserialize(message.getChannel());
        Object body = serializer.deserialize(message.getBody());  
        System.out.println("主题: " + channel);
        System.out.println("消息内容: " + String.valueOf(body));
		
	}
	
	 public RedisTemplate<String, String> getRedisTemplate() {
	        return redisTemplate;
	    }

    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

}
