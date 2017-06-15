package com.mjlf.MVC.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableAspectJAutoProxy
@PropertySource(value={"classpath:redis.properties"})
public class RedisConfig{

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private Integer port;

    @Value("${redis.pass}")
    private String pass;

    @Value("${redis.maxIdle}")
    private Integer maxIdle;

    @Value("${redis.maxActive}")
    private Integer maxActive;

    @Value("${redis.maxWait}")
    private Integer maxWait;


    @Bean(name = "jedisPool")
    public JedisPool jedispool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxWait(3000);
        config.setMaxActive(32);         //  最大连接数
        config.setMinIdle(6);//  允许最小的空闲连接数
        config.setTestOnBorrow(false);  //  申请到连接时是否效验连接是否有效,对性能有影响,建议关闭
        config.setTestOnReturn(false);  //  使用完连接放回连接池时是否效验连接是否有效,对性能有影响,建议关闭
        config.setTestWhileIdle(true);  //  申请到连接时,如果空闲时间大于TimeBetweenEvictionRunsMillis时间,效验连接是否有效,建议开启,对性能有效不大
        config.setTimeBetweenEvictionRunsMillis(30000); //TestWhileIdle的判断依据
        return new JedisPool(config, host, port, 30000, pass);
    }
}