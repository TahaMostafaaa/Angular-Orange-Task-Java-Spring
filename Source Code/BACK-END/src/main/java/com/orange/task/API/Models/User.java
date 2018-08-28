package com.orange.task.API.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	
	@NotBlank(message="Please Enter an Email")
	@Id
	@Email(message="Please Enter a valid Email")
	@Column(nullable=false)
	private String email;
	@NotBlank(message="Please Enter your name")
	@Size(min=2,message="At least 2 letters")
	private String name;
	@NotBlank(message="Please Enter your password")
	@Size(min=4,message="At least 4 letters")
	private String password;
	@NotBlank(message="Please Enter Phone Number")
	@Size(min=11,message="At least 11 numbers")
	@Pattern(regexp="[0-9]+")
	private String phone_num;
	
	public User() {
	}
	public User(String email, String name, String password, String phone_num) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.phone_num = phone_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	

}
