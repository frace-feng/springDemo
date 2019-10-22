package com.frace;

import com.frace.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by frace on 2019/10/21 17:29
 */
@SpringBootApplication
public class AopDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(AopDemoApplication.class,args);
    }

}
