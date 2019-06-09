package com.lkk.jeight.util;

import java.util.ArrayList;
import java.util.List;

import com.lkk.jeight.jiekou.Predicate;

public class helper {
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p){
		List<T> result = new ArrayList<T>();
		for(T e: list){
			if(p.test(e)){
				result.add(e);
			}
		}
			return result;
		}

}
