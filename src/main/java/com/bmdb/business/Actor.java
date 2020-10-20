package com.bmdb.business;

import java.time.LocalDate; 

import javax.persistence.*;

@Entity
public class Actor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String gender;
	private LocalDate birthDate;
	
	public Actor() {
		super();
		
	}
	
	public Actor(int id, String firstName, String lastName, String gender, LocalDate birthDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
	}

	public Actor(String firstName, String lastName, String gender, LocalDate birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public LocalDate getbirthDate() {
		return birthDate;
	}

	public void setbirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String displayActorSummary() {
		String str = "*****Actor Summary*****\n";
		str += "-----------------------\n";
		str += id + "," + " " + firstName + " "  + lastName+"," + " " 
				+ (gender.equalsIgnoreCase("M") ? "Male" : "Female") 
						+"," + " " + "born" + " " + birthDate;
				
		return str;
	}
	
	
	

}

	

