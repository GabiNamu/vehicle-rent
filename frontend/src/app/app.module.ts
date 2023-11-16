import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { ShowVehiclesComponent } from './components/show-vehicles/show-vehicles.component';
import { AddVehicleComponent } from './components/add-vehicle/add-vehicle.component';
import { FormComponent } from './components/form/form.component';
import { HomeComponent } from './components/home/home.component';
import { ReserveComponent } from './components/reserve/reserve.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ShowVehiclesComponent,
    AddVehicleComponent,
    FormComponent,
    HomeComponent,
    ReserveComponent,
  ],
  imports: [
    BrowserModule,
    NgbModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule, 
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
