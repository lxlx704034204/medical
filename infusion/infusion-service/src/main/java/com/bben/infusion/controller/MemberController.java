package com.bben.infusion.controller;

import com.bben.common.entity.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户接口")
@RestController
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/login")
    public Result login(@ApiParam("用户名") @RequestParam String username,
                        @ApiParam("密码") @RequestParam String password){
        System.out.println("链接成功");
        return Result.success("登陆成功");

    }
}
