package com.frace.entity;


import com.frace.entity.Person;
import com.frace.selfAnnotion.Timer;
import org.springframework.stereotype.Component;

/**
 * Created by frace on 2019/10/21 17:17
 * @Component 泛指组件，不好归类
 */
@Component
public class Chinese implements Person {

    @Timer
    @Override
    public String sayHello(String name) {
        System.out.println("say hello......");
        return name+",hello,aop";
    }

    public void eat(String food){
        System.out.println("i am eating.....");
    }
}
