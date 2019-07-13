package com.htg.common.dto.custom;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

public class CustomServiceUserModifyDTO {

    @Pattern(regexp = "^[a-zA-Z]{1}[a-zA-Z0-9_]{5,16}$", message = "由字母数字下划线组成且开头必须是字母,位数6~16位")
    @ApiModelProperty(value = "用户名", example = "htg")
    @TableField("username")
    private String username;


    @Pattern(regexp = "^[a-zA-Z0-9]{6,20}$", message = "密码必须是字母和数字的组合,且位数为6~20位")
    @ApiModelProperty(value = "用户密码", example = "123qwe")
    @TableField("password")
    private String password;


    @NotBlank(message = "手机号码不能为空")
    @Pattern(regexp = "^[1](([3|5|8][\\d])|([4][5,6,7,8,9])|([6][5,6])|([7][3,4,5,6,7,8])|([9][8,9]))[\\d]{8}$",
            message = "用户手机号码不合法")
    @ApiModelProperty(value = "用户手机号码", example = "18717919375")
    private String tel;


    @Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
            message = "用户电子邮箱不合法")
    @ApiModelProperty(value = "用户电子邮箱", example = "123@qq.com")
    private String email;


    @Min(value = 0, message = "年龄不可小于0")
    @Max(value = 200, message = "年龄不可大于200")
    @ApiModelProperty(value = " 用户年龄", example = "23")
    private Integer age;


    @ApiModelProperty(value = "性别 1-男 2-女 0-保密", example = "1")
    private Integer gender;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
        return "CustomServiceInfoModifyDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
