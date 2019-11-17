/**
 * 
 */
package com.mbc.hr.recruitment.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author AHimour
 *

 */
@Data
@AllArgsConstructor
@Document(collection = "department")
public class Department {
	
	@Transient
	public static final String SEQUENCE_NAME = "department_sequence";
	
	@Id
	private long id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String name;
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
