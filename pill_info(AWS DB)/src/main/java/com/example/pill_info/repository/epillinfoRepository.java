package com.example.pill_info.repository;

import com.example.pill_info.model.epillinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface epillinfoRepository extends JpaRepository<epillinfo,Long> {
}
