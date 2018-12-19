package com.bben.samiservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping()
public class WebSocketController {
    @GetMapping("/infusion")
    public String webSocket() throws IOException {
        return "webSocket";
    }

    @GetMapping("/call")
    public String webSocketTest() throws IOException {
        return "webSocket1";
    }

}
