package com.vladapps.fmanager;


import com.vladapps.fmanager.model.BaseEntity;

import static com.vladapps.fmanager.util.TransactionsUtil.DEFAULT_SPEND_PER_DAY;

public class AuthorizedUser {
    public static long id = BaseEntity.START_SEQ;

    public static long getId() {
        return id;
    }

    public static void setId(long id) {
        AuthorizedUser.id = id;
    }

    public static long getSpendPerDay() {
        return DEFAULT_SPEND_PER_DAY;
    }
}