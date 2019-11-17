/**
 * 
 */
package com.mbc.hr.recruitment.api.resource;

import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mbc.hr.recruitment.api.model.DatabaseSequence;

/**
 * @author AHimour
 *
 */
@Service
public class SequenceGeneratorService {
	
	@Autowired 
	private MongoOperations mongoOperations;

	public long getNextSequence(String seqName) {
	    DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
	      new Update().inc("seq",1), options().returnNew(true).upsert(true),
	      DatabaseSequence.class);
	    return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}
}
