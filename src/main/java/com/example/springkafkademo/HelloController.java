package com.example.springkafkademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/greeting")
    public String greeting(String name) {
        LOG.info("Greeting: {}", name);
        return "Hello " + name;
    }

    @PostMapping("/stuff")
    public void postSomeStuff(@RequestBody Stuff stuff) {
        LOG.info("Stuff posted: {}.", stuff);
    }
}
