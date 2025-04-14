package com.example.backend.controller;

import com.example.backend.entity.Result;
import com.example.backend.repo.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class ResultController {

    @Autowired
    private ResultRepo resultRepository;

    @GetMapping("/results/{email}")
    public List<Result> getResultsByEmail(@PathVariable String email) {
        return resultRepository.findByUserEmail(email);
    }
}

