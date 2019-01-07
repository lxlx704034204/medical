package com.bben.samiservice.controller;

import com.bben.common.BaseController;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.U;
import com.bben.samiservice.Dto.DeptDto;
import com.bben.samiservice.constants.ReturnMessage;
import com.bben.samiservice.model.samiservice.TDept;
import com.bben.samiservice.service.TDeptService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@Api(tags = "jiekou")
@RequestMapping("/dept")
@Component
public class DeptController extends BaseController {

    private static DeptController  deptController;

    @PostConstruct //通过@PostConstruct实现初始化bean之前进行的操作
    public void init() {
        deptController = this;
        deptController.tDeptService = this.tDeptService;
        /*socketServer.tDoctorService = this.tDoctorService;
        socketServer.tNurseService = this.tNurseService;*/
        // 初使化时将已静态化的testService实例化
    }

    @Autowired
    private TDeptService tDeptService;

    @GetMapping("/selectAll")
    public Result selectAll(){
        List<TDept> tDeptList = deptController.tDeptService.selectAll();
        return Result.success(ReturnMessage.SUCCECSS,tDeptList);
    }

    @PostMapping("/add.do")
    public Result add(DeptDto deptDto){
        TDept tDept = tDeptService.operationDept(DeptDto.assemblyData(deptDto));
        if (U.isBlank(tDept)){
            return Result.fail(ReturnMessage.ERROR);
        }
         return Result.success(ReturnMessage.SUCCECSS);
    }
}
