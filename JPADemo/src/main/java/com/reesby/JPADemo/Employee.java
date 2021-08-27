package com.reesby.JPADemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private double id;
	private char name;
	private char email;
	private char address;
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public char getName() {
		return name;
	}
	public void setName(char name) {
		this.name = name;
	}
	public char getEmail() {
		return email;
	}
	public void setEmail(char email) {
		this.email = email;
	}
	public char getAddress() {
		return address;
	}
	public void setAddress(char address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}


}
