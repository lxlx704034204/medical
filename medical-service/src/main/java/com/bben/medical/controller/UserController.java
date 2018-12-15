package com.bben.medical.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.JsonUtil;
import com.bben.common.util.U;
import com.bben.medical.service.TUserService;
import com.bben.medical.dto.TUserDto;
import com.bben.medical.model.medical.TUser;
import com.bben.medical.vo.TUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Api(tags = "范例接口")
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private TUserService tUserService;

//    @Autowired
//    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/callUrlFuntion")
    @ApiOperation("远程调用接口 -> 陈旭东")
    @HystrixCommand(fallbackMethod = "calUrlError")
    public Result callUrlFuntion(String userId) {
//        RestTemplate client = restTemplateBuilder.build();

//        String ddd = "http://localhost:8080/user/getUserByPage?pageNum=1&pageSize=4";
//        Result tUser = client.getForObject(ddd, Result.class);

//        String url = "http://localhost:8080/user/select?userId={userId}";
        String url = "http://ai-service/user/select?userId={userId}";
        Result tUser = restTemplate.getForObject(url, Result.class, userId);

        return tUser;
    }

    public Result calUrlError(String userId) {
        return null;
    }

    public Result addUserError(TUserDto tUserDto) {
        return Result.fail("add用户信息失败！！！");
    }

    @PostMapping("/add")
    @ApiOperation("添加用户记录 -> 陈旭东")
    @HystrixCommand(fallbackMethod = "addUserError")
    public Result addTUser(TUserDto tUserDto) {
        //转换成需要显示的类型
        TUser tUser = JsonUtil.convert(tUserDto, TUser.class);
        TUser ok = tUserService.insertSelective(tUser);

        if (U.isBlank(ok)) {
            return Result.fail("add用户信息失败");
        }

        log.info("Return UserId:" + ok.getId());
        return Result.success("添加用户记录成功");
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除用户记录 -> 陈旭东")
    public Result delTUser(@ApiParam("用户id") @RequestParam Integer userId) {
        int ok = tUserService.deleteByPrimaryKey(userId);
        if (ok == 0) {
            return Result.fail("删除用户信息失败");
        }

        return Result.success("删除用户信息成功");
    }

    @PostMapping("/update")
    @ApiOperation("修改用户记录 -> 陈旭东")
    public Result updateTUser(TUser tUser) {
        TUser tUser1 = tUserService.updateByPrimaryKey(tUser);
        if (U.isBlank(tUser1)) {
            return Result.fail("修改用户信息失败");
        }
        return Result.success("修改用户信息成功");
    }

    @GetMapping("/select")
    @ApiOperation("获取用户信息 -> 陈旭东")
    public Result<TUserVo> selectUser(@ApiParam("用户id") @RequestParam Integer userId) {
        TUser tUser = tUserService.selectByPrimaryKey(userId);
        if (U.isBlank(tUser)) {
            return Result.fail("无用户数据");
        }

        //转换成需要显示的类型
        TUserVo TUserVo = JsonUtil.convert(tUser, TUserVo.class);

        return Result.success("获取用户信息成功", TUserVo);
    }

    @GetMapping("/all")
    @ApiOperation("获取所有用户信息 -> 陈旭东")
    public Result<List<TUser>> allTUser() {
        List<TUser> listTUser = tUserService.findAllTUser();
        if (A.isEmpty(listTUser)) {
            return Result.fail("无用户数据");
        }

        return Result.success("获取所有用户信息成功", listTUser);
    }

    @GetMapping("/findByCondition")
    @ApiOperation("根据条件查找用户信息 -> 陈旭东")
    public Result<PageInfo<TUser>> findByCondition(TUser tUser,
                                                     @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                     @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageInfo<TUser> pageInfoTUser = tUserService.findByCondition(tUser, pageNum, pageSize);
        if (U.isBlank(pageInfoTUser)) {
            return Result.fail("无用户数据");
        }

        return Result.success("根据条件查找用户信息成功", pageInfoTUser);
    }

    @GetMapping("/getUserByPage")
    @ApiOperation("分页用户信息 -> 陈旭东")
    public Result<PageInfo<TUserVo>> getTUserByPage(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {

        PageInfo<TUser> pageInfo = tUserService.findByPage(pageNum, pageSize);

        //        Integer.valueOf("dfdfdf");

        //取出需要转换的页内容
        List<TUser> listTUser = pageInfo.getList();

        //屏蔽一些字段，只显示TuserVo中的字段
        List<TUserVo> listTUserVo = JsonUtil.convertList(listTUser, TUserVo.class);

        //把原来的分页数据拷贝过来，如：当前页,每页的数量,总记录数,总页数,是否为第一页,是否为最后一页
        PageInfo<TUserVo> pageInfoVo = JsonUtil.convert(pageInfo, TUserVo.class);
        //放入转换后的内容
        pageInfoVo.setList(listTUserVo);

        return Result.success("分页用户信息成功", pageInfoVo);
    }

    @PostMapping("/getUsers")
    @ApiOperation("getUsers -> 陈旭东")
    public Result<TUser> getUsers(@RequestBody TUser tUser) {

        return Result.success("获取用户信息成功", tUser);
    }
}
