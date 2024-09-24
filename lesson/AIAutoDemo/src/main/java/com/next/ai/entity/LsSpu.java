package com.next.ai.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * spu 表(LsSpu)表实体类
 *
 * @author jiangzhiwei
 * @since 2024-09-16 11:45:47
 */
@TableName("ls_spu")
public class LsSpu extends Model<LsSpu> {
    //sku ID
    private Integer id;
    //名称，spu_name + 规格唯一确认
    private String name;
    //编码,规则：类目编码XXXX +idXXXX ,一共8位
    private String code;
    //-1 下架 0 上架
    private Integer status;
    //1 单品 2 套组
    private Integer type;
    //商品描述
    private String remark;
    //一级类目id
    private Integer categoryOneId;
    //二级类目id
    private Integer categoryTwoId;
    //三级类目id
    private Integer categoryThreeId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCategoryOneId() {
        return categoryOneId;
    }

    public void setCategoryOneId(Integer categoryOneId) {
        this.categoryOneId = categoryOneId;
    }

    public Integer getCategoryTwoId() {
        return categoryTwoId;
    }

    public void setCategoryTwoId(Integer categoryTwoId) {
        this.categoryTwoId = categoryTwoId;
    }

    public Integer getCategoryThreeId() {
        return categoryThreeId;
    }

    public void setCategoryThreeId(Integer categoryThreeId) {
        this.categoryThreeId = categoryThreeId;
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


    }

