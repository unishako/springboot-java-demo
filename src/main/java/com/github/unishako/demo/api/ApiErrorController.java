package com.github.unishako.demo.api;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiErrorController implements ErrorController {

    @RequestMapping("/error")
    public void handleError() {
        // エラーの場合、レスポンスボディには何も返さない
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
