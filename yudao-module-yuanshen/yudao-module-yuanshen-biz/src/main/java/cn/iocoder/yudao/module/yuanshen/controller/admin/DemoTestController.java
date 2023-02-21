package cn.iocoder.yudao.module.yuanshen.controller.admin;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
@Tag(name = "管理后台 - Test")
@RestController
@RequestMapping("/yuanshen/test")
@Validated
@Slf4j
public class DemoTestController {

    @GetMapping("/get")
    @Operation(summary = "创建错误码")
    public CommonResult<String> get() {
        return success("true");
    }

}