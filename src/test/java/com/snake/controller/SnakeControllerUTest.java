package com.snake.controller;

import com.snake.model.request.StartRequest;
import com.snake.model.response.SnakeResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SnakeControllerUTest {

    private static final SnakeControllerUTestFixtureBuilder snakeControllerUTestFixtureBuilder =
            new SnakeControllerUTestFixtureBuilder();

    @LocalServerPort private int port;
    @Autowired private RestTemplate restTemplate;

    @DisplayName("validRequest_Start_ReturnResponse")
    @Test
    public void start() {
        // given
        StartRequest startRequest = snakeControllerUTestFixtureBuilder.startRequest();

        // when
        ResponseEntity<SnakeResponse> snakeResponse = restTemplate.postForEntity("http://localhost:" + port
                + "/start", startRequest, SnakeResponse.class);

        // then
        assertThat(snakeResponse.getStatusCode(), equalTo(HttpStatus.OK));
    }

}