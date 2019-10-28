package com.frace.producer;

import com.frace.common.MessageEntity;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * Created by frace on 2019/10/28 11:52
 */
@Component
public class SimpleProducer {

    @Autowired
    @Qualifier("kafkaTemplate")
    private KafkaTemplate<String, MessageEntity> kafkaTemplate;

    public void send(String topic, MessageEntity messageEntity) {
        kafkaTemplate.send(topic, messageEntity);
    }

    public void send(String topic, String key, MessageEntity messageEntity) {
        ProducerRecord<String, MessageEntity> record = new ProducerRecord<>(topic, key, messageEntity);

        long startTime = System.currentTimeMillis();

        ListenableFuture<SendResult<String, MessageEntity>> future = kafkaTemplate.send(record);
        future.addCallback(new ProducerCallback(startTime, key, messageEntity) );

    }
}
