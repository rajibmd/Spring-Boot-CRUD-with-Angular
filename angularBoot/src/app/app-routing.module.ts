import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { SavePatientComponent } from './save-patient/save-patient.component';
import { UpdatePatientComponent } from './update-patient/update-patient.component';

const routes: Routes = [
  
  {path: 'patients', component:PatientListComponent},
  {path: 'save', component:SavePatientComponent},
  {path: '', redirectTo:'patients', pathMatch:'full'},
  {path: 'update-patient/:id', component:UpdatePatientComponent},
  { path: 'patient-details/:id', component: PatientDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
