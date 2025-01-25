import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import { EventComponent } from './event/event.component';
import { EventTemplateFormComponent } from './event-template-form/event-template-form.component';
import { EventReactiveFormComponent } from './event-reactive-form/event-reactive-form.component';
import { OrderComponent } from './interaction/order/order.component';
import { SalesComponent } from './interaction/sales/sales.component';
import { HomeComponent } from './angular-material/home/home.component';
import { RegisterComponent } from './angular-material/register/register.component';
import { AboutComponent } from './angular-material/about/about.component';
import { SearchComponent } from './angular-material/search/search.component';
import { DashboardComponent } from './angular-material/dashboard/dashboard.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'viewAllCourses', component: DashboardComponent },
  { path: 'listAllParticipantsByCourse', component: SearchComponent },
  { path: 'aboutUs', component: AboutComponent },
  { path: 'registration', component: RegisterComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}