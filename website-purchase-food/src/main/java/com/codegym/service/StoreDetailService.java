package com.codegym.service;

import com.codegym.entity.StoreDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StoreDetailService {

    Page<StoreDetail> findAllByStore(Pageable pageable);
}
