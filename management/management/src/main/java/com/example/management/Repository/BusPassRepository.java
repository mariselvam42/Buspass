package com.example.management.Repository;

import com.example.management.Entity.BusPass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusPassRepository extends JpaRepository<BusPass, Long> {
    List<BusPass> findByUserId(Long userId);
}