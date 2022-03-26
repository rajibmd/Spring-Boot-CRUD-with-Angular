package com.exam.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exam.demo.model.Patient;
import com.exam.demo.repository.PatientRepository;

@Service
@Transactional
public class PatientService {
	
	@Autowired
	private PatientRepository pr;
	
	
	//get for single data
	public Patient  getById(long id) {
		
		return pr.findById(id).get();
		
	}
	
	// get all data
	
	public List<Patient> getAllPatient(){
		return pr.findAll();
		
	}
	
	//save for data
	
	public Patient save(Patient patient) {
		return pr.save(patient);
		
	}
	
	//Update patient
	public Patient upadteStudent(Patient patient) {
		Long id = patient.getId();
		Patient pat = pr.findById(id).get();
		pat.setUserCode(patient.getUserCode());
		pat.setName(patient.getName());
		pat.setGender(patient.getGender());
		pat.setAge(patient.getAge());
		pat.setDate(patient.getDate());
		pat.setPhone(patient.getPhone());
		pat.setEmail(patient.getEmail());
		pat.setAddress(patient.getAddress());
		pat.setImagePath(patient.getImagePath());
		return pr.save(pat);
		
	}
	
	// delete
	public void delete(long id) {
		
		pr.deleteById(id);
		
	}
	
	// for image
	
	public boolean saveFileToFolder(String userCode, MultipartFile file) {
		boolean flag = false;
		String name = file.getOriginalFilename();
		if(name.contains(".")) {
			int index = name.lastIndexOf(".");
			name = name.substring(index, name.length());
		}
		String home = System.getProperty("user.home");
		String URL =  home + "/Documents/angularBoot/src/assets/images/" + userCode + name;
		
		try {
			Files.copy(file.getInputStream(), Paths.get(URL), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("image uploaded from this side");
			flag = true;
		}catch(IOException io) {
			flag = false;
		}
		
		return flag;
	}
	

}
