package com.vladapps.fmanager.repository;


import com.vladapps.fmanager.model.Buy;

import java.time.LocalDateTime;
import java.util.List;

public interface BuyRepository {
    // null if updated meal do not belong to userId
    Buy save(Buy buy, long userId);

    // false if meal do not belong to userId
    boolean delete(long id, long userId);

    // null if meal do not belong to userId
    Buy get(long id, long userId);

    // ORDERED dateTime
    List<Buy> getAll(long userId);

    // ORDERED dateTime
    List<Buy> getBetween(LocalDateTime startDate, LocalDateTime endDate, long userId);

    default Buy getWithUser(long id, long userId) {
        throw new UnsupportedOperationException();
    }
}

