import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { AppComponent } from './app.component';
import { EventComponent } from './event/event.component';
import { EventFilterPipe } from './event-filter.pipe';
import { EmployeeComponent } from './employee/employee.component';
import { EmployeeGradeFilterPipe } from './employee-grade-filter.pipe';
import { EventTemplateFormComponent } from './event-template-form/event-template-form.component';
import { EventDirective } from './event.directive';
import { EventReactiveFormComponent } from './event-reactive-form/event-reactive-form.component';
import { BaseComponent } from './interaction/base/base.component';
import { ExistingComponent } from './interaction/existing/existing.component';
import { EventDateDirective } from './event-reactive-form/event-date.directive';
import { SalesComponent } from './interaction/sales/sales.component';
import { OrderComponent } from './interaction/order/order.component';
import { OrderFilter } from './interaction/order-filter.pipe';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './angular-material/home/home.component';
import { RegisterComponent } from './angular-material/register/register.component';
import { ParticipantsComponent } from './angular-material/participants/participants.component';
import { SearchComponent } from './angular-material/search/search.component';
import { AboutComponent } from './angular-material/about/about.component';
import { DashboardComponent } from './angular-material/dashboard/dashboard.component';
import { SidenavComponent } from './angular-material/sidenav/sidenav.component';
import { HeaderComponent } from './angular-material/header/header.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';
import { MatButtonModule } from '@angular/material/button';
import { ApplicationServService } from './application-serv.service';
import { EventParentComponent } from './interaction/event-parent/event-parent.component';
import { ParticipantChildComponent } from './interaction/participant-child/participant-child.component';
import { EventCodeFilterPipe } from './interaction/event-code-filter.pipe';
import { CandidateTemplateDrivenFormComponent } from './angular-assesment/candidate-template-driven-form/candidate-template-driven-form.component';
import { ChooseJobDirective } from './angular-assesment/choose-job.directive';
import { UserApiComponent } from './angular-assesment/service-mapping/user-api/user-api.component';
import { UserApiService } from './angular-assesment/service-mapping/user-api.service';
import { HttpClientModule } from '@angular/common/http';
import { ParticipantJsonService } from './interaction/participant-json.service';
import { NewProductRequestComponent } from './new-product-request/new-product-request.component';
import { NgxDropzoneModule } from 'ngx-dropzone';
import { ViewProductsComponent } from './view-products/view-products.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';


@NgModule({
  declarations: [
    AppComponent,
    EventComponent,
    EventFilterPipe,
    EmployeeComponent,
    EmployeeGradeFilterPipe,
    EventTemplateFormComponent,
    EventDirective,
    EventReactiveFormComponent,
    BaseComponent,
    ExistingComponent,
    EventDateDirective,
    SalesComponent,
    OrderComponent,
    OrderFilter,
    HomeComponent,
    RegisterComponent,
    ParticipantsComponent,
    SearchComponent,
    AboutComponent,
    DashboardComponent,
    SidenavComponent,
    HeaderComponent,
    EventParentComponent,
    ParticipantChildComponent,
    EventCodeFilterPipe,
    CandidateTemplateDrivenFormComponent,
    ChooseJobDirective,
    UserApiComponent,
    NewProductRequestComponent,
    ViewProductsComponent,
    ProductDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    // * MATERIAL IMPORTS
    BrowserAnimationsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatDividerModule,
    MatListModule,
    MatButtonModule,
    AppRoutingModule,
    HttpClientModule,
    NgxDropzoneModule

  ],
  providers: [
    ApplicationServService,
    UserApiService,
    ParticipantJsonService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
