package com.example.management.Service;

import com.example.management.Entity.BusPass;
import com.example.management.Entity.User;
import com.example.management.Repository.BusPassRepository;
import com.example.management.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    BusPassRepository repo;

    public List<BusPass> getAll() {
        return repo.findAll();
    }

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    UserRepository userRepo;

    public void approve(Long id) {
        BusPass pass = repo.findById(id).orElseThrow();

        pass.setStatus("APPROVED");
        repo.save(pass);

        User user = userRepo.findById(pass.getUserId()).orElseThrow();

        sendMail(user.getEmail(),
                "Bus Pass Approved",
                "Your bus pass has been APPROVED ✅");
    }

    public void reject(Long id) {
        BusPass pass = repo.findById(id).orElseThrow();

        pass.setStatus("REJECTED");
        repo.save(pass);

        User user = userRepo.findById(pass.getUserId()).orElseThrow();

        sendMail(user.getEmail(),
                "Bus Pass Rejected",
                "Your bus pass has been REJECTED ❌. Please apply again.");
    }

    private void sendMail(String to, String subject, String text) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(text);
        mailSender.send(mail);
    }
}