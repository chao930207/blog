package com.lc.www.util;

import org.springframework.util.DigestUtils;

public class CommonUtil {

	private final static String salt = "lchao0207";
	
	public static String getMD5(String str) {
		
		String baseStr = str + "/" + salt;
		
		String md5 = DigestUtils.md5DigestAsHex(baseStr.getBytes());
		
		return md5;
	}
}
