package com.pluralsight.northwind_traders_springboot.repositories;

import com.pluralsight.northwind_traders_springboot.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
