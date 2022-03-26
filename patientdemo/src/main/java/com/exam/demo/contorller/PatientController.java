package com.exam.demo.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exam.demo.model.Patient;
import com.exam.demo.service.PatientService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200/")
public class PatientController {
	
	@Autowired
	private PatientService ps;

	//get all data
	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getAllPatient(){
		List<Patient> patients = ps.getAllPatient(); 
		return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
		
	}
	
	//get single date
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getSinglePatient(@PathVariable("id") long id) {
		 Patient patient = ps.getById(id);
		
		return new ResponseEntity<Patient>(patient, HttpStatus.OK)  ;
	}
	
	//save all data
	@PostMapping("/patients")
	public ResponseEntity<Patient> savePatientEntity(@RequestBody Patient patient){
		Patient p = ps.save(patient);
		
		return new ResponseEntity<Patient>(p, HttpStatus.CREATED);
		
	}
	
	//update date
	
	@PutMapping("/patients")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){
		Patient pp = ps.save(patient);
		return new ResponseEntity<Patient>(pp, HttpStatus.OK);
		
	}
	
	//delete data 
	
	@DeleteMapping("/patients/{id}")
	public ResponseEntity<Patient> deletePatient(@PathVariable("id") long id){
		ps.delete(id);
		return new ResponseEntity<> (HttpStatus.OK);
		
	}
	
	
	//  Static path for image
	
	@PostMapping("/upload-image/{userCode}")
    public ResponseEntity<String> uploadFile(@PathVariable("userCode") String userCode, @RequestParam("file") MultipartFile file){
		System.out.println("method hit");
    	if(!file.isEmpty()) {
    		if(!ps.saveFileToFolder(userCode, file)) {
    			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file not uploaded, something went wrong!!");
    		}
    	}else {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file is EMPTY, try again!!");
    	}
    	return ResponseEntity.ok("file uploaded");
    }
	
	
	
	
}
