package com.lc.www.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lc.www.dao.User.UserDao;
import com.lc.www.dao.cacheDao.RedisDao;
import com.lc.www.pojo.User;
import com.lc.www.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	RedisDao redisDao;

	public boolean checkUserExistsByName(String name) {
		boolean result = false;
		
		Map<String, String> redisData = redisDao.getData("name" + name);
		
		if (redisData.get("result") == null) {
			User user = userDao.checkUserExistsByName(name);
			
			if (user != null) {
				result = true;
				redisDao.putData("name" + name, name);
			}
		} else {
			result = true;
		}
		
		return result;
	}

	public boolean validateUserData(User user) {
		boolean result = false;
		
		User userS = userDao.validateUserData(user);
		
		if (userS != null)
			return true;
		
		return result;
	}

	public User queryUserData(String userName) {
		return userDao.queryUserData(userName);
	}

}
