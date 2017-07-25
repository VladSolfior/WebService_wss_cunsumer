package com.vladapps.fmanager.service;

import com.vladapps.fmanager.model.Buy;
import com.vladapps.fmanager.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface BuyService {
    Buy get(long id, long userId) throws NotFoundException;

    void delete(long id, long userId) throws NotFoundException;

    default List<Buy> getBetweenDates(LocalDate startDate, LocalDate endDate, long userId) {
        return getBetweenDateTimes(LocalDateTime.of(startDate, LocalTime.MIN), LocalDateTime.of(endDate, LocalTime.MAX), userId);
    }

    List<Buy> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime, long userId);

    List<Buy> getAll(long userId);

    Buy update(Buy buy, long userId) throws NotFoundException;

    Buy save(Buy buy, long userId);

    Buy getWithUser(long id, long userId);
}