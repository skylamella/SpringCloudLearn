package cn.skyln.order.controller;

import cn.hutool.json.JSONObject;
import cn.skyln.common.domain.entity.VideoOrder;
import cn.skyln.common.statics.JsonCode;
import cn.skyln.common.statics.JsonMessage;
import cn.skyln.common.utils.JsonReturn;
import cn.skyln.order.service.feignClient.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: lamella
 * @Date: 2022/08/20/15:53
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/video_order")
public class OrderController {

    @Autowired
    private VideoService videoService;

    @PostMapping("/pri/new_order/{videoId}")
    public String newVideoOrder(@PathVariable(value = "videoId") String videoId) {
        JSONObject jsonObject = new JSONObject();
        try {
            String videoString = videoService.findOneById(videoId);
            if (StringUtils.isEmpty(videoString)) {
                log.error("【{}】 {}", JsonCode.NO_DATA_CODE, JsonMessage.NO_DATA_MESSAGE);
                return JsonReturn.returnJson(JsonCode.NO_DATA_CODE, JsonMessage.NO_DATA_MESSAGE);
            }
            jsonObject = new JSONObject(videoString);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("【{}】 {}", JsonCode.SYSTEM_NO_NACOS_INSTANCE, JsonMessage.SYSTEM_NO_NACOS_INSTANCE);
            return JsonReturn.returnJson(JsonCode.SYSTEM_NO_NACOS_INSTANCE, JsonMessage.SYSTEM_NO_NACOS_INSTANCE);
        }

        if (jsonObject.getInt("code") != 0) {
            if (StringUtils.isEmpty(jsonObject.getStr("dataBody"))) {
                log.error("【{}】 {}", jsonObject.getInt("code"), jsonObject.getStr("msg"));
                return JsonReturn.returnJson(jsonObject.getInt("code"), jsonObject.getStr("msg"));
            }
            log.error("【{}】 {} ({})", jsonObject.getInt("code"), jsonObject.getStr("msg"), jsonObject.getStr("dataBody"));
            return JsonReturn.returnJson(jsonObject.getInt("code"), jsonObject.getStr("msg"), jsonObject.getStr("dataBody"));
        }

        if (StringUtils.isEmpty(jsonObject.getStr("dataBody"))) {
            log.warn("【{}】 {}", JsonCode.NO_DATA_CODE, JsonMessage.NO_DATA_MESSAGE);
            return JsonReturn.returnJson(JsonCode.NO_DATA_CODE, JsonMessage.NO_DATA_MESSAGE);
        }

        JSONObject video = new JSONObject(jsonObject.getStr("dataBody"));
        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setVideoId(video.getInt("id"));
        videoOrder.setVideoTitle(jsonObject.getStr("title"));
        videoOrder.setVideoImg(jsonObject.getStr("cover_img"));
        videoOrder.setCreateTime(new Date());

        log.info("【{}】 {}", JsonCode.SUCCESS_CODE, JsonMessage.OPERATE_SUCCESS_MESSAGE);
        return JsonReturn.returnJson(JsonCode.SUCCESS_CODE, JsonMessage.OPERATE_SUCCESS_MESSAGE, videoOrder);
    }
    /**
     * @Description: 模拟线程池流控
     * @Author: lamella
     * @Date: 2022/8/25/21:53
     */
    @RequestMapping("list")
    public Object list() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<>();
        map.put("title1", "title1title1title1title1");
        map.put("title2", "title2title2title2title2");
        return map;
    }
}
