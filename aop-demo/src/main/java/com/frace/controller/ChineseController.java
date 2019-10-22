package com.frace.controller;

import com.frace.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by frace on 2019/10/21 17:35
 */
@RestController
public class ChineseController {
    //必须注入person接口
    @Autowired
    private Person person;

    @RequestMapping("/")
    public void test(){
        person.sayHello("listen");
        System.out.println(person.getClass());
    }
}
