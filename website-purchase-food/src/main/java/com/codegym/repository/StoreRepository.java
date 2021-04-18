package com.codegym.repository;

import com.codegym.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface StoreRepository extends JpaRepository<Store, Integer> {

    @Modifying
    @Query(value = "INSERT INTO `fast_food`.`store` (`address`, `name`, `phone`, `account_id`, `time_end`, `time_start`, `preparation_time`) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7) ", nativeQuery = true)
    void createStore(String address, String name, String phone, Integer accountId, String timeEnd, String timeStart, String preparationTime);

    @Modifying
    @Query(value = "UPDATE `fast_food`.`store` SET `address` = ?1, `name` = ?2, `phone` = ?3, `time_end` = ?4, `time_start` = ?5 , `preparation_time` = ?6 WHERE (`id` = ?7)", nativeQuery = true)
    void updateStore(String address, String name, String phone, String timeEnd, String timeStart, String preparationTime);
}
