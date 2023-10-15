package com.gaoxinzhi.www.database.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@lombok.Data
@TableName("person")
public class Data {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("person_id")
    private Integer personId;
    @TableField("person_name")
    private String personName;
    private Integer age;
    private String company;
    private String address;
    private String phone;
    @TableField("gmt_create")
    private Date gmtCreate;
    @TableField("gmt_modified")
    private Date gmtModified;
}
