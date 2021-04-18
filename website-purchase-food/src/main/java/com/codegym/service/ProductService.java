package com.codegym.service;

import com.codegym.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAllProductStore(Integer storeId, Pageable pageable);

    Page<Product> findAllProductStoreAndCategory(Integer storeId, Integer categoryId, Pageable pageable);
}
