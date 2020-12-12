package com.wuqiong.redis.test.service;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @date 2019/1/30
 */
@Service
public class RedisManager {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedissonClient redissonClient;

    public void putString(String key, String value) {
        Assert.hasText(key, "key不能为空");
        Assert.hasText(value, "value不能为空");
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String getString(String key) {
        Assert.hasText(key, "key不能为空");
        System.out.println(stringRedisTemplate.opsForValue().get(key));
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void putSet(String key, String value) {
        Assert.hasText(key, "key不能为空");
        Assert.notNull(value, "value不能为空");
        stringRedisTemplate.opsForSet().add(key, value);
    }

    public Set<String> getSet(String key) {
        Assert.hasText(key, "key不能为空");
        return stringRedisTemplate.opsForSet().members(key);
    }

    public void getAndSet(String key, String value) {
        Assert.hasText(key, "key不能为空");
        Assert.notNull(value, "value不能为空");
        stringRedisTemplate.opsForValue().getAndSet(key, value);
    }

    public long increment(String key, long value) {
        Assert.hasText(key, "key不能为空");
        return stringRedisTemplate.boundValueOps(key).increment(value);
    }

    public void subscribe(String channel) {
    }

    public void lockTest() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                RLock lock = redissonClient.getLock("mylock");
                try {
                    if (lock.tryLock(10, 3600, TimeUnit.SECONDS)) {
                        System.out.println("获得锁");
                        Thread.sleep(20 * 1000);
                    } else {
                        System.out.println("获取锁失败");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                RLock lock = redissonClient.getLock("mylock");
                try {
                    if (lock.tryLock(10, 3600, TimeUnit.SECONDS)) {
                        System.out.println("获得锁");
                        Thread.sleep(20 * 1000);
                    } else {
                        System.out.println("获取锁失败");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
