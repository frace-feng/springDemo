package com.frace.StaticProxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by frace on 2019/10/21 17:25
 * 定义aspect
 */
@Aspect
@Component
public class AdviceTest {

    @Pointcut("@annotation(com.frace.selfAnnotion.Timer)")
    public void pointCut(){

    }
    @Before("pointCut()")
    public void before(){
        System.out.println("before pointcut");
    }
}
