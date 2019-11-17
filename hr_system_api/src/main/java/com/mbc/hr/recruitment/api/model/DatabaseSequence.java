/**
 * 
 */
package com.mbc.hr.recruitment.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author AHimour
 *
 */
@Document(collection = "database_sequences")
public class DatabaseSequence {
 
    @Id
    private String id;
 
    private long seq;

	public long getSeq() {
		
		return seq;
	}
 
  
}
