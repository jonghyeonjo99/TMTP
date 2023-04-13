package com.example.pill_info.repository;

import com.example.pill_info.model.mediinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface mediinfoRepository extends JpaRepository <mediinfo, Long> {
}
