package org.jsp.SpringBootWorkingWithDatabase.Service;



import java.util.List;

//import java.util.Optional;

import org.jsp.SpringBootWorkingWithDatabase.dao.UserDao;
import org.jsp.SpringBootWorkingWithDatabase.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService 
{
	@Autowired
	private UserDao dao;
	public User saveUser(User user)
	{
		if (dao.getUserById(user.getId()).isPresent())
		{
			throw new RuntimeException("User is already present with given id");
			
		}
		User savedUser = dao.saveUser(user);
		return savedUser;
	}
	public User getUserById(int id)
	{
//		Optional<User> user = repository.findById(id);
//		if(user.isPresent())
//		{
//			return user.get();
//		}
//		throw new RuntimeException("User not found");
		
		
		User user = dao.getUserById(id).orElseThrow(() -> new RuntimeException("user not found"));
		return user;
	}
	public boolean login(String email,String password)
	{
		User user = dao.login(email);
		if(user!=null && user.getPassword().equals(password))
		{
			return true;
		}
		throw new RuntimeException("Invalid Credentials");
	}
	public void deleteUser(User user)
	{
		dao.deleteUser(user);
	}
	public User updateUser(User user)
	{
		return dao.UpdateUser(user);
	}
	public List<User> getAllUsers()
	{
		return dao.getAllUsers();
	}

}
