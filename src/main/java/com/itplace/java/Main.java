package com.itplace.java;

import com.itplace.java.api.HtmlCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        HtmlCreator creator = context.getBean("htmlCreatorImpl", HtmlCreator.class);
        creator.createHtml("src/main/summary.html");
    }
}
