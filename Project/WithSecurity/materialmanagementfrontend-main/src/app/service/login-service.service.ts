import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ILogin } from '../ILogin';
import { Authrequest } from '../auth-request';

@Injectable({
  providedIn: 'root'
})

export class LoginServiceService {
  requestHeader = new HttpHeaders({ 'No-Auth': 'True' });
  logindataUrl='http://localhost:8081/material-management/user/login';//../assets/data/loginData.json';
  //loginUrl='/../assets/data/loginData.json';
  
  constructor(private http:HttpClient) { }
  
  getLoginData(authRequest : Authrequest):Observable<ILogin>{
    return this.http.post<ILogin>('http://localhost:8081/material-management/user/login', authRequest, {
     headers : this.requestHeader,
    });
    }

    getLogin(): Observable<ILogin> {
      return this.http.get<ILogin>(this.logindataUrl);
      //return this.http.get<ILogin>(this.logindataUrl);
      }
}
