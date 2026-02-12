package com.eventcom360.backend.controller;

import com.eventcom360.backend.dto.req.RegisterRequest;
import com.eventcom360.backend.model.User;
import com.eventcom360.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService s) {
        service = s;
    }

    @PostMapping
    public User register(@RequestBody RegisterRequest req) {
        return service.register(req);
    }
}
