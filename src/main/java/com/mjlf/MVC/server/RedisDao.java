package com.mjlf.MVC.server;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by a123 on 16/8/24.
 */

@Component
public class RedisDao {

    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueopsStr;

    @Resource(name = "redisTemplate")
    private ValueOperations<String, Object> valOps;


    @Resource(name = "redisTemplate")
    private ListOperations<String, Object> listOperations;

    @Resource(name = "redisTemplate")
    private HashOperations<String, Object, Object> hashOperations;

    @Resource(name = "redisTemplate")
    private SetOperations<String, String> setSessioin;

    @Resource(name = "redisTemplate")
    private SetOperations<String, Object> setOperations;

    @Resource(name = "redisTemplate")
    private ZSetOperations<String, Object> zSetOperations;


    public ValueOperations<String, Object> getValOps() {
        return valOps;
    }

    public ValueOperations<String, String> getValString() {
        return valueopsStr;
    }

    public ListOperations<String, Object> getListOperations() {
        return listOperations;
    }

    public HashOperations<String, Object, Object> getHashOperations() {
        return hashOperations;
    }

    public SetOperations<String, String> getSetSessioin() {
        return setSessioin;
    }


    public SetOperations<String, Object> getSetOperations() {
        return setOperations;
    }

    public ZSetOperations<String, Object> getzSetOperations() {
        return zSetOperations;
    }
}
