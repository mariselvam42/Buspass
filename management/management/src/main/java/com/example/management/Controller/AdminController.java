package com.example.management.Controller;

import com.example.management.Entity.BusPass;
import com.example.management.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    AdminService service;

    @GetMapping("/all")
    public List<BusPass> getAll() {
        return service.getAll();
    }

    @PostMapping("/approve/{id}")
    public void approve(@PathVariable Long id) {
        service.approve(id);
    }

    @PostMapping("/reject/{id}")
    public void reject(@PathVariable Long id) {
        service.reject(id);
    }
}
