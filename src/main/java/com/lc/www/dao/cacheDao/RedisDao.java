package com.lc.www.dao.cacheDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDao {

	private final JedisPool jedisPool;
	
	public RedisDao(String ip, int port) {
		jedisPool = new JedisPool(ip, port);
	}
	
	@SuppressWarnings("rawtypes")
	//private RuntimeSchema<List> schema = RuntimeSchema.createFrom(List.class);
	
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

	/**
	 * 序列化获取List
	 * @param key
	 * @return
	 */
	/*public List<String> getListData(String key) {
		
		List<String> result = new ArrayList<String>();

		try {
			Jedis jedis = jedisPool.getResource();
			try {
				byte[] bytes = jedis.get(key.getBytes());
				
				if (bytes != null) {
					// null Object
					@SuppressWarnings("unchecked")
					List<String> list = schema.newMessage();
					ProtostuffIOUtil.mergeFrom(bytes, list, schema);
					// list 被反序列化
					result = list;
				}
			} finally {
				jedis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}*/
	
	/**
	 * 序列化存储List
	 * @param key
	 * @param articleUrlList
	 * @return
	 */
	/*public String setListData(String key, List<String> articleUrlList) {
		
		String result = null;

		try {
			Jedis jedis = jedisPool.getResource();
			try {
				byte[] bytes = ProtostuffIOUtil.toByteArray(articleUrlList, schema,
						LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
				int timeout = 60 * 60 * 24 * 365 * 10;
				result = jedis.setex(key.getBytes(), timeout, bytes);
			} finally {
				jedis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "jedis server error";
		}
		
		return result;
	}*/

}
