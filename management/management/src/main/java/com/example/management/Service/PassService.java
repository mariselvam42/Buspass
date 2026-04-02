package com.example.management.Service;

import com.example.management.Entity.BusPass;
import com.example.management.Repository.BusPassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassService {
    @Autowired
    BusPassRepository repo;

    public BusPass book(BusPass pass) {
        pass.setStatus("PENDING");
        return repo.save(pass);
    }

    public List<BusPass> getByUser(Long userId) {
        return repo.findByUserId(userId);
    }
}
