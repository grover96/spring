package com.jpa.exercise.amazonecommerce.repository;

import com.jpa.exercise.amazonecommerce.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
