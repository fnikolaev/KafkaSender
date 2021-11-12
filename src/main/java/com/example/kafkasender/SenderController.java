package com.example.kafkasender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sender/api/")
public class SenderController {
    @Autowired
    Producer producer;

    @PostMapping(value = "post")
    public void sendMessage(@RequestParam("msg") String msg){
        producer.publishToTopic("mytopic", msg);
    }

    @PostMapping(value = "postjson")
    public void sendMessage(@RequestBody User user){
        producer.publishJson("json_topic", user);
    }
}
