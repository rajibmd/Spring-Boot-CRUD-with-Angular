import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from '../patient';
import { PatientserService } from '../patientser.service';



@Component({
  selector: 'app-save-patient',
  templateUrl: './save-patient.component.html',
  styleUrls: ['./save-patient.component.css']
})
export class SavePatientComponent implements OnInit {

  patient : Patient = new Patient();
  
  constructor(
    private patientServi : PatientserService,
    private router: Router
    ) { }

  ngOnInit(): void {
  }

savePatient(){
  this.patientServi.savePatient(this.patient).subscribe(data =>{
    console.log(data);
    this.goToPatientList();

  },
  error => console.log(error)
  );

}

goToPatientList(){
  this.router.navigate(['/patients']);
}

  onSubmit(){
    console.log(this.patient);
    this.savePatient();
  }

}
