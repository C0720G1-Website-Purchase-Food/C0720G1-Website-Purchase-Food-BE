package com.codegym.service;

import com.codegym.dto.StoreDTO;
import com.codegym.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StoreService {
    Page<Store> findAllStore(Pageable pageable);

    Store findById(Integer id);

    void createStore(StoreDTO storeDTO);

    void updateStore(StoreDTO storeDTO);
}
