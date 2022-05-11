package com.example.springredis.redis.repository;

import com.example.springredis.redis.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * redis sample repository
 *
 * @author youngran.kwon
 */
public interface RedisRepository extends CrudRepository<Person, String> {
}
