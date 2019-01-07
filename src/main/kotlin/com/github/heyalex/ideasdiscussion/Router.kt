package com.github.heyalex.ideasdiscussion

import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

class Router(
    private val getIdeasHandler: GetIdeasHandler
) {

    fun generateRouter() = router {
        "/api".nest {
            GET("/get_ideas", getIdeasHandler::handle)
        }
    }
}