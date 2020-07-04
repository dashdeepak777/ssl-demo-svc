package com.nginxdemo;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class Controller {
    private Environment env;

    @GetMapping("/test")
    public Mono<String> checkLoadBalance(){

        return Mono.just("App running  on "+env.getProperty("local.server.port"));
    }

    @GetMapping("/hello/{user}")
    public Mono<String> hello(@PathVariable String user){

        return Mono.just("Hi "+ user+ "App running  on "+env.getProperty("local.server.port"));
    }

}
