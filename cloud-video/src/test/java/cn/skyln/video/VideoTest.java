package cn.skyln.video;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: lamella
 * @Date: 2022/08/20/15:19
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class VideoTest {

    @Test
    public void test1() {
        log.info("info");
        log.debug("debug");
        log.error("error");
        log.warn("warn");
    }

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void redisSet() {
        redisTemplate.opsForValue().set("name", "redisTemplate");
    }

    @Test
    public void redisGet() {
        log.info("redisTemplate get name: {}", redisTemplate.opsForValue().get("name"));
        log.info("stringRedisTemplate get name: {}", stringRedisTemplate.opsForValue().get("name"));
    }
}
