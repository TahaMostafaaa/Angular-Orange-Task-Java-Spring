import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { RouterModule,Routes } from '@angular/router';
import { HttpModule } from '@angular/http';
import {HttpClientModule} from '@angular/common/http';
import{ FormsModule } from '@angular/forms';

import { ListproductofcategoryComponent } from './components/category/listproductofcategory/listproductofcategory.component';
import { ProductformComponent } from './components/product/productform/productform.component';
import { ListproductComponent } from './components/product/listproduct/listproduct.component';
import { CategoryformComponent } from './components/category/categoryform/categoryform.component';
import { ListcategoryComponent } from './components/category/listcategory/listcategory.component';
import { UserComponent } from './components/user/user.component';
import { AppComponent } from './app.component';


const appRoutes:Routes = [
  { path : '' , component:ListcategoryComponent},
  { path : 'category/edit' , component:CategoryformComponent},
  { path : 'register' , component:UserComponent},
  { path : 'products' , component:ListproductComponent},
  { path : 'product/edit' , component:ProductformComponent},
  { path : 'category/products' ,  component:ListproductofcategoryComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    ListproductComponent,
    ProductformComponent,
    UserComponent,
    ListcategoryComponent,
    CategoryformComponent,
    ListproductofcategoryComponent

  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
