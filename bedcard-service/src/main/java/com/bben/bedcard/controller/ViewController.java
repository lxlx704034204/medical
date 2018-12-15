package com.bben.bedcard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/16 9:52
 */
@Controller
@RequestMapping(value = "/view")
public class ViewController {

    private static final String INDEX_PATH_NAME = "index";

    /**
     * 获取 index页面
     */
    @RequestMapping(method = RequestMethod.GET)
    public String toIndex() {
        return INDEX_PATH_NAME;
    }
}
