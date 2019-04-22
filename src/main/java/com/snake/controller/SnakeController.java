package com.snake.controller;

import com.snake.model.request.EndRequest;
import com.snake.model.request.MoveRequest;
import com.snake.model.request.StartRequest;
import com.snake.model.response.MoveResponse;
import com.snake.model.response.StartResponse;
import com.snake.service.SnakeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SnakeController {

    @Autowired private SnakeService snakeService;

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public ResponseEntity<StartResponse> startGame(@RequestBody StartRequest startRequest) {
        log.info("Starting request={}", startRequest);
        StartResponse startResponse = snakeService.start(startRequest);
        log.info("Starting response={}", startResponse);
        return new ResponseEntity<>(startResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/move", method = RequestMethod.POST)
    public ResponseEntity<MoveResponse> move(@RequestBody MoveRequest moveRequest) {
        log.info("Moving request={}", moveRequest);
        MoveResponse moveResponse = snakeService.move(moveRequest);
        log.info("Moving response={}", moveResponse);
        return new ResponseEntity<>(moveResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/end", method = RequestMethod.POST)
    public ResponseEntity<String> end(@RequestBody EndRequest endRequest) {
        log.info("Ending={}", endRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/ping", method = RequestMethod.POST)
    public ResponseEntity<String> ping() {
        log.info("Pinging");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
