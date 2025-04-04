package com.hospital.management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.dao.User;
import com.hospital.management.repository.UserRepository;

@Service
public abstract class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }
	
	@Override
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User addUser(User user) {
    	return userRepository.save(user);
    }
    
    @Override
    public void deleteUser(Integer id) {
    	userRepository.deleteById(id);
    }
}
