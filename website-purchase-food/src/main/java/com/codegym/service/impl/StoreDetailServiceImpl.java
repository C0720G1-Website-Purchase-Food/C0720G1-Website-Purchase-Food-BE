package com.codegym.service.impl;

import com.codegym.entity.StoreDetail;
import com.codegym.repository.StoreDetailRepository;
import com.codegym.service.StoreDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StoreDetailServiceImpl implements StoreDetailService {
    @Autowired
    StoreDetailRepository storeDetailRepository;
    @Override
    public Page<StoreDetail> findAllByStore(Pageable pageable) {
        return storeDetailRepository.findAllByStore(pageable);
    }
}
