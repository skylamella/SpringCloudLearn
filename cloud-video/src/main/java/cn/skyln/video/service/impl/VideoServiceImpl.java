package cn.skyln.video.service.impl;

import cn.skyln.common.domain.entity.Video;
import cn.skyln.video.mapper.VideoMapper;
import cn.skyln.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lamella
 * @Date: 2022/08/20/14:45
 * @Description:
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Video findOneById(int videoId) {
        return videoMapper.findOneById(videoId);
    }
}
