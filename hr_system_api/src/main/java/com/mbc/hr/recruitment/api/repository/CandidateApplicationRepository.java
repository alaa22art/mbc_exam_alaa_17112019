/**
 * 
 */
package com.mbc.hr.recruitment.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mbc.hr.recruitment.api.model.CandidateApplication;

/**
 * @author AHimour
 *
 */
public interface CandidateApplicationRepository extends MongoRepository<CandidateApplication, Integer> {
	
	

}
