package com.Lect.week03;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public interface Animal {
	String sound();
}
@Component
class Dog implements Animal {
	public String sound() {
		return "Woof";
	}
}
@Component
@Primary
class Cat implements Animal {
	public String sound() {
		return "Meow";
	}
}