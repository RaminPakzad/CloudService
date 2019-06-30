package com.micro.messaging.business.controller;

import com.micro.messaging.model.entity.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messaging")
public class MessagingController {

    @PostMapping(value="/send")
    public Message send(@RequestBody Message message){
        return message;
    }

}
