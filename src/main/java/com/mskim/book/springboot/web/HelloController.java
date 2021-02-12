package com.mskim.book.springboot.web;

import com.mskim.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController // JSON을 반환하는 컨트롤러를 만들어줌.

public class HelloController {
    @GetMapping("/hello") // HTTP GET Method에 반응하는 API를 만듦
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount) ;
    }
}

