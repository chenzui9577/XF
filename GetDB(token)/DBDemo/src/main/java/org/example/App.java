package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */

@SpringBootApplication(scanBasePackages = {"org.example","org.example.controller"})
//HibernateJpaAutoConfiguration.class}
//@MapperScan("org.example.mapper")
@RestController
public class App {

    @RequestMapping("/")
    public String home() {
        return "成功!!";
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(App.class, args);
    }
}

