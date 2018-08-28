import { Product } from './../models/product';
import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import { Observable ,throwError} from 'rxjs';
import { map , catchError  } from 'rxjs/operators';

//import { throwError } from 'rxjs/observable';



@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl:string='http://localhost:8080';
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private product = new Product();
  constructor(private _http:Http) { }
  getProducts()
  {
    return this._http.get(this.baseUrl+'/products',this.options).pipe(map((Response:Response)=>Response.json())
    ,catchError(this.errorHandler));
    
  }
  getProduct(id:Number)
  {
    return this._http.get(this.baseUrl+'/products/'+id,this.options).pipe(map((Response:Response)=>Response.json())
    ,catchError(this.errorHandler));
    
  }
  deleteProduct(id:Number)
  {
    return this._http.delete(this.baseUrl+'/products/'+id,this.options);
    
  }
  createProduct(product:Product)
  {
    return this._http.post(this.baseUrl+'/products',JSON.stringify(product),this.options).pipe(map((Response:Response)=>Response.json())
    ,catchError(this.errorHandler));
    
  }
  updateProduct(product:Product)
  {
    return this._http.put(this.baseUrl+'/products',JSON.stringify(product),this.options).pipe(map((Response:Response)=>Response.json())
    ,catchError(this.errorHandler));
    
  }
  errorHandler(error:Response)
  {
    return throwError(error || "SERVER ERROR");
  }
  setter(product:Product)
  {
    this.product = product;
  }
  getter()
  {
    return this.product;
  }
}
