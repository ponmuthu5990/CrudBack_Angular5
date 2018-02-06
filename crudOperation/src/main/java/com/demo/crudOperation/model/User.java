package com.demo.crudOperation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity // to map the data base table
@Table(name = "user") // if the table name and domain class name is
							// different
@Component // context.scan("com.niit") --will scan the pacakge and create
			// singleton instances
public class User {

	@Id
	@GeneratedValue
	private Long id;
	
	private String fname;
	private String lname;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
}
