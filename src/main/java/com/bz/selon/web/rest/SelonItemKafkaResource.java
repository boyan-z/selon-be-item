package com.bz.selon.web.rest;

import com.bz.selon.service.SelonItemKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/selon-item-kafka")
public class SelonItemKafkaResource {

    private final Logger log = LoggerFactory.getLogger(SelonItemKafkaResource.class);

    private SelonItemKafkaProducer kafkaProducer;

    public SelonItemKafkaResource(SelonItemKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
