package com.snake.controller;

import com.snake.model.request.StartRequest;
import com.snake.model.response.SnakeResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnakeController {

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public SnakeResponse startGame(StartRequest startRequest) {
        System.out.println(startRequest);
        return null;
    }

    @RequestMapping(value = "/move", method = RequestMethod.POST)
    public SnakeResponse turn() {
        return null;
    }

    @RequestMapping(value = "/end", method = RequestMethod.POST)
    public SnakeResponse end() {
        return null;
    }

    @RequestMapping(value = "/ping", method = RequestMethod.POST)
    public SnakeResponse ping() {
        return null;
    }

}
