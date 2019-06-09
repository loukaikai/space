package com.lkk.jeight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.lkk.jeight.Grouping.CaloricLevel;
import com.lkk.jeight.pojo.Data;
import com.lkk.jeight.pojo.Dish;
import com.lkk.jeight.pojo.Dish.Type;

public class Grouping {
	public enum CaloricLevel {
        DIET, NORMAL, FAT
    };

    public static void main(String[] args) {
        System.out.println(CaloricLevel.DIET.name());
        System.out.println(CaloricLevel.DIET.ordinal());
        System.out.println(CaloricLevel.DIET.getClass());
        /*Map<Type, List<Dish>> dishesByType = Data.Menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishesByType.get(Dish.Type.FISH).get(0));*/

       /* Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Data.Menu.stream().collect(Collectors.groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        }));
        System.out.println(dishesByCaloricLevel);*/


     /*   Map<Type, Long> typesCount = Data.Menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(typesCount);*/

    /*  Map<Type, Optional<Dish>> mostCaloricByType = Data.Menu.stream().collect(
                Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType);*/

        /* Map<Type, Dish> mostCaloricDishByType = Data.Menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCaloricDishByType);*/

        /* Map<Type, IntSummaryStatistics> totalCaloriesByType = Data.Menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.summarizingInt(Dish::getCalories)));
        System.out.println(totalCaloriesByType);*/

       /* Map<Type, Set<CaloricLevel>> caloricLevelsByType = Data.Menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                }, Collectors.toCollection(HashSet::new))));
        System.out.println(caloricLevelsByType);*/
        
        List<Dish> dishes = Data.Menu.stream().collect(
        		ArrayList::new,
        		List::add,
        		List::addAll);
    }

}
