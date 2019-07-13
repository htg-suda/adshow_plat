package com.htg.common.vo.good.user;

import com.htg.common.vo.good.base.SpuGoodSpecValueVo;
import com.htg.common.vo.good.shop.ShopGoodSpuVo;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class UserGoodSpuDetailVo extends UserGoodSpuVo {
    @ApiModelProperty(value = " 商品副图,字符串", example = " xxxx.png;xxxx.png")
    private String subImg;


    @ApiModelProperty(value = " 商品描述详情,是一段html富文本", example = "<html>hello world</html>", required = true)
    private String detailDesc;


    @ApiModelProperty(value = "商品收藏数量", example = "0", hidden = true)
    private Integer collectNum;

    @ApiModelProperty(value = "商品规格参数值")
    private List<UserSpuGoodSpecValueVo> specValueVoList;

    public String getSubImg() {
        return subImg;
    }

    public void setSubImg(String subImg) {
        this.subImg = subImg;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }


    public List<UserSpuGoodSpecValueVo> getSpecValueVoList() {
        return specValueVoList;
    }

    public void setSpecValueVoList(List<UserSpuGoodSpecValueVo> specValueVoList) {
        this.specValueVoList = specValueVoList;
    }

    @Override
    public String toString() {
        return "UserGoodSpuDetailVo{" +
                "subImg='" + subImg + '\'' +
                ", detailDesc='" + detailDesc + '\'' +
                ", collectNum=" + collectNum +
                ", specValueVoList=" + specValueVoList +
                '}';
    }
}
