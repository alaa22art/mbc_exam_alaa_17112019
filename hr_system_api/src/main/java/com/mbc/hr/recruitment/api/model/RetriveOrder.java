/**
 * 
 */
package com.mbc.hr.recruitment.api.model;

import java.util.List;

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
@Document(collection = "order_request")
public class RetriveOrder {
	
	 
	@Transient
	public static final String SEQUENCE_NAME = "order_sequence";

	@Id
	private long id;
	private String userName;
	private List<CandidateApplication> candidateApplicationList;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<CandidateApplication> getCandidateApplicationList() {
		return candidateApplicationList;
	}
	public void setCandidateApplicationList(List<CandidateApplication> candidateApplicationList) {
		this.candidateApplicationList = candidateApplicationList;
	}
	
	
}
