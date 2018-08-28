package com.orange.task.API.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	//private static final long serialVersionUID = -3009157732242241606L;
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="id",updatable=false,nullable=false)
		private long id;
		@Column(name="name",nullable = false,unique=true)
		private String name;
		@Column(name="description")
		private String description;
//		@OneToMany
//		private List<Product> products;
		protected Category() {
		}
		public Category(String name, String description) {
			this.name = name;
			this.description = description;
		}
		public Category(long id,String name, String description) {
			this.name = name;
			this.description = description;
			this.id = id;
		}
		
		public long getId() {return id;}
		public void setId(long id) {this.id = id;}

		public String getName() {return name;}
		public void setName(String name) {this.name = name;}

		public String getdescription() {return description;}
		public void setdescription(String description) {this.description = description;}


		
}
