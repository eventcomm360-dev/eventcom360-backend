package com.eventcom360.backend.service;

import com.eventcom360.backend.dto.req.RegisterRequest;
import com.eventcom360.backend.model.User;
import com.eventcom360.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User register(RegisterRequest req) {
        User u = new User();
        u.setFullName(req.fullName);
        u.setEmail(req.email);
        u.setPhone(req.phone);
        u.setRole(req.role);
        return repo.save(u);
    }
}
