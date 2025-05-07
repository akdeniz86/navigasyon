package com.navi.project.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navi.project.model.TollWays;

public interface TollWaysRepository extends JpaRepository<TollWays, Long> {
    Optional<TollWays> findByHighwayCode(String code);
    List<TollWays> findAll();
}
