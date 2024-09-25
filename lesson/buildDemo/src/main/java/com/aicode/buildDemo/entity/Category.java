package com.aicode.buildDemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("ls_category")
public class Category {
    @TableId
    private Integer id;
    private String name;
    private String code;
    private Integer sort;
    private Integer status;
    private Integer level;
    private Integer parentId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer createdUserId;
    private String createdUserName;
    private Integer updatedUserId;
    private String updatedUserName;
    private Integer version;
    private Integer deleted;
}