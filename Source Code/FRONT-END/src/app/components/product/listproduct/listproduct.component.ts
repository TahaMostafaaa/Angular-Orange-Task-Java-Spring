import { ProductService } from './../../../services/product.service';
import { Product } from './../../../models/product';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-listproduct',
  templateUrl: './listproduct.component.html',
  styleUrls: ['./listproduct.component.css']
})
export class ListproductComponent implements OnInit {

  private products:Product[];

  constructor(private _productService:ProductService,private _router:Router) { }

  ngOnInit() {
    this._productService.getProducts().subscribe((products)=> {
       console.log(products);
      this.products = products },
      (error)=>{ console.log(error);
      })
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
