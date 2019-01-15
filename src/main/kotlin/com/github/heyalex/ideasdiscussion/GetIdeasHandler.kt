package com.github.heyalex.ideasdiscussion

import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

class GetIdeasHandler {
    fun handle(request: ServerRequest) : Mono<ServerResponse> {
        return ServerResponse.ok().body(fromObject(arrayOf(1, 2, 3))).toMono()
    }
}