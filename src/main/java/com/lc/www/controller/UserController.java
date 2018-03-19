package com.lc.www.controller;

import java.util.Map;

import com.lc.www.pojo.User;

public interface UserController {

	Map<String, String> registerUser(String name);
	
	Map<String, String> logInUser(User user);
	
	Map<String, String> queryUserData(String name);
}
