package com.lc.www.dao.cacheDao;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDao {

	private final JedisPool jedisPool;
	
	public RedisDao(String ip, int port) {
		jedisPool = new JedisPool(ip, port);
	}
	
	public Map<String, String> getData(String key) {
		Map<String, String> result = new HashMap<String, String>();
		
		try {
			Jedis jedis = jedisPool.getResource();
			try {
				String str = jedis.get(key);
				if (str != null) {
					result.put("result", str);
				} else {
					result.put("result", null);
				}
			} finally {
				jedis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Map<String, String> putData(String key, String value) {

		Map<String, String> result = new HashMap<String, String>();
		
		try {
			Jedis jedis = jedisPool.getResource();
			try {
				int timeout = 60 * 60 * 24 * 365 * 10;
				String str = jedis.setex(key, timeout, value);
				result.put("result", str);
			} finally {
				jedis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	
	}
}
