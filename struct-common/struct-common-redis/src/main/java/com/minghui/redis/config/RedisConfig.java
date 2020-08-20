package com.minghui.redis.config;

import com.minghui.redis.util.RedisObjectSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {

	@Primary
	@Bean("redisTemplate")
	// 没有此属性就不会装配bean 如果是单个redis 将此注解注释掉
	@ConditionalOnProperty(name = "spring.redis.cluster.nodes", matchIfMissing = false)
	public RedisTemplate<String, Object> getRedisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(factory);

		RedisSerializer stringSerializer = new StringRedisSerializer();
		RedisSerializer redisObjectSerializer = new RedisObjectSerializer();
		redisTemplate.setKeySerializer(stringSerializer);
		redisTemplate.setHashKeySerializer(stringSerializer);
		redisTemplate.setValueSerializer(redisObjectSerializer);
		redisTemplate.afterPropertiesSet();

		return redisTemplate;
	}

	@Bean("redisTemplate")
	@ConditionalOnProperty(name = "redis.single.ip", matchIfMissing = true)
	public RedisTemplate getSingleRedisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(factory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new RedisObjectSerializer());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	@Bean("stringRedisTemplate")
	@ConditionalOnProperty(name = "redis.single.ip", matchIfMissing = true)
	public RedisTemplate getSingleStringRedisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(factory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

}
