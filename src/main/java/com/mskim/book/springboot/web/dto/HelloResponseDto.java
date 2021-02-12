package com.mskim.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 모든 필드의 get Method 생성해줌
@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 constructor를 생성해줌

public class HelloResponseDto {
    private final String name;
    private final int amount;
}
