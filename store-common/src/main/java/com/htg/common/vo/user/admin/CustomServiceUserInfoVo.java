package com.htg.common.vo.user.admin;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class CustomServiceUserInfoVo {

    @ApiModelProperty(value = "用户名", example = "htg")
    private String username;


    @ApiModelProperty(value = "用户电子邮箱", example = "123@qq.com")
    private String email;


    @ApiModelProperty(value = " 用户年龄", example = "23")
    private Integer age;


    @ApiModelProperty(value = "性别 1-男 2-女 0-保密", example = "1")
    private Integer gender;


    @ApiModelProperty(value = "用户手机号码", example = "18717919375")
    private String tel;

    @ApiModelProperty(value = "创建时间", example = "2019-09-23")
    private Date updateTime;


    @ApiModelProperty(value = "客服昵称", example = "会飞的鱼")
    private String serviceName;


    @ApiModelProperty(value = "客服真实姓名", example = "张三")
    private String realName;


    @ApiModelProperty(value = "客服ID", example = "1")
    private Integer id;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "CustomServiceUserInfoVo{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", tel='" + tel + '\'' +
                ", updateTime=" + updateTime +
                ", serviceName='" + serviceName + '\'' +
                ", realName='" + realName + '\'' +
                ", id=" + id +
                '}';
    }
}
