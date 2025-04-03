package com.web.greetings.Greet;

import java.util.concurrent.atomic.AtomicLong;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private final List<Greeting> greeted = new ArrayList<>();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		Greeting greet = new Greeting(counter.incrementAndGet(), String.format(template, name));
        greeted.add(greet);
		return greet;
	}

	@GetMapping("/all-greetings") 
	public List<Greeting> getAllGreetings() {
		return greeted;
	}
}
