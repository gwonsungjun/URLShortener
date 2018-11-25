package com.example.demo.repository;

import com.example.demo.domain.Visits;
import com.example.demo.dto.FindStatisticsResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;
import java.util.stream.Stream;

public interface VisitsRepository extends JpaRepository<Visits, Long> {

    @Query("SELECT v.visitedDate as at, count(v) as visits " +
            "FROM Visits v " +
            "WHERE v.id = :id "+
            "GROUP BY v.visitedDate")
    Stream<Map<String, Object>> findVisitStatisticsById(@Param("id") Long id);
}
