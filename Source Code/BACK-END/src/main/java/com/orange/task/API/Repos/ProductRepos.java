package com.orange.task.API.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orange.task.API.Models.Category;
import com.orange.task.API.Models.Product;

public interface ProductRepos extends JpaRepository<Product, Long>{
 //   List<Product> findById(long id);
	public List<Product> getProductsByCat(Category cat);
}
