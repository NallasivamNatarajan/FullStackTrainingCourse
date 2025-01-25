import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { ILogin } from '../ILogin';
import { LoginServiceService } from '../service/login-service.service';

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
    departmentId: 0
  };
  loginData: ILogin = {
    username: '',
    password: '',
    roleName: '',
    userId: 0,
    roleId: 0,
    departmentId: 0
  };
  constructor(
    private router: Router,
    private loginservice: LoginServiceService
  ) {}

  ngOnInit(): void {

  }
  loginSubmit(loginForm: any) {
    this.loginservice
    .getLoginData(loginForm.value.username, loginForm.value.password)
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
