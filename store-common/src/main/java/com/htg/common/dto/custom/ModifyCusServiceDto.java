package com.htg.common.dto.custom;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ModifyCusServiceDto {
    @Valid
    @NotNull(message = "用户基本信息不能为空")
    private CustomServiceUserModifyDTO userModifyDTO;

    @Valid
    @NotNull(message = "客服基本信息不能为空")
    private CustomServiceInfoModifyDTO infoModifyDTO;


    public CustomServiceUserModifyDTO getUserModifyDTO() {
        return userModifyDTO;
    }

    public void setUserModifyDTO(CustomServiceUserModifyDTO userModifyDTO) {
        this.userModifyDTO = userModifyDTO;
    }

    public CustomServiceInfoModifyDTO getInfoModifyDTO() {
        return infoModifyDTO;
    }

    public void setInfoModifyDTO(CustomServiceInfoModifyDTO infoModifyDTO) {
        this.infoModifyDTO = infoModifyDTO;
    }

    @Override
    public String toString() {
        return "ModifyCusServiceDto{" +
                "userModifyDTO=" + userModifyDTO +
                ", infoModifyDTO=" + infoModifyDTO +
                '}';
    }
}
