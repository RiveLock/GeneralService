/**
 * RedisTest
 * @description
 * @author jixinshi
 * @date 2021/3/12 3:51 PM
 * @version 2.11.2
 */
package com.general.support.redis;

import com.general.support.business.sample.entity.User;
import com.general.support.business.sample.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

/**
 * RedisTest
 * @description
 * @author jixinshi
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplateObjcet;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;

    @Test
    public void redisTemplateTest() {
        System.out.println("================= start =================");
        redisTemplateObjcet.opsForValue().set("support", "1111");
        String value = redisTemplate.opsForValue().get("support");
        System.out.println(value);

    }

    @Test
    public void boundTest() {
        System.out.println("================= start =================");
        redisTemplate.boundValueOps("support").set("2222");
        System.out.println(redisTemplate.boundValueOps("support").get());
    }

    @Test
    public void stringRedisTemplateTest() {
        System.out.println("================= start =================");
        System.out.println(stringRedisTemplate.opsForValue().get("support"));
        List<User> user = userService.list();
        System.out.println(user);

        System.out.println("================= put =================");
        user.forEach(item -> {
            item.setCreateTime(null);
            redisTemplateObjcet.opsForHash().put("user", String.valueOf(item.getId()), item);
        });

        System.out.println("================= get =================");
        user.forEach(item -> {
            User outUser = (User) redisTemplateObjcet.opsForHash().get("user", String.valueOf(item.getId()));
            System.out.println(outUser);
        });
    }

    @Test
    public void objectTest() {
        System.out.println("================= start =================");
        List<User> user = userService.list();
        System.out.println(user);

        System.out.println("================= put =================");
        user.forEach(item -> {
            item.setCreateTime(null);
            redisTemplateObjcet.opsForHash().put("user", String.valueOf(item.getId()), item);
        });

        System.out.println("================= get =================");
        user.forEach(item -> {
            User outUser = (User) redisTemplateObjcet.opsForHash().get("user", String.valueOf(item.getId()));
            System.out.println(outUser);
        });

    }
}
