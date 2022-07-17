package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

@Data
@TableName("t_artical")
public class Artical extends Model<Artical> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String title;
    private String content;
    private Integer readCount;
    private String username;
    private String time;
    private String tag;
    private String category;
    private String description;
    private String cover;

}
