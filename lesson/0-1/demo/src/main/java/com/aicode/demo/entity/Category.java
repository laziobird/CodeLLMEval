package com.aicode.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("category")
public class Category {
    @TableId
    private Long id;
    private String name;
    private Integer level;
    private Long parentId;
    private String path;
    private Integer status;
    private Integer sort;
    private String remarks;
    private Long createId;
    private Long updateId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}