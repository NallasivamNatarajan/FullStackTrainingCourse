import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { ILogin } from '../ILogin';
import { LoginServiceService } from '../service/login-service.service';
import { Authrequest } from '../auth-request';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  invalidMessage = '';
  loginAPIData: ILogin = {
    username: '',
    password: '',
    roleName: '',
    userId: 0,
    roleId: 0,
    departmentId: 0,
    jwtToken:''
  };
  loginData: ILogin = {
    username: '',
    password: '',
    roleName: '',
    userId: 0,
    roleId: 0,
    departmentId: 0,
    jwtToken:''
  };
  authRequest !: Authrequest;
  tokenString!:string;
  constructor(
    private router: Router,
    private loginservice: LoginServiceService
  ) {}

  ngOnInit(): void {

  }
  loginSubmit(loginForm: any) {
    this.authRequest = new Authrequest(loginForm.value.username, loginForm.value.password);
    this.loginservice
    .getLoginData(this.authRequest)
    .subscribe((d) => {
    if (d.roleName != null) {
    localStorage.clear();
    localStorage.setItem(
    'userData',
    JSON.stringify({
    name: loginForm.value.username,
    role:d.roleName,
    id:d.userId
    })
    );
    this.tokenString = d.jwtToken;
    localStorage.setItem('jwtToken', this.tokenString);
    this.router.navigate(['/home/dashboard']);
    } else {
    Swal.fire('', 'Invalid Credentials', 'error');
    loginForm.reset();
    }
    }, error => {
      console.log(error);
      Swal.fire('', 'Invalid Credentials', 'error');
    loginForm.reset();
    });
    }

    // loginDataSubmit(loginForm: any) {
    // this.loginservice.getLogin().subscribe(d=>{
    //   if(d.roleName!=null){
    //   localStorage.clear();
    //   localStorage.setItem(
    //   'userData',
    //   JSON.stringify({
    //   name: loginForm.value.username,
    //   role: d.roleName,
    //   })
    //   );
    //   this.router.navigate(['/home/dashboard']);
    //   }
    //   else{
    //   Swal.fire('', 'Invalid Credentials', 'error');
    //   loginForm.reset();
    //   }
    //   });
    // }
}
