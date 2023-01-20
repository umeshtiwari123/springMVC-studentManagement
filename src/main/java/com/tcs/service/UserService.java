package com.tcs.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.dao.UserDao;
import com.tcs.dto.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public void saveUser(User user)
	{
		userDao.saveUser(user);
	}
	
	public User getUserByEmail(User user)
	{
		User receivedUser=userDao.getUserByEmail(user.getEmail());
		if(user.getPass().equals(receivedUser.getPass()))
				{
				return receivedUser;
				}
		else 
			return null;
	}
}
