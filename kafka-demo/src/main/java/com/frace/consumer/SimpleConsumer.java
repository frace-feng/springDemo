package com.frace.consumer;

import com.frace.common.MessageEntity;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by frace on 2019/10/28 11:49
 */
@Slf4j
@Component
public class SimpleConsumer {
    private final Gson gson = new Gson();

    @KafkaListener(topics = "${kafka.topic.default}", containerFactory = "kafkaListenerContainerFactory")
    public void receive(MessageEntity messageEntity) {
        log.info(gson.toJson(messageEntity));
    }
}
