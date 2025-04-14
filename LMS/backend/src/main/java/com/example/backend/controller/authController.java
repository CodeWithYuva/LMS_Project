package com.example.backend.controller;
import com.example.backend.entity.registerRequest;
import com.example.backend.entity.users;
import com.example.backend.repo.userRepo;
import com.example.backend.security.jwt;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class authController {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private jwt jwtUtil;

    @Autowired
    private userRepo userRepository;

    public authController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }



   /* @GetMapping("/")
    public String hello(HttpServletRequest r) {
        return "hello" + r.getSession().getId();
    } */

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody registerRequest request) {
        // Check if email already exists
        if (userRepository.findByEmail(request.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already registered.");
        }

        users user = new users();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole(request.getRole().toUpperCase());

        userRepository.save(user);



        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody users user) {

        users foundUser = userRepository.findByEmail(user.getEmail());
        if (foundUser == null) {
            return ResponseEntity.status(401).body("Email not registered");
        }


        if (!passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            return ResponseEntity.status(401).body("Invalid password");
        }

        String token = jwtUtil.generateToken(foundUser);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("role", foundUser.getRole());
        return ResponseEntity.ok(response);




    }

}
