package br.com.dio.desafioreactor;

import reactor.core.publisher.Mono;

public class Question3 {
    public Mono<Void> userIsValid(User user) {
        return Mono.just(user)
                .flatMap(u -> {
                    if (u.getPassword().length() > 8) {
                        return Mono.empty();
                    } else {
                        return Mono.error(new IllegalArgumentException("Invalid user"));
                    }
                });
    }
}
