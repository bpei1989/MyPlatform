package com.myplatform.web.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


@Component("CacheService")
public class CacheService {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 入栈，leftPush虽然是操作List，但和pop结合实际上是一个入栈的过程
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Long push(String key, String value) {
		return stringRedisTemplate.opsForList().leftPush(key, value);
	}

	/**
	 * 出栈，leftPop虽然是操作List，但实际上是一个出栈的过程
	 * 
	 * @param key
	 * @return
	 */
	public String pop(String key) {
		return stringRedisTemplate.opsForList().leftPop(key);
	}

	/**
	 * 入队
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Long in(String key, String value) {
		return stringRedisTemplate.opsForList().rightPush(key, value);
	}

	/**
	 * 出队，和pop一样的操作，不过为了描述清楚，out可读性更好
	 * 
	 * @param key
	 * @return
	 */
	public String out(String key) {
		return stringRedisTemplate.opsForList().leftPop(key);
	}

	/**
	 * 栈/队列长
	 * 
	 * @param key
	 * @return
	 */
	public Long length(String key) {
		return stringRedisTemplate.opsForList().size(key);
	}

	/**
	 * 范围检索
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public List<String> range(String key, int start, int end) {
		return stringRedisTemplate.opsForList().range(key, start, end);
	}

	/**
	 * 移除
	 * 
	 * @param key
	 * @param i
	 * @param value
	 */
	public void remove(String key, long i, String value) {
		stringRedisTemplate.opsForList().remove(key, i, value);
	}

	/**
	 * 检索
	 * 
	 * @param key
	 * @param index
	 * @return
	 */
	public String index(String key, long index) {
		return stringRedisTemplate.opsForList().index(key, index);
	}

	/**
	 * 置值
	 * 
	 * @param key
	 * @param index
	 * @param value
	 */
	public void set(String key, long index, String value) {
		stringRedisTemplate.opsForList().set(key, index, value);
	}

	/**
	 * 区间
	 * 
	 * @param key
	 * @param start
	 * @param end
	 */
	public void trim(String key, long start, int end) {
		stringRedisTemplate.opsForList().trim(key, start, end);
	}
}
