package com.vladapps.fmanager.repository;

import com.vladapps.fmanager.model.Buy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DataJpaBuyRepository implements BuyRepository {

    @Autowired
    private CrudUserRepository crudUserRepository;

    @Autowired
    private CrudBuyRepository crudBuyRepository;


    @Override
    @Transactional
    public Buy save(Buy buy, long userId) {
        if (buy.isNew() && get(buy.getId(), userId) == null) {
            return null;
        }
        buy.setUser(crudUserRepository.getOne(userId));
        return crudBuyRepository.save(buy);
    }

    @Override
    public boolean delete(long id, long userId) {
        return crudBuyRepository.delete(id, userId) != 0;
    }
    /*  complete here  */

    @Override
    public Buy get(long id, long userId) {
        return null;
    }

    @Override
    public List<Buy> getAll(long userId) {
        return null;
    }

    @Override
    public List<Buy> getBetween(LocalDateTime startDate, LocalDateTime endDate, long userId) {
        return null;
    }

    @Override
    public Buy getWithUser(long id, long userId) {
        return null;
    }
}
