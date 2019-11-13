package com.goodfor.web.pxy;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class Proxy {

	public int integer(String param) {
		Function<String, Integer> f = Integer :: parseInt;
		return f.apply(param);
	}
	
	public String string(Object param) {
		Function<Object, String> f = String::valueOf;
		return f.apply(param);
	}
	
	public boolean equals(String p1, String p2) {
		BiPredicate<String, String> f = String::equals;
		return f.test(p1, p2);
	}
	
	public int[] array(int size) {
		Function<Integer, int[]> f = int[]::new;
		return f.apply(size);
	}
	
	public int random(int a, int b) {
		BiFunction<Integer, Integer, Integer> f = (x , y) -> (int)(Math.random()*(y-x))+x; 
		return f.apply(a, b);
	}
	
}
