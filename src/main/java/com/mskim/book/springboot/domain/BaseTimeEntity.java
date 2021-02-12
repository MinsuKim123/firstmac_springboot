package com.mskim.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // BaseTimeEntity를 상속받는 클래스들은 필드들(createdDate, modifiedDate)를 컬럼으로 인식하게 만듦
@EntityListeners(AuditingEntityListener.class) // BaseTimeEntity 클래스에 Auditing 기능을 포함시킵니다

public abstract class BaseTimeEntity {

    @CreatedDate // Entity가 생성되어 저장될 때 시간이 자동 저장된다
    private LocalDateTime createDate;

    @LastModifiedDate // Entity가 변경될 때 시간이 자동 저장된다
    private LocalDateTime modifiedDate;
}

