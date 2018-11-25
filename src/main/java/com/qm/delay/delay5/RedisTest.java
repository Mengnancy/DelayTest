package com.qm.delay.delay5;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

public class RedisTest {
    private static final String ADDR = "127.0.0.1";
    private static final int PORT = 6379;
    private static JedisPool jedis = new JedisPool(ADDR, PORT);
    private static RedisSub sub = new RedisSub();

    public static void init() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                jedis.getResource().subscribe(sub, "__keyevent@0__:expired");
            }
        }).start();
    }

    public static void main(String[] args) {
        init();

        for (int i = 0; i < 10; i++) {
            String orderId = "OID000000"+i;
            jedis.getResource().setex(orderId,3,orderId);
            System.out.println(System.currentTimeMillis()+" 订单"+orderId+"生成");
        }
    }

    static class RedisSub extends JedisPubSub {
        @Override
        public void onMessage(String channel, String message) {
            System.out.println(System.currentTimeMillis() + " message:" + message + "订单取消");
        }
    }
}
