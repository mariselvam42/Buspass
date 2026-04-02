package com.example.management.Controller;

import com.example.management.Entity.BusPass;
import com.example.management.Service.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pass")
@CrossOrigin("*")
public class PassController {

    @Autowired
    PassService service;

    @PostMapping("/book")
    public BusPass book(@RequestBody BusPass pass) {
        return service.book(pass);
    }

    @GetMapping("/user/{id}")
    public List<BusPass> getUserPass(@PathVariable Long id) {
        return service.getByUser(id);
    }
}