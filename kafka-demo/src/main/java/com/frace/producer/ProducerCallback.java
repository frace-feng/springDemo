package com.frace.producer;

import com.frace.common.MessageEntity;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Created by frace on 2019/10/28 12:00
 */
@Slf4j
public class ProducerCallback  implements ListenableFutureCallback<SendResult<String, MessageEntity>> {

    private final long startTime;
    private final String key;
    private final MessageEntity message;

    private final Gson gson = new Gson();

    public ProducerCallback(long startTime, String key, MessageEntity message) {
        this.startTime = startTime;
        this.key = key;
        this.message = message;
    }

    @Override
    public void onFailure(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onSuccess(SendResult<String, MessageEntity> stringMessageEntitySendResult) {
        if (stringMessageEntitySendResult == null) {
            return;
        }
        long elapsedTime = System.currentTimeMillis() - startTime;

        RecordMetadata metadata = stringMessageEntitySendResult.getRecordMetadata();
        if (metadata != null) {
            StringBuilder record = new StringBuilder();
            record.append("message(")
                    .append("key = ").append(key).append(",")
                    .append("message = ").append(gson.toJson(message)).append(")")
                    .append("sent to partition(").append(metadata.partition()).append(")")
                    .append("with offset(").append(metadata.offset()).append(")")
                    .append("in ").append(elapsedTime).append(" ms");
            log.info(record.toString());
        }
    }
}
