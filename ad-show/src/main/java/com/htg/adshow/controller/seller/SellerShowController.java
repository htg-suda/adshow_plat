package com.htg.adshow.controller.seller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.htg.adshow.service.IShowService;
import com.htg.common.dto.adshow.ShowDTO;
import com.htg.common.entity.adshow.Show;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespPage;
import com.htg.common.vo.adshow.ShowVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 节目表 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-07-08
 */
@Slf4j
@Api(value = "SellerShowController", tags = "05-卖家节目管理")
@RestController
@Validated
@RequestMapping("/seller/show")
public class SellerShowController {


}

