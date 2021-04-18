package com.codegym.service.impl;

import com.codegym.dto.StoreDTO;
import com.codegym.entity.Store;
import com.codegym.repository.StoreRepository;
import com.codegym.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StoreServeImpl implements StoreService {

    @Autowired
    StoreRepository storeRepository;

    @Override
    public Page<Store> findAllStore(Pageable pageable) {
        return storeRepository.findAll(pageable);
    }

    @Override
    public Store findById(Integer id) {
        return storeRepository.findById(id).orElse(null);
    }

    @Override
    public void createStore(StoreDTO storeDTO) {
        storeRepository.createStore(storeDTO.getAddress(), storeDTO.getName(), storeDTO.getPhone(), storeDTO.getAccountId(), storeDTO.getTimeEnd(), storeDTO.getTimeStart(), storeDTO.getPreparationTime());
    }

    @Override
    public void updateStore(StoreDTO storeDTO) {
        storeRepository.updateStore(storeDTO.getAddress(), storeDTO.getName(), storeDTO.getPhone(), storeDTO.getTimeEnd(), storeDTO.getTimeStart(), storeDTO.getPreparationTime());
    }
}
