package com.vladapps.fmanager.repository;

import com.vladapps.fmanager.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    long delete(@Param("id") int id);

    @Override
    @Transactional
    User save(User user);

    @Override
    User findOne(Long id);

    @Override
    List<User> findAll(Sort sort);

    User getByEmail(String email);

//    @Query("SELECT u FROM User u LEFT JOIN FETCH u.buys WHERE u.id = ?1")
//    @EntityGraph(value = User.GRAPH_WITH_BUYS)

    @EntityGraph(attributePaths={"buys", "roles"})
    @Query("SELECT u FROM User u WHERE u.id=?1")
    User getWithBuys(long id);
}
