package cn.skyln.video;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: lamella
 * @Date: 2022/08/20/11:47
 * @Description:
 */
@SpringBootApplication
@MapperScan("cn.skyln.video.mapper")
@EnableDiscoveryClient
public class VideoApplication {
    public static void main(String[] args){
        SpringApplication.run(VideoApplication.class,args);
    }
}
