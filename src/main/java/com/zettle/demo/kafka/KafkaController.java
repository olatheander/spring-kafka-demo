package com.zettle.demo.kafka;

import com.zettle.demo.kafka.constants.Topics;
import com.zettle.demo.kafka.dto.Stuff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private KafkaTemplate<String, Stuff> kafkaTemplate;

    @PostMapping(path = "/send",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendStuff(@RequestBody Stuff stuff) {
        final ListenableFuture<SendResult<String, Stuff>> result = kafkaTemplate.send(Topics.ZETTLE,
                stuff);
        result.addCallback(r -> {
            LOG.info("Stuff posted: {} to topic \"{}\".",
                    stuff,
                    Topics.ZETTLE);

        }, ex -> {
            LOG.error("Failed to send stuff.", ex);
        });
    }
}
