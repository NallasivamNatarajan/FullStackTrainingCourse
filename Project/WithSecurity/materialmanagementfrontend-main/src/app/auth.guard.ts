import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import { Observable } from 'rxjs';
import { AuthServiceService } from './auth-service.service';
import { LoginServiceService } from './service/login-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(
    private userAuthService: AuthServiceService,
    private router: Router,
    private userService: LoginServiceService
  ) {}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {


    //   if (this.userAuthService.getToken() !== null) {
    //     const role = route.data['role'] as Array<string>;
  
    //     if (role) {
    //       const match = this.userService.roleMatch(role);
  
    //       if (match) {
    //         return true;
    //       } else {
    //         this.router.navigate(['/forbidden']);
    //         return false;
    //       }
    //     }
    //   }
  
    //   this.router.navigate(['/login']);
    //   return false;
    return true;
     }
    
  }

