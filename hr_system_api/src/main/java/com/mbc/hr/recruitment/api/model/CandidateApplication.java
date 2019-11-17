/**
 * 
 */
package com.mbc.hr.recruitment.api.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author AHimour
 *
 */
@Getter
@Setter
@ToString
@Document(collection = "candidate_application")
public class CandidateApplication {
	
	@Transient
	public static final String SEQUENCE_NAME = "candidate_application_sequence";
	
	@Id
	private long id;
	private String name;
	private Date dateOfBirth;
	private int yearsOfExpereance;
	private Department department;
	private String resume;
	private Date registrationDate;
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}
	
	public Date setRegistrationDate() {
		registrationDate =new Date(System.currentTimeMillis());
		return registrationDate;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getYearsOfExpereance() {
		return yearsOfExpereance;
	}
	public void setYearsOfExpereance(int yearsOfExpereance) {
		this.yearsOfExpereance = yearsOfExpereance;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	
	
	
	
	
	

}
