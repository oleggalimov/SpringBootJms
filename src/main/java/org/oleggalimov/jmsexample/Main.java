package org.oleggalimov.jmsexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;


@SpringBootApplication
public class Main {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);
        var jmsTemplate = context.getBean(JmsTemplate.class);
    }
}