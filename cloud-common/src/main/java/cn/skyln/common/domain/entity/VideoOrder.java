package cn.skyln.common.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: lamella
 * @Date: 2022/08/20/11:34
 * @Description:
 */
@Data
public class VideoOrder {
    private Integer id;
    private String outTradeNo;
    private Integer state;
    private Date createTime;
    private Integer totalFee;
    private Integer videoId;
    private String videoTitle;
    private String videoImg;
    private Integer userId;
}
