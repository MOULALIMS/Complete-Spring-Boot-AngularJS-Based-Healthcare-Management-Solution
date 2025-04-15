package com.hospital.management.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.dao.LoginRequest;
import com.hospital.management.dao.User;
import com.hospital.management.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	@Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userService.getUserByEmail(loginRequest.getEmail());
        if(user.isPresent()) {
        	User client = user.get();
        	
        	if(client.getPassword().equals(loginRequest.getPassword())) {
        		 Map<String, String> response = new HashMap<>();
                 response.put("message", "Login Successful!");
                 response.put("role", client.getRole().toString());
                 response.put("email", client.getEmail()); // optional
                 return ResponseEntity.ok(response);
        	}else {
        		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Password");
        	}
        }else {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
        }
    }
    
    @PostMapping("/registerUser")
    public ResponseEntity<?> register(@RequestBody User user){
    	User user1 = userService.addUser(user);
    	return ResponseEntity.ok(user1);
    }
}
