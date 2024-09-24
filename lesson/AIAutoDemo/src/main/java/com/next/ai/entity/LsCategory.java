package com.next.ai.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;

/**
 * 商品类目(LsCategory)表实体类
 *
 * @author jiangzhiwei
 * @since 2024-07-23 14:06:09
 */
@TableName("ls_category")
public class LsCategory extends Model<LsCategory> {
    //分类ID
    private Integer id;
    //分类名称
    private String name;
    //分类编码，规则：1000+id，一共4位
    @TableField(value = "`code`")
    private String code;
    //排序，值越低，排靠前
    private Integer sort;
    //-1 下架 0 上架
    private Integer status;
    //类目 1,2,3,一共三级
    private Integer level;
    //上级ID，根类目就是 0
    private Integer parentId;
    //创建时间
    private Date createdAt;
    //更新时间
    private Date updatedAt;
    //创建用户ID
    private Integer createdUserId;
    //创建用户名
    private String createdUserName;
    //更新用户ID
    private Integer updatedUserId;
    //更新用户名
    private String updatedUserName;
    //版本号
    private Integer version;
    //删除状态 0:未删除；1：已删除
    private Integer deleted;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Integer createdUserId) {
        this.createdUserId = createdUserId;
    }

    public String getCreatedUserName() {
        return createdUserName;
    }

    public void setCreatedUserName(String createdUserName) {
        this.createdUserName = createdUserName;
    }

    public Integer getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Integer updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public String getUpdatedUserName() {
        return updatedUserName;
    }

    public void setUpdatedUserName(String updatedUserName) {
        this.updatedUserName = updatedUserName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */

    }

