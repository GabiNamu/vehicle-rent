import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { FormComponent } from './components/form/form.component';
import { ReserveComponent } from './components/reserve/reserve.component';

const routes: Routes = [
  {path: '', component: HomeComponent },
  {path: 'add', component: FormComponent },
  {path: 'reservar/:vehicleId', component: ReserveComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
