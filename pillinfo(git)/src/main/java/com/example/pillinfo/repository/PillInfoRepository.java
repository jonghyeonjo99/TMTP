package com.example.pillinfo.repository;

import com.example.pillinfo.Pill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PillInfoRepository extends JpaRepository<Pill,Long> {
}
