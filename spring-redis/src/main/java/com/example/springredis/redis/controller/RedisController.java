package com.example.springredis.redis.controller;

import com.example.springredis.redis.model.Person;
import com.example.springredis.redis.repository.RedisRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * redis sample Controller
 *
 * @author youngran.kwon
 */
@Slf4j
@RequestMapping(value = "/redis")
@RestController
@AllArgsConstructor
public class RedisController {

    private RedisRepository redisRepository;

    @GetMapping("/setPerson")
    public void setPerson() {
        // 범위지정: (int) Math.random() * (최댓값-최소값+1) + 최소값
        int randomValue = (int)(Math.random() * 1000) + 1;
        Person person = new Person(String.valueOf(randomValue), "tester", 20);
        redisRepository.save(person);
    }

    @GetMapping("/getPerson")
    public Person getPerson(@RequestParam(value = "id") String id) {
        Optional<Person> person = redisRepository.findById(id);
        return person.get();
    }

}
