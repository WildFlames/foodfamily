package com.example.foodfamily.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.foodfamily.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("select p from Product p where p.id = :idProduct")
	Product findOne(@Param("idProduct") Long idProduct);
	
	List<Product> findAllByLocale(String locale);
	
	@Query("select p from Product p where p.type.id = :id and p.locale = :locale")
	List<Product> findAllByCategoryIdAndLocale(@Param("id") Long id, @Param("locale") String locale);
}
