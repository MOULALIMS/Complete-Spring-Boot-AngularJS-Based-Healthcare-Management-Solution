package com.hospital.management.service;

import java.util.List;

import java.util.Optional;

import com.hospital.management.dao.User;

public interface UserService{
	public User getUserById(Integer userId);
	public Optional<User> getUserByEmail(String email);
	public List<User> getAllUsers();
	public User addUser(User user);
	public void deleteUser(Integer id);
}
