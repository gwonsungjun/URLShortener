package com.example.demo;

import com.example.demo.controller.UserController;
import com.example.demo.domain.UrlInfo;
import com.example.demo.repository.UrlInfoRepository;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UrlInfoRepository repository;

    @MockBean
    private UserService userService;

    @Test
    public void URL_리다이렉트_HTTP_상태코드_테스트() throws  Exception {
        UrlInfo urlInfo = new UrlInfo(1L, "http://www.vingle.net");
        given(repository.findById(urlInfo.getId())).willReturn(Optional.of(urlInfo));

        mvc.perform(get("/1")).andExpect(status().is3xxRedirection());
    }

}
