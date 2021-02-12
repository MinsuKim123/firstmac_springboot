package com.mskim.book.springboot.web.domain.posts;

import com.mskim.book.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mskim.book.springboot.domain.posts.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After  //Junit 단위테스트가 끝날 때마다 데이터를 초기화시키는 용도로 보통 지정
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트게시글";
        String content = "테스트본문";

        postsRepository.save(Posts.builder()  // posts table 관리. ID가 있다면 Update, 없다면 Insert 수행됨
            .title(title)
            .content(content)
            .author("minsukim123@gmail.com")
            .build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll(); // Table에서 모든 데이터를 조회

        //then
        Posts posts = postsList.get(0);
        assertThat (posts.getTitle()).isEqualTo(title);
        assertThat (posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0);
        postsRepository.save(Posts.builder()
            .title("title")
            .content("content")
            .author("author")
            .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>> createDate=" + posts.getCreateDate()+",modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
