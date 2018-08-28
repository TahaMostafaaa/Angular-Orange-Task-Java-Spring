import { Category } from './../models/category';
import { Injectable } from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import { Observable ,throwError} from 'rxjs';
import { map , catchError  } from 'rxjs/operators';

//import { throwError } from 'rxjs/observable';



@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private baseUrl:string='http://localhost:8080';
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({headers:this.headers});
  private category = new Category();
  constructor(private _http:Http) { }
  getCategories()
  {
    return this._http.get(this.baseUrl+'/categories',this.options).pipe(map((Response:Response)=>Response.json())
    ,catchError(this.errorHandler));
    
  }
  getCategory(id:Number)
  {
    return this._http.get(this.baseUrl+'/categories/'+id,this.options).pipe(map((Response:Response)=>Response.json())
    ,catchError(this.errorHandler));
    
  }
  deleteCategory(id:Number)
  {
    return this._http.delete(this.baseUrl+'/categories/'+id,this.options);
    
  }
  createCategory(category:Category)
  {
    return this._http.post(this.baseUrl+'/categories',JSON.stringify(category),this.options).pipe(map((Response:Response)=>Response.json())
    ,catchError(this.errorHandler));
    
  }
  updateCategory(category:Category)
  {
    return this._http.put(this.baseUrl+'/categories',JSON.stringify(category),this.options).pipe(map((Response:Response)=>Response.json())
    ,catchError(this.errorHandler));
    
  }
  getProductsOfCategory(id:Number)
  {
    return this._http.get(this.baseUrl+'/categories/'+id+'/products',this.options).pipe(map((Response:Response)=>Response.json())
    ,catchError(this.errorHandler));
  }
  errorHandler(error:Response)
  {
    return throwError(error || "SERVER ERROR");
  }
  setter(category:Category)
  {
    this.category = category;
  }
  getter()
  {
    return this.category;
  }
}
