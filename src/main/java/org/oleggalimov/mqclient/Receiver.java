package org.oleggalimov.mqclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.LinkedList;

@Component
public class Receiver {
    @Autowired
    private JmsTemplate jmsTemplate;
    LinkedList<byte[]> list = new LinkedList<>();

    @JmsListener(destination = "IN", containerFactory = "myFactory")
    public void receiveMessage(Message msg) {

        jmsTemplate.send("OUT", session -> {
            Message message = session.createTextMessage("Этот текст переложен для сообщения с corellid: " + msg.getJMSCorrelationID());
            message.setJMSCorrelationID(msg.getJMSCorrelationID());
            System.out.println("Send response for " + msg.getJMSMessageID());
            System.out.println("Новые хедеры: " + message.getJMSCorrelationID() + ", msgID: " + message.getJMSMessageID());
            return message;
        });


    }
}