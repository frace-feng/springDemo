package com.frace.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by frace on 2019/10/28 11:25
 */
@Getter
@Setter
@EqualsAndHashCode
public class MessageEntity {
    private String title;
    private String body;

    @Override
    public String toString() {
        return "MessageEntity:{" + "title='" + title + '\'' +
                ",body='" + body + '\'' +
                '}';
    }
}
