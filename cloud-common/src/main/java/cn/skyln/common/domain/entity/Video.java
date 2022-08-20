package cn.skyln.common.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: lamella
 * @Date: 2022/08/20/11:34
 * @Description:
 */
@Data
public class Video {
    private Integer id;
    private String title;
    private String summary;
    private String coverImg;
    private Integer  price;
    private Date createTime;
    private Double point;
}
