import { Component, OnInit } from '@angular/core';
import { UserApiService } from '../user-api.service';

@Component({
  selector: 'app-user-api',
  templateUrl: './user-api.component.html',
  styleUrls: ['./user-api.component.css']
})
export class UserApiComponent implements OnInit {
  id!:number;
  users!: any;
  
  constructor(private userService: UserApiService) {}

  ngOnInit(){
    this.userService.getUsers(this.id).subscribe((res:any) => {
      this.users = res;
    }),console.error();
  }
  searchUser(){
    this.userService.getUsers(this.id).subscribe((res:any) => {
      this.users = res;
    }),console.error();
    
   }


}
