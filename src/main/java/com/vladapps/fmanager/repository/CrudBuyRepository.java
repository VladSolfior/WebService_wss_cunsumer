package com.vladapps.fmanager.repository;


import com.vladapps.fmanager.model.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface CrudBuyRepository extends JpaRepository<Buy, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Buy b WHERE b.id=:id AND b.user.id=:userId")
    long delete(@Param("id") long id, @Param("userId") long userId);

    @Override
    Buy save(Buy item);

    @Query("SELECT b FROM Buy b WHERE b.user.id=:userId ORDER BY b.dateTime DESC")
    List<Buy> getAll(@Param("userId") long userId);

    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT b from Buy b WHERE b.user.id=:userId AND b.dateTime BETWEEN :startDate AND :endDate ORDER BY b.dateTime DESC")
    List<Buy> getBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("userId") long userId);

    @Query("SELECT b FROM Buy b JOIN FETCH b.user WHERE b.id = ?1 and b.user.id = ?2")
    Buy getWithUser(long id, long userId);
}
