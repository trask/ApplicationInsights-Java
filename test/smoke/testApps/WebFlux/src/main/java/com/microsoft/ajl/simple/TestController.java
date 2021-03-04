package com.microsoft.ajl.simple;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

    @GetMapping("/")
    public String root() {
        return "OK";
    }

    @GetMapping("/test/**")
    public Mono<String> test() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {
            }
            completableFuture.complete("hello");
        });
        return Mono.fromFuture(completableFuture);
    }
}
