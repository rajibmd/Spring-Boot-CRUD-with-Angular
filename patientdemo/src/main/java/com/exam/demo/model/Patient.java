package com.exam.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String userCode;
	private String name;
	private String gender;
	private String age;
	private String date;
	private String phone;
	private String email;
	private String address;
	private String imagePath;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(long id, String userCode, String name, String gender, String age, String date, String phone,
			String email, String address, String imagePath) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.date = date;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.imagePath = imagePath;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", userCode=" + userCode + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", date=" + date + ", phone=" + phone + ", email=" + email + ", address=" + address + ", imagePath="
				+ imagePath + "]";
	}

	
	
	
}
