package com.htg.docker_test.controller;

import com.htg.common.result.CommonResult;
import com.htg.docker_test.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(value = "TestContoller", tags = "测试项目")
@RestController
@Validated
@RequestMapping("/user")
public class TestContoller {
    @ApiOperation(value = "根据设备Mac地址,获取设备是否被认证了")
    @ResponseBody
    @GetMapping("/info")
    public CommonResult<UserVO> getUser() {
        UserVO userVO = new UserVO();
        userVO.setUsername("htg");
        userVO.setPassword("pass");
        return CommonResult.success(userVO);
    }
}
