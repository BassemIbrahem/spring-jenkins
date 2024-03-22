package com.example.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.PracticalTipSender;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

	private PracticalTipSender jsonProducer;
	
	public MessageJsonController(PracticalTipSender jsonProducer) {
        this.jsonProducer= jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonProducer.sendPracticalTip(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ ...");
    }
}
