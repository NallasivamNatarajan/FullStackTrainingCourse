import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginPageComponent } from './login-page/login-page.component';
import { MatToolbarModule } from  '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatButtonModule} from '@angular/material/button';
import { HttpClientModule } from '@angular/common/http';
import { CartComponent } from './cart/cart.component';
import { OrdersComponent } from './orders/orders.component';
import { MatSelectModule} from '@angular/material/select';
import {MatExpansionModule} from '@angular/material/expansion';
import { MatTableModule } from '@angular/material/table';
import {MatTabsModule} from '@angular/material/tabs';
import {AccordionModule} from 'primeng/accordion';
import { NewProductRequestComponent } from './register-product/new-product-request/new-product-request.component';
import { ViewProductsComponent } from './register-product/view-products/view-products.component';
import { ProductDetailComponent } from './register-product/product-detail/product-detail.component';
import { ProductRequestService } from './service/product-request.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PlaceOrderComponent } from './place-order/place-order.component';
import { MarkAsteriskDirective } from './mark-asterisk.directive';
import { MyOrdersSummaryComponent } from './my-orders-summary/my-orders-summary.component';
import { MyordersComponent } from './myorders/myorders.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { PlaceOrderPipe } from './place-order.pipe';
import { ToDoComponent } from './to-do/to-do.component';
import { LoginlayoutComponent } from './loginlayout/loginlayout.component';
import { HomelayoutComponent } from './homelayout/homelayout.component';
import { NavigationbarComponent } from './navigationbar/navigationbar.component';
import { ToDoListComponent } from './to-do-list/to-do-list.component';
import { AdminListComponent } from './admin-list/admin-list.component';
import { AdminListSummaryComponent } from './admin-list-summary/admin-list-summary.component';
import { NgxPaginationModule } from 'ngx-pagination'; 


@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    CartComponent,
    OrdersComponent,
    NewProductRequestComponent,
    ViewProductsComponent,
    ProductDetailComponent,
    PlaceOrderComponent,
    MarkAsteriskDirective,
    MyOrdersSummaryComponent,
    MyordersComponent,
    PlaceOrderPipe,
    ToDoComponent,
    LoginlayoutComponent,
    HomelayoutComponent,
    NavigationbarComponent,
    ToDoListComponent,
    AdminListComponent,
    AdminListSummaryComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    MatToolbarModule,
    MatTabsModule,
    MatTableModule,
    MatPaginatorModule, 
    MatSidenavModule,
    MatListModule,
    MatButtonModule,
    MatIconModule,
    MatSelectModule,
    MatExpansionModule,
    AccordionModule,
    NgxPaginationModule
  ],
  providers: [
    ProductRequestService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
