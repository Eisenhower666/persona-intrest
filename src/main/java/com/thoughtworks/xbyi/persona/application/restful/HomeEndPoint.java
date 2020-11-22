package com.thoughtworks.xbyi.persona.application.restful;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeEndPoint {
    @GetMapping("/")
    Map<String, String> home() {
        Map message = new HashMap<String, String>();
        message.put("name", "Persona");
        return message;
    }

    @GetMapping("/credits")
    Map<String, String> job() {
        Map message = new HashMap<String, String>();
        message.put("job", "dagongren");
        return message;
    }

    @GetMapping("/consumes")
    Map<String, String> consume() {
        Map message = new HashMap<String, String>();
        message.put("car", "1");
        return message;
    }

    @GetMapping("/intrest")
    Map<String, String> intrest(){
        Map intrest = new HashMap<String, String>();
        intrest.put("outdoors",  "1");
        return intrest;
    }
}
