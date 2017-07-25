package com.vladapps.fmanager.util;

import com.vladapps.fmanager.model.Buy;
import com.vladapps.fmanager.to.BuysExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionsUtil {


    public static final int DEFAULT_SPEND_PER_DAY = 500;


    public static void main(String[] args) {
        List<Buy> buys = Arrays.asList(
                new Buy(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Latte", 5),
                new Buy(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Bread", 50),
                new Buy(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Taxi", 200),

                new Buy(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Latte", 45),
                new Buy(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Dress", 65),
                new Buy(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "CocaCola", 410)
        );
        List<BuysExceed> buysExceeds = getFilteredWithExceeded(buys, LocalTime.of(7, 0), LocalTime.of(12, 0), 500);
        buysExceeds.forEach(System.out::println);
    }

    public static List<BuysExceed> getFilteredWithExceeded(List<Buy> buys, LocalTime startTime, LocalTime endTime, int budgetedToDay) {
        Map<LocalDate, Integer> totalsSumByDate = buys.stream()
                .collect(
                        Collectors.groupingBy(Buy::getDate, Collectors.summingInt(Buy::getTotal))
//                      Collectors.toMap(Buy::getDate, Buy::getTotal, Integer::sum)
                );

        return buys.stream()
                .filter(buy -> TimeUtil.isBetween(buy.getTime(), startTime, endTime))
                .map(buy -> createWithExceed(buy, totalsSumByDate.get(buy.getDate()) > budgetedToDay))
                .collect(Collectors.toList());
    }

    public static BuysExceed createWithExceed(Buy buy, boolean exceeded) {
        return new BuysExceed(buy.getDateTime(), buy.getDescription(), buy.getTotal(), exceeded);
    }
}