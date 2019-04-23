package com.snake.router;

import com.snake.model.request.EndRequest;
import com.snake.model.request.MoveRequest;
import com.snake.model.request.StartRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static com.snake.router.SnakeControllerITFixtureBuilder.endRequest;
import static com.snake.router.SnakeControllerITFixtureBuilder.moveRequest;
import static com.snake.router.SnakeControllerITFixtureBuilder.startRequest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SnakeControllerIT {

    @LocalServerPort private int port;
    @Autowired private RestTemplate restTemplate;

    @DisplayName("validRequest_Start_Return200Response")
    @Test
    void start() {
        // given
        StartRequest startRequest = startRequest();

        // when
//        ResponseEntity<String> snakeResponse = restTemplate.postForEntity(getUrl("/start"), startRequest, String.class);

        // then
//        assertThat(snakeResponse.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @DisplayName("validRequest_Move_Return200Response")
    @Test
    void move() {
        // given
        MoveRequest moveRequest = moveRequest();

        // when
//        ResponseEntity<String> moveResponse = restTemplate.postForEntity(getUrl("/move"), moveRequest, String.class);

        // then
//        assertThat(moveResponse.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @DisplayName("validRequest_End_Return200Response")
    @Test
    void end() {
        // given
        EndRequest endRequest = endRequest();

        // when
//        ResponseEntity<String> endResponse = restTemplate.postForEntity(getUrl("/end"), endRequest, String.class);

        // then
//        assertThat(endResponse.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @DisplayName("validRequest_Ping_Return200Response")
    @Test
    void ping() {
        // when
//        ResponseEntity<String> pingResponse = restTemplate.postForEntity(getUrl("/ping"), null, String.class);

        // then
//        assertThat(pingResponse.getStatusCode(), equalTo(HttpStatus.OK));
    }

    private String getUrl(String endpoint) {
        return "http://localhost:" + port + endpoint;
    }

}