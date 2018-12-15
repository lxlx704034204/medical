package com.bben.medical.controller;

import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.JsonUtil;
import com.bben.common.util.U;
import com.bben.medical.dto.TPcaDto;
import com.bben.medical.model.medical.TPca;
import com.bben.medical.service.TPcaService;
import com.bben.medical.vo.TPcaVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "PCA地址接口")
@RestController
@RequestMapping(value = "/pca")
public class PcaController extends BaseController {

    @Autowired
    private TPcaService tPcaService;

    @PostMapping("/add")
    @ApiOperation("添加PCA记录 -> 陈旭东")
    public Result addTPca(TPcaDto tPcaDto) {
        //转换成需要显示的类型
        TPca tPca = JsonUtil.convert(tPcaDto, TPca.class);
        TPca ok = tPcaService.insertSelective(tPca);

        if (U.isBlank(ok)) {
            return Result.fail("add地址信息失败");
        }

        log.info("Return PcaCode:" + ok.getPcaCode());
        return Result.success("添加地址记录成功");
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除地址记录 -> 陈旭东")
    public Result delTPca(@ApiParam("pcaCode") @RequestParam String pcaCode) {
        int ok = tPcaService.deleteByPrimaryKey(pcaCode);
        if (ok == 0) {
            return Result.fail("删除地址信息失败");
        }

        return Result.success("删除地址信息成功");
    }

    @PostMapping("/update")
    @ApiOperation("修改地址记录 -> 陈旭东")
    public Result updateTPca(TPca tPca) {
        TPca TPca1 = tPcaService.updateByPrimaryKey(tPca);
        if (U.isBlank(TPca1)) {
            return Result.fail("修改地址信息失败");
        }
        return Result.success("修改地址信息成功");
    }

    @GetMapping("/select")
    @ApiOperation("获取地址信息 -> 陈旭东")
    public Result<TPcaVo> selecTPca(@ApiParam("pcaCode") @RequestParam String pcaCode) {
        TPca tPca = tPcaService.selectByPrimaryKey(pcaCode);
        if (U.isBlank(tPca)) {
            return Result.fail("无地址数据");
        }

        //转换成需要显示的类型
        TPcaVo tPcaVo = JsonUtil.convert(tPca, TPcaVo.class);

        return Result.success("获取地址信息成功", tPcaVo);
    }

    @GetMapping("/findByCondition")
    @ApiOperation("根据条件查找地址信息 -> 陈旭东")
    public Result<PageInfo<TPca>> findByCondition(TPca tPca,
                                                    @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                    @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageInfo<TPca> pageInfoTPca = tPcaService.findByCondition(tPca, pageNum, pageSize);
        if (U.isBlank(pageInfoTPca)) {
            return Result.fail("无地址数据");
        }

        return Result.success("根据条件查找地址信息成功", pageInfoTPca);
    }
}
