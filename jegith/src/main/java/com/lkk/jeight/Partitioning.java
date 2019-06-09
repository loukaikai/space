package com.lkk.jeight;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.lkk.jeight.pojo.Data;
import com.lkk.jeight.pojo.Dish;
import com.lkk.jeight.pojo.Dish.Type;

public class Partitioning {
	public static void main(String[] args) {
       /* Map<Boolean, List<Dish>> partitionedMenu = Data.Menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);
        System.out.println(partitionedMenu.get(true));
*/
       /* Map<Boolean, Map<Type, List<Dish>>> vegetarianDishByType = Data.Menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
        System.out.println(vegetarianDishByType);
*/
        Map<Boolean, Object> collect = Data.Menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(collect); 
    }
}
