package com.hospital.management.service;

import java.util.List;


import com.hospital.management.dao.User;

public interface UserService{
	public User getUserById(Integer userId);
	public User getUserByEmail(String email);
	public List<User> getAllUsers();
	public User addUser(User user);
	public void deleteUser(Integer id);
	//public boolean authenticateUser(String email, String password);
	public List<User> addUsers(List<User> users);
}
