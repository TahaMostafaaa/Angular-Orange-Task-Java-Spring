package com.orange.task.API;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner{
	// implement CommandLineRunner to just run some testing in starting application
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	
		
	}
	public void run(String...args) throws Exception
	{
		
//		catgory.save(new Category("LapTops", "LapTops"));
 //   product.save(new Product("HP","Amrican one", catgory.getOne((long) 1)));
		
	}
	
}
