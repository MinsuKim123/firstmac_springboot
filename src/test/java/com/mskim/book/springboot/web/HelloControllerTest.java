package com.mskim.book.springboot.web;

import com.mskim.book.springboot.web.HelloController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // Junit 내장 실행자 이외의 다른 프로그램을 실행. 즉 스프링부트 테스트와 JUnit 사이의 연결자 역할.
@WebMvcTest (controllers = HelloController.class) // 스프링 테스트 어노테이션 중, Web에 집중할 수 있는 테스트

public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 Bean을 주입받음
    private MockMvc mvc; // 스프링 MVC의 시작점. 이 클래스를 사용해서 HTTP GET, POST 등의 API Test를 할 수 있음

    @Test
    public void hello가_리턴되었나() throws Exception { // 클래스 이름으로 한글도 가능하다니!
        String hello = "hello";

        this.mvc.perform(get("/hello"))  // MockMvc를 통해 /hello 주소로 Get 요청을 한다
            .andExpect(status().isOk())
            .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴되었나() throws Exception {
        String name = "hello";
        int amount = 1000;

        this.mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name", is(name)))
                    .andExpect(jsonPath("$.amount", is(amount)));


    }

}
