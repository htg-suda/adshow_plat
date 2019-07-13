package com.htg.common.dto.adshow;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AgencyPageDTO {
    @ApiModelProperty(value = "机构编号", example = "0010")
    private String num;

    @Pattern(regexp = "^[1](([3|5|8][\\d])|([4][5,6,7,8,9])|([6][5,6])|([7][3,4,5,6,7,8])|([9][8,9]))[\\d]{8}$",
            message = "手机号码不合法")
    @ApiModelProperty(value = "机构联系手机号码", example = "18717919375")
    private String contactNum;

    @Length(max = 16, min = 1, message = "机构联系人姓名不能大于16位")
    @ApiModelProperty(value = "机构联系人", example = "小明")
    private String contact;

    @NotNull(message = "第几页不能为空")
    @ApiModelProperty(value = "第几页", example = "0")
    private Integer pageNum;

    @NotNull(message = "每页大小不能为空")
    @ApiModelProperty(value = "每页大小", example = "0")
    private Integer pageSize;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "AgencyPageDTO{" +
                "num='" + num + '\'' +
                ", contactNum='" + contactNum + '\'' +
                ", contact='" + contact + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
