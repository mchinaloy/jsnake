package com.snake.router;

import com.snake.model.domain.response.Color;
import com.snake.model.domain.response.HeadType;
import com.snake.model.domain.response.TailType;
import com.snake.model.request.EndRequest;
import com.snake.model.request.MoveRequest;
import com.snake.model.request.StartRequest;
import com.snake.model.response.StartResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static com.snake.router.SnakeControllerITFixtureBuilder.endRequest;
import static com.snake.router.SnakeControllerITFixtureBuilder.moveRequest;
import static com.snake.router.SnakeControllerITFixtureBuilder.startRequest;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SnakeControllerIT {

    @Autowired private WebTestClient webTestClient;

    @DisplayName("validRequest_Start_Return200Response")
    @Test
    void start() {
        // given
        Mono<StartRequest> startRequest = Mono.just(startRequest());
        StartResponse startResponse = StartResponse.builder()
                .color(Color.RED.getColor())
                .headType(HeadType.SHARP.getHeadType())
                .tailType(TailType.PIXEL.getTailType())
                .build();

        // when & then
        webTestClient.post()
                .uri("/start")
                .contentType(APPLICATION_JSON)
                .body(startRequest, StartRequest.class)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(StartResponse.class)
                .isEqualTo(startResponse);
    }

    @DisplayName("validRequest_Move_Return200Response")
    @Test
    void move() {
        // given
        Mono<MoveRequest> moveRequest = Mono.just(moveRequest());

        // when & then
        webTestClient.post()
                .uri("/move")
                .contentType(APPLICATION_JSON)
                .body(moveRequest, MoveRequest.class)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.move")
                .exists();
    }

    @DisplayName("validRequest_End_Return200Response")
    @Test
    void end() {
        // given
        Mono<EndRequest> endRequest = Mono.just(endRequest());

        // when & then
        webTestClient.post()
                .uri("/end")
                .contentType(APPLICATION_JSON)
                .body(endRequest, EndRequest.class)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .isEmpty();
    }

    @DisplayName("validRequest_Ping_Return200Response")
    @Test
    void ping() {
        // when & then
        webTestClient.post()
                .uri("/ping")
                .contentType(APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .isEmpty();
    }

}