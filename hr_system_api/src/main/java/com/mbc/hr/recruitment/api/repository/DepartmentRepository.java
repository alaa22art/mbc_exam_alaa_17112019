/**
 * 
 */
package com.mbc.hr.recruitment.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mbc.hr.recruitment.api.model.Department;

/**
 * @author AHimour
 *
 */
public interface DepartmentRepository extends MongoRepository<Department, Integer> {

}
