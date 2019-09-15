package org.oleggalimov.jmsexample;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Listener {
//    @JmsListener(destination = "TEST.IN", containerFactory = "myFactory")
    @JmsListener(destination = "TEST.IN")
    @SendTo("TEST.OUT")
    public Message onMessage(Message msg) {
        System.out.println(msg.getHeaders());
        return msg;
    }
}
