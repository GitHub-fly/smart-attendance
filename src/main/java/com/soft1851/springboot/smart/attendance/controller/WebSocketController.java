package com.soft1851.springboot.smart.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author ke
 * @ClassName WebSocketController
 * @Description TOOD
 * @Date 2020/6/16
 * @Version 1.0
 **/
@RestController
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/sendToUser")
    public void sendToUserByTemplate(Map<String, String> params) {
        String fromUserId = params.get("fromUserId");
        String toUserId = params.get("toUserId");
        String msg = "来自" + fromUserId + "消息:" + params.get("msg");
        String destination = "/topic/user" + toUserId;
        template.convertAndSend(destination, msg);
    }

    @MessageMapping("/sendToAll")
    public void sendToAll(String msg) {
        String destination = "/topic/chat";
        template.convertAndSend(destination, msg);
    }

    @GetMapping("/send")
    public String msgReply(@RequestParam String msg) {
        template.convertAndSend("/topic", msg);

        //可以不用返回值
        return msg;
    }


}
