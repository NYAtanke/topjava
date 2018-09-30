package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

/*Реализовать метод UserMealsUtil.getFilteredWithExceeded:
-  должны возвращаться только записи между startTime и endTime
-  поле UserMealWithExceed.exceed должно показывать,
                                     превышает ли сумма калорий за весь день параметра метода caloriesPerDay

Т.е UserMealWithExceed - это запись одной еды, но поле exceeded будет одинаково для всех записей за этот день.

- Проверьте результат выполнения ДЗ (можно проверить логику в http://topjava.herokuapp.com , список еды)
- Оцените Time complexity вашего алгоритма, если он O(N*N)- попробуйте сделать O(N).*/


public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );

        System.out.println(getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000));
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with correctly exceeded field
//        List<UserMealWithExceed> filteredList = new ArrayList<>();
        Map<LocalDate, Integer> exceedMapDate = new HashMap<>();


//        for (UserMeal userMeal: mealList) {
//
//                if (!exceedMapDate.containsKey(userMeal.getDateTime().toLocalDate()))
//                    exceedMapDate.put(userMeal.getDateTime().toLocalDate(), userMeal.getCalories());
//                else {
//                    int exceed = exceedMapDate.get(userMeal.getDateTime().toLocalDate());
//                    exceedMapDate.put(userMeal.getDateTime().toLocalDate(), userMeal.getCalories() + exceed);
//                }
//            }
//
//        for (UserMeal userMeal: mealList) {
//            if (userMeal.getDateTime().toLocalTime().isAfter(startTime) && userMeal.getDateTime().toLocalTime().isBefore(endTime)){
//                filteredList.add(new UserMealWithExceed(userMeal.getDateTime(), userMeal.getDescription(), userMeal.getCalories(), exceedMapDate.get(userMeal.getDateTime().toLocalDate()) > caloriesPerDay));
//            }
//
//        }
//        return filteredList;


        for (UserMeal userMeal: mealList) {
            exceedMapDate.computeIfPresent(userMeal.getDateTime().toLocalDate(),  (k,v)-> v + userMeal.getCalories());
            exceedMapDate.computeIfAbsent(userMeal.getDateTime().toLocalDate(),  v -> userMeal.getCalories());

        }

        return mealList
                .stream()
                .filter(m -> m.getDateTime().toLocalTime().isAfter(startTime) && m.getDateTime().toLocalTime().isBefore(endTime))
                .map(m -> new UserMealWithExceed(m.getDateTime(), m.getDescription(), m.getCalories(), exceedMapDate.get(m.getDateTime().toLocalDate()) > caloriesPerDay))
                .collect(Collectors.toList());

    }



}
