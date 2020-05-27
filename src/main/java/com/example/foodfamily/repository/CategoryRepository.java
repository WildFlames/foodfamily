package com.example.foodfamily.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.foodfamily.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>  {
	
	List<Category> findAll();
}
