package com.lc.www.controller.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lc.www.controller.UserController;
import com.lc.www.pojo.User;
import com.lc.www.service.UserService;
import com.lc.www.util.CommonUtil;

@Controller
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/register")
	public @ResponseBody Map<String, String> registerUser(@Param("name")String name) {
		Map<String, String> result = new HashMap<String, String>();
		
		boolean existsFlag = userService.checkUserExistsByName(name);
		
		if (existsFlag)
			result.put("exists", "1");
		else {
			result.put("exists", "0");
			User user = new User();
			user.setName(name);
			user.setPassword(CommonUtil.getMD5("123456"));
			int insert_number = userService.insertUserOneData(user);
			if (insert_number != 1) {
				result.put("message", "register has an error");
			} else {
				result.put("message", "register successful");
			}
		}
		
		return result;
	}

	@RequestMapping(value = "/login")
	public @ResponseBody Map<String, String> logInUser(@RequestBody User user) {
		Map<String, String> result = new HashMap<String, String>();
		
		boolean existsFlag = userService.checkUserExistsByName(user.getName());
		
		if (existsFlag) {
			
			user.setPassword(CommonUtil.getMD5(user.getPassword()));
			
			boolean correctFlag = userService.validateUserData(user);
			
			if (correctFlag) {
				result.put("status", "1");
				result.put("message", "login successful");
			} else {
				result.put("status", "2");
				result.put("message", "user name or password is wrong");
			}
		} else {
			result.put("status", "0");
			result.put("message", "the user don't exists");
		}
		
		return result;
	}

	@RequestMapping("/userInfo")
	public @ResponseBody Map<String, String> queryUserData(@Param("name")String name) {
		Map<String, String> result = new HashMap<String, String>();
		
		User user = userService.queryUserData(name);
		
		if (user == null) {
			result.put("null", "1");
			result.put("user", "not find");
		} else {
			result.put("user", user.toString());
		}
		
		return result;
	}

}
