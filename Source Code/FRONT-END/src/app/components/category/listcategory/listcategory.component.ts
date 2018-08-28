import { CategoryService } from './../../../services/category.service';
import { Category } from './../../../models/category';
import { Product } from './../../../models/product';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-listcategory',
  templateUrl: './listcategory.component.html',
  styleUrls: ['./listcategory.component.css']
})
export class ListcategoryComponent implements OnInit {
  
  private categories:Category[];
  private products:Product[];

  constructor(private _categoryService:CategoryService,private _router:Router) { }

  ngOnInit() {
    this._categoryService.getCategories().subscribe((categories)=> {
      console.log(categories);
     this.categories = categories },
     (error)=>{ console.log(error);
     })
  }
  deleteCategory(category){
    this._categoryService.deleteCategory(category.id).subscribe((data)=>{
      this.categories.splice(this.categories.indexOf(category),1);
  },(error)=>{
    console.log(error);
  });
  
  }
  updateCategory(category)
  {
    this._categoryService.setter(category);
    this._router.navigate(['category/edit']);
  }
  createCategory()
  {
    let category = new Category();
    this._categoryService.setter(category);
    this._router.navigate(['category/edit']);
  }
  getProductsOfCategory(category)
  {
    this._categoryService.setter(category);
    this._router.navigate(['category/products']);
  }
  getAllProducts()
  {
    this._router.navigate(['products']);
  }
}
