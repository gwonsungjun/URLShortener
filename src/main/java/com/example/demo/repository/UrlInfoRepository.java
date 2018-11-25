package com.example.demo.repository;

import com.example.demo.domain.UrlInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlInfoRepository extends JpaRepository<UrlInfo, Long> {
}
