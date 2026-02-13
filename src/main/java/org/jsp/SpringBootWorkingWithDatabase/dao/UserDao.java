package org.jsp.SpringBootWorkingWithDatabase.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringBootWorkingWithDatabase.Repository.UserRepository;
import org.jsp.SpringBootWorkingWithDatabase.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao 
{
	@Autowired
	private UserRepository repository;
	public User saveUser(User user)
	{
		User saveduser = repository.save(user);
		return saveduser;
	}
	public Optional<User> getUserById(int id)
	{
		Optional<User> user = repository.findById(id);
		return user;
	}
	public User login(String email)
	{
		User user = repository.login(email);
		return user;
	}
	public void deleteUser(User user)
	{
		repository.delete(user);
	}
	public User UpdateUser(User user)
	{
		return repository.save(user);
	}
	public List<User> getAllUsers()
	{
		return repository.findAll();
	}
}
