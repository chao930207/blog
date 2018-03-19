package com.lc.www.service;

import com.lc.www.pojo.User;

public interface UserService {

	public boolean checkUserExistsByName(String name);
	
	public boolean validateUserData(User user);
	
	public User queryUserData(String userName);
}
