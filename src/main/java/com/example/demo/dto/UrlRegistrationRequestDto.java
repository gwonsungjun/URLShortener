package com.example.demo.dto;

import com.example.demo.domain.UrlInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UrlRegistrationRequestDto {

    private Long id;
    private String url;

    public UrlInfo toEntity() {
        return UrlInfo.builder()
                .url(url)
                .build();
    }
}
