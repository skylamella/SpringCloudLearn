package cn.skyln.video;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;

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
    public void test1(){
        log.info("info");
        log.debug("debug");
        log.error("error");
        log.warn("warn");
    }
}
