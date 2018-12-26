package com.eason.webflux.router;

import com.eason.webflux.handler.GoodHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.http.MediaType.TEXT_PLAIN;

/**
 * @author Eason
 * @createTime 2018-12-26 11:04
 * @description
 */
@Configuration
public class GoodRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GoodHandler goodHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/good")
                        .and(RequestPredicates.accept(TEXT_PLAIN)), goodHandler::hello)
                .andRoute(RequestPredicates.GET("/goods")
                        .and(RequestPredicates.accept(APPLICATION_STREAM_JSON)), goodHandler::echo);
    }
}
