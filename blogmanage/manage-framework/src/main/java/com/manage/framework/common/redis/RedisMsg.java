package com.manage.framework.common.redis;

import org.springframework.stereotype.Component;

/**
 * redis消息订阅模式
 * **/
@Component
public interface RedisMsg {
	public void receiveMessage(String message);

}
