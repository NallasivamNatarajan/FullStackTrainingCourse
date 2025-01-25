import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginPageComponent} from './login-page/login-page.component';
import { CartComponent } from './cart/cart.component';
import { OrdersComponent } from './orders/orders.component';
import { ViewProductsComponent } from './register-product/view-products/view-products.component';
import { NewProductRequestComponent } from './register-product/new-product-request/new-product-request.component';
import { PlaceOrderComponent } from './place-order/place-order.component';
import { ProductDetailComponent } from './register-product/product-detail/product-detail.component';
import { MyOrdersSummaryComponent } from './my-orders-summary/my-orders-summary.component';
import { MyordersComponent } from './myorders/myorders.component';
import { ToDoComponent } from './to-do/to-do.component';
import { LoginlayoutComponent } from './loginlayout/loginlayout.component';
import { HomelayoutComponent } from './homelayout/homelayout.component';
import { ToDoListComponent } from './to-do-list/to-do-list.component';
import { AdminListComponent } from './admin-list/admin-list.component';
import { AdminListSummaryComponent } from './admin-list-summary/admin-list-summary.component';

// const routes: Routes = [
//   {path:'log-in',component:LoginPageComponent},
//   {path :'cart',component:CartComponent},
//   {path :'dashboard',component:OrdersComponent},
//   {path :'my-orders',component:MyordersComponent},
//   {path :'place-order', component:PlaceOrderComponent},
//   {path:'login-page',component:LoginPageComponent},
//   {path:'view-products',component:ViewProductsComponent},
//   {path: 'my-orders-summary/:orderId',component:MyOrdersSummaryComponent},
//   {path:'to-do', component:ToDoComponent},
//   {path:'product-detail/:productId',component:ProductDetailComponent},
//   {path:'new-product-request',component:NewProductRequestComponent}
// ];
const routes: Routes = [
  { path: '', redirectTo: 'login', data: { title: 'First Component' }, pathMatch: 'full' },
  {
    path: 'login', component: LoginlayoutComponent, data: {title: 'First Component'},
    children: [
      {path: '', component: LoginPageComponent}
    ]
  },
  { path: 'home', component: HomelayoutComponent,
    children: [
      { path: 'place-order', component: PlaceOrderComponent },
      { path: 'cart', component: CartComponent },
      { path: 'dashboard', component: OrdersComponent },
      { path: 'my-orders', component: MyordersComponent },
      { path: 'place-order', component: PlaceOrderComponent },
      { path: 'view-products', component: ViewProductsComponent },
      { path: 'my-orders-summary/:orderId', component: MyOrdersSummaryComponent },
      // { path: 'to-do-list', component: ToDoComponent },
      { path: 'product-detail/:productId', component: ProductDetailComponent },
      { path: 'new-product-request', component: NewProductRequestComponent },
      { path: 'to-do-item-summary/:orderId', component: ToDoComponent },
      { path: 'to-do', component: ToDoListComponent },
      { path: 'admin-list', component: AdminListComponent },
      { path: 'admin-list-summary/:orderId', component: AdminListSummaryComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
