import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserApiService {

  constructor(private httpClient:HttpClient) { }
  
  getUsers(id:number){
    if(id){
      return this.httpClient.get("https://jsonplaceholder.typicode.com/users/"+id);
    }else{
      return this.httpClient.get("https://jsonplaceholder.typicode.com/users");
    }
  }
}