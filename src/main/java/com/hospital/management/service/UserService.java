package com.hospital.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.hospital.management.dao.User;

@Service
public interface UserService extends JpaRepository<User, Integer>{
	public User getUserById(Integer userId);
	public Optional<User> getUserByEmail(String email);
	public List<User> getAllUsers();
	public User addUser(User user);
	public void deleteUser(Integer id);
}
