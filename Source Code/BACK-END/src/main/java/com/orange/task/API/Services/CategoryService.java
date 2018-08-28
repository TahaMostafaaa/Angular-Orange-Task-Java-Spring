package com.orange.task.API.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.task.API.Models.Category;
import com.orange.task.API.Models.Product;
import com.orange.task.API.Repos.CategoryRepos;
import com.orange.task.API.Repos.ProductRepos;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepos CategoryRep;
	@Autowired
	private ProductRepos ProductRep;
	
	public List<Category> findAll()
	{
		
		return (List<Category>) CategoryRep.findAll(); // just casting OR ==>
		/* implement casting handly ==> */
		// List<Category> pros = new ArrayList<>();
		// CategoryRep.findAll().forEach(pros::add);
		// return pros;
	}
	
	public Optional<Category> findById(long id)
	{
		
			return CategoryRep.findById(id); // OR ==>
		//	return getCategorys().stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	public Category getOne(long id)
	{
		return CategoryRep.getOne(id);
	}

	public List<Product> getProductsInCategory(long id)
	{
		return ProductRep.getProductsByCat(CategoryRep.getOne(id));
	}

	public Category save(Category pro)
	{
		return CategoryRep.save(pro);
	}

	public void deleteById(long id)
	{
		CategoryRep.deleteById(id);
		//return true;
	}

}
