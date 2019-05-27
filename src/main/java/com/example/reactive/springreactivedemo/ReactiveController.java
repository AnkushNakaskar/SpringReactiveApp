package com.example.reactive.springreactivedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author ankushnakaskar
 */

@Slf4j
@RestController
public class ReactiveController {



    private final WebClient webClient = WebClient.create("http://localhost:9099");

    @GetMapping(value = "/reactiveService/{sleep}")
    public Mono<String> reactiveService(@PathVariable Long sleep){
        log.info(Thread.currentThread() + " :: reactiveService Request processing started :: "+sleep);
        return webClient.get().uri("/sleep/"+sleep)
                .retrieve().bodyToMono(Boolean.class)
                .doOnNext(response->{ log.info("reactive service :: " +response);})
                .then(Mono.just("reactiveService"));

    }
}
