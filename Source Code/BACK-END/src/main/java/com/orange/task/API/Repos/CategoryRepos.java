package com.orange.task.API.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orange.task.API.Models.Category;

public interface CategoryRepos extends JpaRepository<Category, Long>{
 //   List<Product> findById(long id);

	Category findByName(String name);
}
