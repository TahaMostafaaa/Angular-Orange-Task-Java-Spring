import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  private uri:string = "http://localhost:8080/createUser";
  private httpHeaders = {headers:new HttpHeaders({'Content-Type':'application/json'})};

  constructor(private _http:HttpClient) { }

createUser(user)
{
  return this._http.post(this.uri,user,this.httpHeaders);
}

  


  

}
