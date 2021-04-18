package com.codegym.service.impl;

import com.codegym.entity.Product;
import com.codegym.repository.ProductRepository;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> findAllProductStore(Integer storeId, Pageable pageable) {
        return productRepository.findAllByStore(storeId, pageable);
    }

    @Override
    public Page<Product> findAllProductStoreAndCategory(Integer storeId, Integer categoryId, Pageable pageable) {
        return productRepository.findAllByStoreAndCategory(storeId, categoryId, pageable);
    }
}
