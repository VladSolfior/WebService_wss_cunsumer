package com.vladapps.fmanager.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "buys")
public class Buy extends BaseEntity {

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "description", nullable = false)
    private String description;


    @Column(name = "total", nullable = false)
    @Range(min = 1, max = 2000000)
    private int total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;



    public Buy(LocalDateTime dateTime, String description, int total) {
        this.dateTime = dateTime;
        this.description = description;
        this.total = total;
    }

    public Buy() {
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getTotal() {
        return total;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    @Override
    public String toString() {
        return "Buy{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", total=" + total +
                ", user=" + user +
                '}';
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
