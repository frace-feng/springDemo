package com.frace.controller;

import com.frace.common.ErrorCode;
import com.frace.common.MessageEntity;
import com.frace.common.Response;
import com.frace.producer.SimpleProducer;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by frace on 2019/10/28 12:20
 */
@Slf4j
@Controller
@RequestMapping("kafka")
public class ProducerController {
    @Autowired
    private SimpleProducer simpleProducer;

    @Value("${kafka.topic.default}")
    private String topic;
    private Gson gson = new Gson();

    @GetMapping("/hello")
    @ResponseBody
    public Response sendKafka() {
        return new Response(ErrorCode.SUCCESS, "success");
    }

    @PostMapping("/send")
    @ResponseBody
    public Response send(@RequestBody MessageEntity messageEntity) {
        try {
            log.info("kafka info: ", gson.toJson(messageEntity));
            simpleProducer.send(topic, "key", messageEntity);
            log.info("发生成功");
            return new Response(ErrorCode.SUCCESS,"send successfully");
        }catch (Exception e){
            log.info("发生失败",e.getMessage());
            return new Response(ErrorCode.EXCEPTION,"send falure");
        }
    }
}
