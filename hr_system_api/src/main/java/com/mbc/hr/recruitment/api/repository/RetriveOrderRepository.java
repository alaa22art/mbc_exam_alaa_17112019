/**
 * 
 */
package com.mbc.hr.recruitment.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mbc.hr.recruitment.api.model.RetriveOrder;


/**
 * @author AHimour
 *
 */
public interface RetriveOrderRepository extends MongoRepository<RetriveOrder, Integer> {

}
