import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Patient } from '../patient';
import { PatientserService } from '../patientser.service';

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrls: ['./update-patient.component.css']
})
export class UpdatePatientComponent implements OnInit {
 
 id!: number;
  patient: Patient = new Patient();
  

  constructor(private patietntservi: PatientserService,
    private route :ActivatedRoute,
    private router : Router
    ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.patietntservi.getPatientById(this.id).subscribe(data => {
      this.patient =data;
      
    },
    error => console.log(error));
   


  }

  onSubmit(){
   this.patietntservi.updatePatient(this.patient).subscribe(data =>{
    this.goToPatientList();
   })


  }

  goToPatientList(){
    alert("Patient is updated !!!!!!!!!!!!!!!!!!!");
    this.router.navigate(['/patients']);
  }


}
