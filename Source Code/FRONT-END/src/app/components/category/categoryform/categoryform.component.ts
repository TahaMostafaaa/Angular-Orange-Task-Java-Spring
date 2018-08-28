import { CategoryService } from './../../../services/category.service';
import { Category } from './../../../models/category';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-categoryform',
  templateUrl: './categoryform.component.html',
  styleUrls: ['./categoryform.component.css']
})
export class CategoryformComponent implements OnInit {

  private category:Category;
  constructor(private _categoryService:CategoryService,private _router:Router) { }

  ngOnInit() {
    this.category = this._categoryService.getter();
    // if(this.category.id == undefined)
    // this._router.navigate(['/']);
  }
  processForm()
  {
    if(this.category.id == undefined)
    {
      this._categoryService.createCategory(this.category).subscribe(
        (category)=>{console.log(category); this._router.navigate(['/']); },
        (error) => { console.log(error); } 
    );
    }
    else
    {
      this._categoryService.createCategory(this.category).subscribe(
        (category)=>{
         console.log(category); this._router.navigate(['/']); },(error) => { console.log(error); } 
        );
    }
  }

}
