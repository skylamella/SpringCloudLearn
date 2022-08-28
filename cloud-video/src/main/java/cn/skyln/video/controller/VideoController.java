package cn.skyln.video.controller;

import cn.skyln.common.domain.entity.Video;
import cn.skyln.common.statics.JsonCode;
import cn.skyln.common.statics.JsonMessage;
import cn.skyln.common.utils.JsonReturn;
import cn.skyln.common.utils.StaticValidation;
import cn.skyln.video.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @Author: lamella
 * @Date: 2022/08/20/12:33
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/video")
public class VideoController {

    @Autowired
    private VideoService videoService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/pub/findOne/{videoId}")
    public String findOneVideo(@PathVariable(value = "videoId") String videoId) {
        if (StaticValidation.stringIsNumeric(videoId)) {
            Video video = videoService.findOneById(Integer.parseInt(videoId));
            if (Objects.isNull(video)) {
                log.warn("【{}】 {}", JsonCode.NO_DATA_CODE, JsonMessage.NO_DATA_MESSAGE);
                return JsonReturn.returnJson(JsonCode.NO_DATA_CODE, JsonMessage.NO_DATA_MESSAGE);
            }
            log.info("【{}】 {}", JsonCode.SUCCESS_CODE, JsonMessage.SEARCH_SUCCESS_MESSAGE);
            return JsonReturn.returnJson(JsonCode.SUCCESS_CODE, JsonMessage.SEARCH_SUCCESS_MESSAGE, video);
        } else {
            log.error("【{}】 {} ({}{})", JsonCode.DATA_SPECIFICATION_CODE, JsonMessage.DATA_SPECIFICATION_MESSAGE, JsonMessage.ERROR_DATA_MESSAGE, videoId);
            return JsonReturn.returnJson(JsonCode.DATA_SPECIFICATION_CODE, JsonMessage.DATA_SPECIFICATION_MESSAGE, videoId);
        }
    }
}
