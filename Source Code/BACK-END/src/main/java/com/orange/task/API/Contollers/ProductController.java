package com.orange.task.API.Contollers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.task.API.Models.Product;
import com.orange.task.API.Services.ProductService;


@RestController
@RequestMapping("/products")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*") // allow client to access the headers
public class ProductController {
	
	@Autowired
	private ProductService productSerivce;
	
	@GetMapping("")
	public List<Product> getProducts()
	{
		return (List<Product>) productSerivce.findAll(); // just casting OR ==>
		/* implement casting handly ==> */
		// List<Product> pros = new ArrayList<>();
		// productSerivce.findAll().forEach(pros::add);
		// return pros;
	}
	
	@GetMapping("/{id}")
	public Optional<Product> getProduct(@PathVariable long id)
	{
			return productSerivce.findById(id); // OR ==>
		//	return getProducts().stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	@PostMapping("")
	public Product createProduct(@RequestBody Product pro)
	{
		return productSerivce.save(pro);
	}
	@PutMapping("")
	public Product updateProduct(@RequestBody Product pro)
	{
		return productSerivce.save(pro);
		
	}
	// special methods just for angular
//	@PostMapping("/{cat_name}")
//	public Product createProduct(@RequestBody Product pro,@PathVariable long cat_name)
//	{
//		pro.setCat(categoryRep.getOne(cat_name));
//		return productSerivce.save(pro);
//	}
//	@PutMapping("/{cat_name}")
//	public Product updateProduct(@RequestBody Product pro,@PathVariable long cat_name)
//	{
//		pro.setCat(categoryRep.getOne(cat_name));
//		return productSerivce.save(pro);
//		
//	}
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable long id)
	{
		productSerivce.deleteById(id);
		//return true;
	}

}
