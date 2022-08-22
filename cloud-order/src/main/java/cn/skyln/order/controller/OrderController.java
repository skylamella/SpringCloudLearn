package cn.skyln.order.controller;

import cn.hutool.json.JSONObject;
import cn.skyln.common.domain.entity.VideoOrder;
import cn.skyln.common.statics.apis.VideoAPI;
import cn.skyln.common.statics.types.JsonCode;
import cn.skyln.common.statics.types.JsonMessage;
import cn.skyln.common.utils.JsonReturn;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Objects;

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
    private RestTemplate restTemplate;

    @PostMapping("/pri/new_order/{videoId}")
    public String newVideoOrder(@PathVariable("videoId") String videoId) {
        log.info("【url】 {}", VideoAPI.VIDEO_SERVICE_HOST + VideoAPI.FIND_ONE_VIDEO + videoId);
        JSONObject jsonObject = restTemplate.getForObject(VideoAPI.VIDEO_SERVICE_HOST + VideoAPI.FIND_ONE_VIDEO + videoId, JSONObject.class);
        if (Objects.isNull(jsonObject)) {
            log.warn("【{}】 {}", JsonCode.NO_DATA_CODE, JsonMessage.NO_DATA_MESSAGE);
            return JsonReturn.returnJson(JsonCode.NO_DATA_CODE, JsonMessage.NO_DATA_MESSAGE);
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
}