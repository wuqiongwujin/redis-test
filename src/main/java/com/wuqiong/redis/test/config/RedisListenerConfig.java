package com.wuqiong.redis.test.config;

import com.wuqiong.redis.test.service.RedisReceiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @Description
 * @Author Cain
 * @date 2020/3/12
 */
@Configuration
public class RedisListenerConfig {


}
