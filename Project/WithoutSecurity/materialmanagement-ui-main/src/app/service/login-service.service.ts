import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ILogin } from '../ILogin';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
  logindataUrl='http://localhost:8081/material-management/user/login';//../assets/data/loginData.json';
  //loginUrl='/../assets/data/loginData.json';
  
  constructor(private http:HttpClient) { }
  
  getLoginData(username:string,password:string):Observable<ILogin>{
    return this.http.get<ILogin>('http://localhost:8081/material-management/user/login?username='+username+'&pass='+password);
    }

    getLogin(): Observable<ILogin> {
      return this.http.get<ILogin>(this.logindataUrl);
      //return this.http.get<ILogin>(this.logindataUrl);
      }
}
