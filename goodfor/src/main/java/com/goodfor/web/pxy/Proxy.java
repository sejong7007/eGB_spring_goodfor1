package com.goodfor.web.pxy;

import java.util.function.BiPredicate;
import java.util.function.Function;

import org.springframework.stereotype.Component;

@Component
public class Proxy {

	public int parseInt(String param) {
		Function<String, Integer> f = Integer::parseInt;
		//Function<String, Integer> f = s -> Integer.parseInt(s);
		return f.apply(param);
	}
	
	public String toString(Object param) {
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
	
}
