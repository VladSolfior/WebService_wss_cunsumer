package com.vladapps.fmanager.service;

import com.vladapps.fmanager.model.Buy;
import com.vladapps.fmanager.repository.BuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

import static com.vladapps.fmanager.util.ValidationUtil.checkNotFoundWithId;


@Service
public class BuyServiceImpl implements BuyService {

    private final BuyRepository repository;

    @Autowired
    public BuyServiceImpl(BuyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Buy get(long id, long userId) {
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    @Override
    public void delete(long id, long userId) {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    @Override
    public List<Buy> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime, long userId) {
        Assert.notNull(startDateTime, "startDateTime must not be null");
        Assert.notNull(endDateTime, "endDateTime  must not be null");
        return repository.getBetween(startDateTime, endDateTime, userId);
    }

    @Override
    public List<Buy> getAll(long userId) {
        return repository.getAll(userId);
    }

    @Override
    public Buy update(Buy buy, long userId) {
        Assert.notNull(buy, "buy must not be null");
        return checkNotFoundWithId(repository.save(buy, userId), buy.getId());
    }

    @Override
    public Buy save(Buy buy, long userId) {
        Assert.notNull(buy, "buy must not be null");
        return repository.save(buy, userId);
    }

    @Override
    public Buy getWithUser(long id, long userId) {
        return checkNotFoundWithId(repository.getWithUser(id, userId), id);
    }
}