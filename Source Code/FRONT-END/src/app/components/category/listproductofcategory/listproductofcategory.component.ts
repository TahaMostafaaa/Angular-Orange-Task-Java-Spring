import { CategoryService } from './../../../services/category.service';
import { Category } from './../../../models/category';
import { ProductService } from './../../../services/product.service';
import { Product } from './../../../models/product';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-listproductofcategory',
  templateUrl: './listproductofcategory.component.html',
  styleUrls: ['./listproductofcategory.component.css']
})
export class ListproductofcategoryComponent implements OnInit {
  private products:Product[];
  private category:Category;
  constructor(private _categoryService:CategoryService,private _productService:ProductService,private _router:Router,) { }

  ngOnInit() {
    this.category = this._categoryService.getter();
    this._categoryService.getProductsOfCategory(this.category.id).subscribe((products)=> {
      console.log(products);
     this.products = products },
     (error)=>{ console.log(error);
     });
   // this._router.navigate(['category/products']);
  }
  deleteProduct(product){
    this._productService.deleteProduct(product.id).subscribe(
      (data)=>{this.products.splice(this.products.indexOf(product),1);
  },
  (error)=>{console.log(error);});
  }
  updateProduct(product)
  {
    this._productService.setter(product);
    this._router.navigate(['/product/edit']);
  }
  createProduct()
  {
    let product = new Product();
    this._productService.setter(product);
    this._router.navigate(['/product/edit']);
  }
  

}
