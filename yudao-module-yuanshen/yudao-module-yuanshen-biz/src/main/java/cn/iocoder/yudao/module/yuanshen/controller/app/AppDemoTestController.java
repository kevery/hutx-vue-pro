package cn.iocoder.yudao.module.yuanshen.controller.app;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.yuanshen.service.YuanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;



@Tag(name = "用户 App - Test")
@RestController
@RequestMapping("/yuanshen/test")
@Validated
@Slf4j
public class AppDemoTestController {

    @Resource
    YuanService yuanService;

    @GetMapping("/get")
    @Operation(summary = "创建错误码")
    public CommonResult<String> get() {
        String qiandao = yuanService.qiandao("111");
        return success(qiandao);

    }

}