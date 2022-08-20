package cn.skyln.common.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: lamella
 * @Date: 2022/08/20/11:33
 * @Description:
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String pwd;
    private String headImg;
    private String phone;
    private Date createTime;
    private String wechat;
}
