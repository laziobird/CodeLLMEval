package ai.next.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 医生信息
 * @author jiangzhiwei
 * @date 2024/1/2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto implements Serializable {
    private Integer id;
    private String dataId;
    private Date startWorkTimeStr;
    private String doctorAvatarUrl;
    private String doctorCertUrl;
    private String clinicLicenseUrl;
    /**
     * 所属诊所
     */
    private String clinicCode;

    /**
     * 所属诊所
     */
    private String clinicName;

    /**
     * 医生账号
     */
    private String userName;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 加密盐
     */
    @JsonIgnore
    private String salt;

    /**
     * 中文名
     */
    private String realName;



    /**
     * 诊所ID
     */
    private Integer clinicId;

    /**
     * 第三方医生ID
     */
    private String thirdPartyDoctorId;

    /**
     * 从医开始时间
     */
    private Long startWorkTime;

    /**
     * 证书编号
     */
    private String certNumber;

    /**
     * C端注册时填写的诊所名称
     */
    private String registerClinicName;

    /**
     * 性别
     */
    private Byte sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 微信ID
     */
    private String openid;
    private String openidLs;

    private String unionId;

    /**
     * 出生日期
     */
    private Integer birthDate;
    private Date birthDateStr;

    /**
     * 用户头像
     */
    private String logo;

    /**
     * 注册省份
     */
    private String registerProvince;

    /**
     * 注册城市
     */
    private String registerCity;

    /**
     * 注册县区
     */
    private String registerArea;

    /**
     * 注册详细地址
     */
    private String registerAddress;

    /**
     * 二维码状态
     */
    private Byte qrCodeStatus;

    /**
     * 审核状态
     */
    private Byte checkStatus;

    /**
     * 状态
     */
    private Byte status;

    /**
     * 资格证书
     */
    private String certUrl;

    /**
     * 是否在线
     */
    private Byte isOnline;

    /**
     * 登录版本号（防止多人同时用一个账号）
     */
    private Integer loginVersion;

    /**
     * 最后登录时间
     */
    private Integer lastLoginTime;

    /**
     * 创建用户ID
     */
    private Integer createdUserId;

    /**
     * 创建用户名
     */
    private String createdUserName;

    /**
     * 创建时间
     */
    private Integer createdAt;

    /**
     * 最后修改时间
     */
    private Integer updatedAt;

    /**
     * 软删除时间
     */
    private Integer deletedAt;

    /**
     * TOKEN
     */
    private String token;

    /**
     * TOKEN效期
     */
    private Integer tokenExpireTime;

    private static final long serialVersionUID = 1L;


    /**
     * 证书信息
     */
    private String certInfos;
    
    /**
     * 证书信息
     */
    private List<CertInfoDto> certInfoList;

    /**
     * 医生背景
     */
    private String doctorBackground;

    /**
     * 医生背景其他内容
     */
    private String doctorBackgroundOther;

    /**
     * 毕业院校
     */
    private String graduateSchool;

    /**
     * 最高学历
     */
    private String highestEducation;

    /**
     * 最高学历其他内容
     */
    private String highestEducationOther;

    /**
     * 正畸量
     */
    private String orthodonticsNum;

    /**
     * 正畸结束cases
     */
    private String orthodonticsEndCases;

    /**
      * 医生偏好
     */
    private String preferences;
    
    /**
       * 医生偏好
     */
    private List<String> preferenceList;

    /**
     * 设置默认初始值
     */
    public void setDefaultValues() {
        salt = "";
        startWorkTime = 0L;
        certNumber = "";
        registerClinicName = "";
        email = "";
        mobile = "";
        openid = "";
        openidLs = "";
        unionId = "";
        birthDate = 0;
        logo = "";
        qrCodeStatus = 0;
        checkStatus = 5;
        status = 5;
        isOnline = 40;
        loginVersion = 0;
        lastLoginTime = 0;
        createdUserId = 0;
        createdUserName = "";
        updatedAt = 0;
        deletedAt = 0;
        clinicCode = "";
        clinicName = "";
        certUrl = "";
        dataId = "";
    }
}