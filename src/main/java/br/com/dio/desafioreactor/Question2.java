package br.com.dio.desafioreactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Question2 {
    public Mono<Long> countAdmins(List<User> users) {
        return Flux.fromIterable(users)
                .filter(User::isAdmin)
                .count();
    }
}
