package com.bben.bedcard.controller.sami;

import com.bben.bedcard.constants.HeadMethod;
import com.bben.bedcard.constants.ReturnMessage;
import com.bben.bedcard.dto.HeadDto;
import com.bben.common.BaseController;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.U;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Api(tags = "萨米医疗接口")
@RestController
@RequestMapping("/saMiHead")
public class HeadController extends BaseController {

    @Autowired
    RestTemplate restTemplate;

    public Result saMiHeadError(String jsonInfo) {
        return Result.fail(ReturnMessage.EXCEPTION);
    }

    @PostMapping("/saMiHead.do")
    @ApiOperation("萨米医疗中心接口 -> 李振伟")
    @HystrixCommand(fallbackMethod = "saMiHeadError")
    public Result headMethod(String jsonInfo) {
        if (U.isBlank(jsonInfo)) {
            return Result.fail(ReturnMessage.PARAMETER_IS_NULL);
        }
        try {
            //String url = "http://bedcard-service/user/select?userId={userId}";
            String url = "http://bedcard-service";
            /**
             * 先将json字符串转换为json对象
             */
            JSONObject obj = JSONObject.fromObject(jsonInfo);
            /**
             * 再将json对象转换为java对象
             */
            HeadDto headDto = (HeadDto)JSONObject.toBean(obj,HeadDto.class);
            if (U.isBlank(headDto.getController())){
                return Result.fail(ReturnMessage.PARAMETER_IS_ERROR);
            }
            MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
            paramMap.add("jsonInfo", jsonInfo);
            switch (headDto.getController()){
                case HeadMethod.SAMI_DEPT:
                    url += "/saMiDept/saMiDept.do?";
                    break;
                case HeadMethod.SAMI_DOCTOR:
                    url += "/saMiDoctor/saMiDoctor.do";
                    break;
                case HeadMethod.SAMI_HOSPITAL_DEPT:
                    url += "/saMiHospitalDept/saMiHospitalDept.do";
                    break;
                case HeadMethod.SAMI_NURSE:
                    url += "/saMiNurse/saMiNurse.do";
                    break;
                case HeadMethod.SAMI_PATIENT:
                    url += "/saMiPatient/saMiPatient.do";
                    break;
                case HeadMethod.SAMI_WARD:
                    url += "/saMiWard/saMiWard.do";
                    break;
                default:return Result.fail(ReturnMessage.METHOD_ERROR);
            }
            Result result = restTemplate.postForObject(url, paramMap,Result.class);
            paramMap.clear();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(ReturnMessage.EXCEPTION);
        }
    }
}
