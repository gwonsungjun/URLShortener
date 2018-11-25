package com.example.demo;

import com.example.demo.domain.UrlInfo;
import com.example.demo.repository.UrlInfoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaMappingTest {

    @Autowired
    private UrlInfoRepository repository;


    @Before
    public void init() {
        UrlInfo user = repository.save(UrlInfo.builder()
                .url("http://localhost:3000")
                .build());
    }

    @Test
    public void URL_등록_테스트() {
        UrlInfo user = repository.findById(1L).orElse(null);
        assertThat(user.getId(), is(1L));
        assertThat(user.getUrl(), is("http://localhost:3000"));
    }
}

