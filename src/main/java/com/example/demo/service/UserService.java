package com.example.demo.service;

import com.example.demo.controller.UserController;
import com.example.demo.dto.UrlRegistrationRequestDto;
import com.example.demo.repository.UrlInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Service
@AllArgsConstructor
public class UserService {

    private UrlInfoRepository urlInfoRepository;

    public Map<String, Object> saveUrlAndReturnId(UrlRegistrationRequestDto requestDto) {
       return makeHateoas(urlInfoRepository.save(requestDto.toEntity()).getId());
    }

    public Map<String, Object> makeHateoas(Long id) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("url", linkTo(UserController.class).slash(id).toString());

        return resultMap;
    }

    public HttpHeaders makeHttpHeaderLocation(String url) {
        HttpHeaders httpHeaders = new HttpHeaders();

        try {
            URI uri = new URI(url);
            httpHeaders.setLocation(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return httpHeaders;
    }
}
