package com.eason.webflux;

import com.eason.webflux.model.Good;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.http.MediaType.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebfluxApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void contextLoads() {
    }

    @Test
    public void helloTest() {
        String s = webTestClient
                .get().uri("/good")
                .accept(TEXT_PLAIN).exchange()
                .expectStatus().isOk().returnResult(String.class)
                .getResponseBody().blockFirst();

        System.out.println(s);
    }

    @Test
    public void findGoodsTest() {
        Mono<List<Good>> goodList = webTestClient.get().uri("/goods")
                .accept(APPLICATION_STREAM_JSON)
                .exchange().expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_STREAM_JSON)
                .returnResult(Good.class)
                .getResponseBody().collectList();

        System.out.println(goodList.block());
    }

}

