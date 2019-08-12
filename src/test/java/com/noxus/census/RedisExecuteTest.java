package com.noxus.census;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sorata
 * @date 2019-08-06 10:55
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisExecuteTest {

    @Autowired private StringRedisTemplate redisTemplate;

    @Test
    public void push() {


    }

    @Test
    public void size() {

    }



    @Test
    @SuppressWarnings("unchecked")
    public void threadTest(){
        redisTemplate.boundValueOps("2019080610").set("1");
        AtomicInteger atomicInteger = new AtomicInteger(1);
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 10000; i1++) {

                        String value = redisTemplate.boundValueOps("2019080610").get();
                        int a=  Integer.parseInt(value) + 1;
                        if (a <= 1001){
                            redisTemplate.boundValueOps("2019080610").set(a + "");
                        }

                    }
                    System.out.println("done" + atomicInteger.incrementAndGet());
                }
            }).start();
        }

//        for (int i = 0; i < 1000; i++) {
//            redisTemplate.boundValueOps("20190806").increment(1);
//        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(redisTemplate.boundValueOps("2019080610").get());

    }







}