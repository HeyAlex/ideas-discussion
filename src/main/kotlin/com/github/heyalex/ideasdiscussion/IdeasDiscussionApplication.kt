package com.github.heyalex.ideasdiscussion

import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter
import org.springframework.web.reactive.function.server.HandlerStrategies
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.server.adapter.WebHttpHandlerBuilder
import reactor.netty.http.server.HttpServer
import java.time.Duration

fun main(args: Array<String>) {
    val context = GenericApplicationContext()

    beans {
        bean<Router>()
        bean<GetIdeasHandler>()
        bean(WebHttpHandlerBuilder.WEB_HANDLER_BEAN_NAME) {
            RouterFunctions.toWebHandler(
                ref<Router>().generateRouter(),
                HandlerStrategies.builder().build()
            )
        }
    }.initialize(context)

    context.refresh()

    HttpServer.create()
        .host("0.0.0.0")
        .port(8080)
        .bindUntilJavaShutdown(Duration.ofSeconds(10), null)
}

