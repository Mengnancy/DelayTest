package com.qm.delay.delay4;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

import java.util.Calendar;
import java.util.Set;

public class AppTest {
    private static final String addr = "127.0.0.1";
    private static final int PORT = 6379;
    private static JedisPool pool = new JedisPool(addr, PORT);

    public static Jedis getJedis() {
        return pool.getResource();
    }

    public void productionDelayMessage() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, 3);
            int second3later = (int) (calendar.getTimeInMillis() / 1000);
            AppTest.getJedis().zadd("OrderId", second3later, "OID0000001" + i);
            System.out.println(System.currentTimeMillis() + "ms:redis生成了一个订单任务：订单ID为" + "OID0000001" + i);
        }
    }

    public void consumerDelayMessage() {
        Jedis jedis = AppTest.getJedis();

        while (true) {
            Set<Tuple> items = jedis.zrangeWithScores("OrderId", 0, 1);
            if (items == null || items.isEmpty()) {
                System.out.println("没有等待的任务");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            int socre = (int) ((Tuple) items.toArray()[0]).getScore();
            Calendar cal = Calendar.getInstance();
            int newSecond = (int) (cal.getTimeInMillis() / 1000);
            if (socre <= newSecond) {
                String orderId = ((Tuple) items.toArray()[0]).getElement();
                Long success = jedis.zrem("OrderId", orderId);
                if (success != null && success > 0) {
                    System.out.println(System.currentTimeMillis() + "ms:redis消费了一个任务：消费的订单OrderId为" + orderId);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AppTest appTest = new AppTest();
        appTest.productionDelayMessage();
        appTest.consumerDelayMessage();
    }

}
