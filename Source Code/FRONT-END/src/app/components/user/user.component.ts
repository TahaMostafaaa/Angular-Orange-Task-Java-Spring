import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  private user = new User();
  private userError:User;
  private isCreated:boolean=false;
  private userExist:boolean=false;

  constructor(private _userSerivce:UserService) { }

  ngOnInit() {
  }

  createUser()
  {
    this._userSerivce.createUser(this.user).subscribe(

      data=>{console.log(data); this.user = new User(); this.isCreated=true; this.userExist = false; this.userError = new User(); },
      error=>{console.log(error); this.userError = error.error;
      if(error.status == 409)
      { this.userExist = true; this.isCreated=false;}
      
      }
    )
  }

}
