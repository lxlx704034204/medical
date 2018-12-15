package com.bben.infusion.controller;

import com.alibaba.fastjson.JSON;
import com.bben.common.BaseController;
import com.bben.common.entity.vo.Result;
import com.bben.infusion.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.simple.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Api(tags = "rabbitmq")
@RestController
@RequestMapping(value = "/rabbit")
public class MailMQTest extends BaseController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static final String EXCHANGE_DIRECT_NOTICE_MAIL = "exchange.direct.notice.mail";
    public static final String QUEUE_NOTICE_MAIL_PLAIN = "notice.mail.plain";
    public static final String QUEUE_NOTICE_MAIL_HTML = "notice.mail.html";

    @GetMapping("/helloTest")
    @ApiOperation("rabbit send -> lsq")
    public Result<JSONObject> sendHello() {
        JSONObject m1 = new JSONObject();
        m1.put("to","hello title test");
        m1.put("subject","test the hello date subject");
        m1.put("text",DateUtil.SDF_STANDARD_HS.format(new Date()));
        String context = "this is hello test!";
        System.out.println("Sender : " + JSON.toJSONString(m1));
        rabbitTemplate.convertAndSend("mail.test", JSON.toJSONString(m1));
        return Result.success("rabbit send ok", "ok");

    }

}
