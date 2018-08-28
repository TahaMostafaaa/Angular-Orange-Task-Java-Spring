package com.orange.task.API.Models;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "product") // Optional (JPA can detect without it)( in case you don't use JPA you have to specify every table in colume)
public class Product {
	//private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",updatable=false,nullable=false)
	private long id;
	//@Column(name = "name")
	@NotBlank(message="Please Enter a name")
	@Column(name="name",nullable = false)
	private String name;
	@Column(name="description")
	private String description;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "cat_id", referencedColumnName = "id",nullable=false)
	private Category cat;

	protected Product() {
	}
 
	public Product(String name, String description,Category cat) {
		this.name = name;
		this.description = description;
		this.cat = cat;
		
	}
	
	public Category getCat() {return cat;}
	public void setCat(Category cat) {this.cat = cat;}
	
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getdescription() {return description;}
	public void setdescription(String description) {this.description = description;}

//	public long getCatId() {return cat_id;}
//	public void setCatId(long catId) {this.cat_id = catId;}

	
	
	
 
	
}
