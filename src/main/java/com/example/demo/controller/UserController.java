package com.example.demo.controller;

import com.example.demo.domain.UrlInfo;
import com.example.demo.dto.UrlRegistrationRequestDto;
import com.example.demo.repository.UrlInfoRepository;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    private UrlInfoRepository urlInfoRepository;

    @PostMapping("/register.json")
    public ResponseEntity<Map<String, Object>> registerByUrl(UrlRegistrationRequestDto requestDto) {
        UrlInfo urlInfo = urlInfoRepository.findByUrl(requestDto.getUrl());
        if (urlInfo != null){
            return new ResponseEntity<>(userService.makeHateoas(urlInfo.getId()), HttpStatus.OK);
        }

        return new ResponseEntity<>(userService.saveUrlAndReturnId(requestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MultiValueMap<String, String>> findLocationById(@PathVariable Long id){
        UrlInfo urlInfo = urlInfoRepository.findById(id).orElse(null);
        if(urlInfo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        HttpHeaders httpHeaders = userService.makeHttpHeaderLocation(urlInfo.getUrl());
        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }
}
