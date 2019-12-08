package com.technocratsid.kafkaspringapp.controller;

import com.technocratsid.kafkaspringapp.service.KafkaConsumer;
import com.technocratsid.kafkaspringapp.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaController {

    @Autowired
    private KafkaConsumer consumer;

    @Autowired
    private KafkaProducer producer;

    @RequestMapping(value="/send", method= RequestMethod.POST)
    public void send(@RequestBody String data) {
        producer.produce(data);
    }

    @RequestMapping(value="/receive", method=RequestMethod.GET)
    public List<String> receive() {
        return consumer.messages;
    }
}
