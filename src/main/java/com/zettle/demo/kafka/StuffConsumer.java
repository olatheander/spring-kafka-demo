package com.zettle.demo.kafka;

import com.zettle.demo.kafka.constants.Topics;
import com.zettle.demo.kafka.dto.Stuff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.zettle.demo.kafka.constants.Groups.ZETTLE;

@Component
public class StuffConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(StuffConsumer.class);

    @Autowired
    private StuffRepository stuffRepository;

    @KafkaListener(topics = Topics.ZETTLE,
            groupId = ZETTLE)
    public void process(Stuff stuff) {
        stuffRepository.save(
                new com.zettle.demo.kafka.entity.Stuff(
                        stuff.getName(),
                        stuff.getAge()));
        LOG.info("Consumed stuff: {}.", stuff);
    }
}
