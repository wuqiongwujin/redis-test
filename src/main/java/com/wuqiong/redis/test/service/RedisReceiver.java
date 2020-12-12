package com.wuqiong.redis.test.service;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Cain
 * @date 2020/3/12
 */
@Service
public class RedisReceiver {
	public void receiveMessage(String message) {
		System.out.println("消息来了："+message);
	}
}
