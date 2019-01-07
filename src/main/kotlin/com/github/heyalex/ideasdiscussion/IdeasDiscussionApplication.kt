package com.github.heyalex.ideasdiscussion

import reactor.netty.http.server.HttpServer
import java.time.Duration

class IdeasDiscussionApplication

fun main(args: Array<String>) {

    HttpServer.create()
        .host("0.0.0.0")
        .port(8080)
        .bindUntilJavaShutdown(Duration.ofSeconds(10), null)
}

