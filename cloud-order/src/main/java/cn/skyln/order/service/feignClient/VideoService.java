package cn.skyln.order.service.feignClient;

import cn.hutool.json.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: lamella
 * @Date: 2022/08/23/23:12
 * @Description:
 */
@FeignClient(name = "cloud-video")
public interface VideoService {
    @GetMapping(value = "/api/v1/video/pub/findOne/{videoId}")
    String findOneById(@PathVariable(value = "videoId") String videoId);
}
