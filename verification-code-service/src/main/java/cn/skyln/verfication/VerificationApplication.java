package cn.skyln.verfication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: lamella
 * @Date: 2022/08/28/18:06
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class VerificationApplication {
    public static void main(String[] args){
        SpringApplication.run(VerificationApplication.class,args);
    }
}
