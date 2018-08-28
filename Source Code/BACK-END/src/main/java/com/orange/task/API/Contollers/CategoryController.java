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
import com.orange.task.API.Models.Category;
import com.orange.task.API.Models.Product;
import com.orange.task.API.Services.CategoryService;
import com.orange.task.API.Services.ProductService;


@RestController
@RequestMapping("/categories")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*") // allow client to access the headers
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	@GetMapping("")
	public List<Category> getCategories()
	{
		
		return (List<Category>) categoryService.findAll(); // just casting OR ==>
		/* implement casting handly ==> */
		// List<Category> pros = new ArrayList<>();
		// categoryService.findAll().forEach(pros::add);
		// return pros;
	}
	
	@GetMapping("/{id}")
	public Optional<Category> getCategory(@PathVariable long id)
	{
		
			return categoryService.findById(id); // OR ==>
		//	return getCategorys().stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	@GetMapping("/{id}/products")
	public List<Product> getProductsInCategory(@PathVariable long id)
	{
		return productService.getProductsByCat(id);
	}
	@PostMapping("")
	public Category createCategory(@RequestBody Category pro)
	{
		return categoryService.save(pro);
	}
	@PutMapping("")
	public Category updateCategory(@RequestBody Category pro)
	{
		return categoryService.save(pro);
		
	}
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable long id)
	{
		categoryService.deleteById(id);
		//return true;
	}

}
