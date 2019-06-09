package com.lkk.jeight;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.lkk.jeight.pojo.Apple;
import com.lkk.jeight.util.helper;

/**
 * Hello world!
 *
 */
public class App 

{
    public static void main( String[] args )
    {   
    	
    	Period tenDays = Period.between(LocalDate.of(2019, 5, 6),
    			LocalDate.of(2019, 5, 7));
    	Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
    	
    	System.out.println(twoYearsSixMonthsOneDay);
        List<Apple> list = Arrays.asList(new Apple(150,"red"),new Apple(160,"green"),new Apple(80,"red"));
        List<Apple> appleList = helper.filter(list,(Apple apple) -> "red".equals(apple.getColor()) );
        System.out.println(appleList);
        
        List<String> words = Arrays.asList("Hello","world");
//         = new ArrayList<String>();
//        List<String[]> list1 = 
        words.stream()
        		.map(
        				word -> {
//        					System.out.println(word.split(""));
        					return word.split("");
        				}
        				)
        		.flatMap(Arrays :: stream)
        		.distinct()
        		.forEach(
//        				word -> {
//        					int len = word.length;
//        					for(int i = 0;i<len ;i++) {
//        						System.out.print(word[i]);
//        					}
//        					System.out.println();
//        				}
        				System.out::println
        				);
//        		.collect(Collectors.toList());
        							 
     }
}
