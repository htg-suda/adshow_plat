package com.htg.adshow.controller.inner;

import com.htg.adshow.service.IDeviceService;
import com.htg.adshow.service.IPlayRecordService;
import com.htg.adshow.service.IShowService;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.vo.adshow.SellerDeviceStatisticsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(value = "AdshowInnerController", tags = "11-内部调用")
@RestController
@Validated
@RequestMapping("/inner")
public class InnerController {
    /* 获取某个商户的设备数量,广告数量 */
    @Autowired
    private IDeviceService deviceService;

    @Autowired
    private IShowService showService;

    @Autowired
    private IPlayRecordService playRecordService;


    @ApiOperation(value = "根据商户sn统计信息")
    @ResponseBody
    @PostMapping("/statistics/{sellerSN}")
    public CommonResult<SellerDeviceStatisticsVO> statistics(@PathVariable("sellerSN") String sellerSN) throws GlobalException {
        Integer deviceCount = deviceService.getDeviceCountBySN(sellerSN);
        Integer playCount = showService.getShowCountBySN(sellerSN);
        Integer showCount = playRecordService.getPlayCountBySN(sellerSN);
        SellerDeviceStatisticsVO sellerDeviceStatisticsVO = new SellerDeviceStatisticsVO();
        sellerDeviceStatisticsVO.setDeviceCount(deviceCount);
        sellerDeviceStatisticsVO.setDeviceCount(playCount);
        sellerDeviceStatisticsVO.setShowCount(showCount);
        return CommonResult.success(sellerDeviceStatisticsVO);
    }


}
