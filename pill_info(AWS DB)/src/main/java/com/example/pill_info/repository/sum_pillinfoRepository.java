package com.example.pill_info.repository;

import com.example.pill_info.model.sum_pillinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sum_pillinfoRepository extends JpaRepository <sum_pillinfo, Long> {
}