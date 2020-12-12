package com.wuqiong.redis.test.service;

import com.google.gson.Gson;
import com.wuqiong.redis.test.bean.MyTransactionStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @Description
 * @date 2019/1/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisManagerTest {

    @Autowired
    private RedisManager redisManager;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void putStringTest() {
        String key = "transaction_110501";
        List<MyTransactionStatus> statusList = new ArrayList<>();
        {
            MyTransactionStatus status = new MyTransactionStatus();
            status.setStatus(1);
            status.setTransactionID("110501");
            statusList.add(status);
        }
        {
            MyTransactionStatus status = new MyTransactionStatus();
            status.setStatus(1);
            status.setTransactionID("110501");
            statusList.add(status);
        }
        redisManager.putString(key, new Gson().toJson(statusList));
    }

    @Test
    public void getStringTest() {
        String key = "transaction_110501";
        String transactionInfo = redisManager.getString(key);
    }

    @Test
    public void pusSet() {
        String key = "mobile";
        String value = "132";
        redisManager.putSet(key, value);
    }

    @Test
    public void getSetTest() {
        String key = "mobile";
        System.out.println(new Gson().toJson(redisManager.getSet(key)));
    }

    @Test
    public void redisTemplateTest() {
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @Test
    public void incrementTest() {
        String key = "num";
    }

    @Test
    public void lockTest() {
        redisManager.lockTest();
    }

    @Test
    public void storeListTest() {
        List<String> list = new ArrayList<>(Arrays.asList("1","2","3"));
        redisTemplate.opsForList().rightPush("list110501", list);
    }

    @Test
    public void getListTest() {
        final String key = "list110501";
        {
            redisTemplate.opsForList().rightPush(key, "1");
        }
        {
            redisTemplate.opsForList().rightPush(key, "2");
        }
        Object item = redisTemplate.opsForList().rightPop(key);
        System.out.println(item);
    }
}
