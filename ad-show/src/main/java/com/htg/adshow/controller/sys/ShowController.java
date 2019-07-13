package com.htg.adshow.controller.sys;

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
@Api(value = "ShowController", tags = "05-节目管理")
@RestController
@Validated
@RequestMapping("/show")
public class ShowController {
    @Autowired
    private IShowService showService;

    /* 新增节目 */
    @ApiOperation(value = "添加节目")
    @ResponseBody
    @PostMapping("/add")
    public CommonResult<RespId> addShow(@Valid @RequestBody ShowDTO showDTO) throws GlobalException {
        return showService.addShow(showDTO);
    }


    /* 新增节目 */
    @ApiOperation(value = "列出节目")
    @ResponseBody
    @GetMapping("/list/{pageNum}/{pageSize}")
    public CommonResult<RespPage<ShowVO>> addShow(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) throws GlobalException {
        Wrapper<Show> showWrapper = new EntityWrapper<>();
        Page<Show> page = new Page<>(pageNum, pageSize, "id", false);
        Page<Show> result = showService.selectPage(page);
        List<Show> records = result.getRecords();
        List<ShowVO> showVOList=new ArrayList<>();
        for(Show show:records){
            ShowVO showVO=new ShowVO();
            BeanUtils.copyProperties(show,showVO);
            showVOList.add(showVO);
        }
        return CommonResult.success(new RespPage<>(showVOList,page.getTotal()));
    }


}

