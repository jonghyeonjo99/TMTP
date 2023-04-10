package com.example.pill_info_2.repository;

import com.example.pill_info_2.model.mediinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface mediinfoRepository extends JpaRepository <mediinfo, Long> {
}
