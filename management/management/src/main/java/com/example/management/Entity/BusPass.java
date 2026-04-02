package com.example.management.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class BusPass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromLocation;
    private String toLocation;
    private String travelDate;
    private String status;
    private Long userId;
}