package com.eason.webflux.handler;

import com.eason.webflux.model.Good;
import com.eason.webflux.util.GoodGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author Eason
 * @createTime 2018-12-26 10:59
 * @description
 */
@Component
@Configuration
public class GoodHandler {

    private final Flux<Good> goods;

    public GoodHandler(GoodGenerator goodGenerator) {
        this.goods = goodGenerator.findGoods();
    }

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ok().contentType(TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello Spring!"));
    }

    public Mono<ServerResponse> echo(ServerRequest request) {
        return ok().contentType(APPLICATION_STREAM_JSON)
                .body(this.goods, Good.class);
    }
}
