package com.codegym.repository;

import com.codegym.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM fast_food.product where store_id = ?1", nativeQuery = true)
    Page<Product> findAllByStore(Integer storeId, Pageable pageable);

    @Query(value = "SELECT * FROM fast_food.product where store_id = ?1, and category_id = ?2", nativeQuery = true)
    Page<Product> findAllByStoreAndCategory(Integer storeId, Integer categoryId, Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO fast_food.product (`discount`, `name`, `price`, `category_id`, `store_id`, `image`)" +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6) ", nativeQuery = true)
    void createProduct(Integer discount, String name, String price, Integer categoryId, Integer storeId, String image);
}
