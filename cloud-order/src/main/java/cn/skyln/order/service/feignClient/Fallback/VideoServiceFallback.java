package cn.skyln.order.service.feignClient.Fallback;

import cn.skyln.common.domain.entity.Video;
import cn.skyln.common.statics.JsonCode;
import cn.skyln.common.statics.JsonMessage;
import cn.skyln.common.utils.JsonReturn;
import cn.skyln.order.service.feignClient.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: lamella
 * @Date: 2022/08/26/20:50
 * @Description:
 */
@Slf4j
@Service
public class VideoServiceFallback implements VideoService {
    @Override
    public String findOneById(String videoId) {
        Video video = new Video();
        video.setTitle("熔断降级数据");
        log.info("【{}】 熔断降级数据", JsonCode.SUCCESS_CODE);
        return JsonReturn.returnJson(JsonCode.SUCCESS_CODE, video);
    }
}
