package com.techprimers.cache.springredisexample;

import com.techprimers.cache.springredisexample.model.ID;
import com.techprimers.cache.springredisexample.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

@SpringBootApplication
public class SpringRedisExampleApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, User> redisTemplate() {
		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
 	}

	@Bean
	RedisTemplate<ID, User> redisTemplateForIDUser() {
		RedisTemplate<ID, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	@Bean
	RedisTemplate<String, Long> redisTemplateForStringLong() {
		RedisTemplate<String, Long> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	@Bean
	RedisTemplate<ID, Map> redisTemplateForStringMap() {
		RedisTemplate<ID, Map> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisExampleApplication.class, args);
	}
}
