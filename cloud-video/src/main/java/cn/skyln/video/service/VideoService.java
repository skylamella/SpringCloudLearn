package cn.skyln.video.service;

import cn.skyln.common.domain.entity.Video;

/**
 * @Author: lamella
 * @Date: 2022/08/20/14:45
 * @Description:
 */
public interface VideoService {

    Video findOneById(int videoId);
}
