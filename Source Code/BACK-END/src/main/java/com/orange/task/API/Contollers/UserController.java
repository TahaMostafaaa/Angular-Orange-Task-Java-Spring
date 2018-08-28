package com.orange.task.API.Contollers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orange.task.API.Models.User;
import com.orange.task.API.Repos.UserRepos;

@RestController
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*") // allow client to access the headers
public class UserController {
	
	@Autowired
	private UserRepos userRepo;
	
	Map<String,String> mp_errors;
	
	@PostMapping("/createUser")
	public ResponseEntity<Object> createUser(@RequestBody @Valid User user,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			mp_errors = new HashMap<>();
			for(FieldError error:bindingResult.getFieldErrors())
			{
				mp_errors.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<>(mp_errors,HttpStatus.NOT_ACCEPTABLE);
		}
		User u = userRepo.findByEmail(user.getEmail());
		if(u != null)
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT); 
		}
		return new ResponseEntity<>(userRepo.save(user),HttpStatus.OK); 
	}

}
