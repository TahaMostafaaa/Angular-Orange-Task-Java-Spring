import { CategoryService } from './../../../services/category.service';
import { Category } from './../../../models/category';
import { ProductService } from './../../../services/product.service';
import { Product } from './../../../models/product';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { IfStmt } from '@angular/compiler';


@Component({
  selector: 'app-productform',
  templateUrl: './productform.component.html',
  styleUrls: ['./productform.component.css']
})
export class ProductformComponent implements OnInit {
  private product:Product;
  private categories:Category[];

  constructor(private _productService:ProductService,private _categoryService:CategoryService,private _router:Router) { }

  ngOnInit() {
    this.product = this._productService.getter();
    this._categoryService.getCategories().subscribe((categories)=> {
      console.log(categories);
     this.categories = categories },
     (error)=>{ console.log(error);
     })
    // if(this.product.id == undefined)
    // this._router.navigate(['/']);
  }
  processForm()
  {
    
    if(this.product.id == undefined)
    {

      this._productService.createProduct(this.product).subscribe((product)=>{
     console.log(product); this._router.navigate(['/']); },(error) => { console.log(error); } 
    );
    }
    else
    {
      this._productService.updateProduct(this.product).subscribe((product)=>{
         console.log(product); this._router.navigate(['/']); },(error) => { console.log(error); } 
        );
    }
  }

}
