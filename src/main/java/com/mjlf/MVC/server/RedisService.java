package com.mjlf.MVC.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate< String, Object > template;

    @Autowired
    private RedisDao redisDao;

    public Object getValue(final String key) {
        return template.opsForValue().get(key);
    }

    public void setValue(final String key, final String value) {
        template.opsForValue().set(key, value);

        // set a expire for a message
        template.expire(key, 5, TimeUnit.SECONDS);
    }

    public void setKV(final String key, final String values){
        ValueOperations<String, String> redisTemplate = redisDao.getValString();
        redisTemplate.set(key, values);
    }
}