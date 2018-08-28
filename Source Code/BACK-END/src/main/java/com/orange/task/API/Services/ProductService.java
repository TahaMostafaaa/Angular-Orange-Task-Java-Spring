package com.orange.task.API.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.task.API.Models.Product;
import com.orange.task.API.Repos.CategoryRepos;
import com.orange.task.API.Repos.ProductRepos;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepos productRep;
	@Autowired
	private CategoryRepos categoryRep;
	

	public List<Product> findAll()
	{
		return (List<Product>) productRep.findAll(); // just casting OR ==>
		/* implement casting handly ==> */
		// List<Product> pros = new ArrayList<>();
		// productRep.findAll().forEach(pros::add);
		// return pros;
	}
	
	public Optional<Product> findById(long id)
	{
			return productRep.findById(id); // OR ==>
		//	return getProducts().stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	public  List<Product> getProductsByCat(long id)
	{
		return productRep.getProductsByCat(categoryRep.getOne(id));
	}
	public Product save(Product pro)
	{
		return productRep.save(pro);
	}

	public void deleteById(long id)
	{
		productRep.deleteById(id);
		//return true;
	}

}
