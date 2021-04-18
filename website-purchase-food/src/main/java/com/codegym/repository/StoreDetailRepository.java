package com.codegym.repository;

import com.codegym.entity.StoreDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface StoreDetailRepository extends JpaRepository<StoreDetail, Integer> {

    @Query(value = "select * from store_detail where category_id = ? ", nativeQuery = true)
    Page<StoreDetail> findAllByStore(Pageable pageable);
}
