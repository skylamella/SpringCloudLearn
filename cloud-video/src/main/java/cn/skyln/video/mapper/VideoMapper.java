package cn.skyln.video.mapper;

import cn.skyln.common.domain.entity.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: lamella
 * @Date: 2022/08/20/14:45
 * @Description:
 */
@Repository
public interface VideoMapper {

    @Select("select * from video where id = #{videoId}")
    Video findOneById(@Param("videoId") int videoId);
}
