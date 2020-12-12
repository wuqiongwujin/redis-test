package com.wuqiong.redis.test.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Cain
 * @date 2020/3/12
 */
@EnableScheduling
@Component
public class SendMessageTask {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	//向redis消息队列index通道发布消息
	//@Scheduled(fixedRate = 3000)
	public void sendMessage(){
		stringRedisTemplate.convertAndSend("test",String.valueOf(Math.random()));
	}
}
