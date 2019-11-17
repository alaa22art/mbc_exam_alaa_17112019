package com.mbc.hr.recruitment.api.resource;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbc.hr.recruitment.api.model.CandidateApplication;
import com.mbc.hr.recruitment.api.model.Department;
import com.mbc.hr.recruitment.api.model.RetriveOrder;
import com.mbc.hr.recruitment.api.repository.CandidateApplicationRepository;
import com.mbc.hr.recruitment.api.repository.DepartmentRepository;
import com.mbc.hr.recruitment.api.repository.RetriveOrderRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author AHimour
 *
 */
@RestController
@RequestMapping("/api")
public class RetriveOrderController {

	@Autowired
	private RetriveOrderRepository repository;
	
	@Autowired
	private CandidateApplicationRepository candidateApplicationRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@GetMapping("/findAllOrder")
	@ApiOperation(value = "get all orders list from table and add a referacec to db what user retrive")
	public List<CandidateApplication> getOrderList(@ApiParam(value = "user type parameter admin user will get all candidate application data", required = true) @RequestHeader("X-ADMIN") String userID)
	{
		if(userID.toString().equals("1") )
		{
			
			RetriveOrder order = new RetriveOrder();
			List<CandidateApplication> candidateApplicationList =  candidateApplicationRepository.findAll();
			
			candidateApplicationList.sort(Comparator.comparing(CandidateApplication::getRegistrationDate).reversed());
			
			setOrderDetails(order, candidateApplicationList);
			
			repository.save(order);
			
			return candidateApplicationList;
			
			
		}
		
		return null;
		
	}

	private void setOrderDetails(RetriveOrder order, List<CandidateApplication> candidateApplicationList) {
		order.setCandidateApplicationList(candidateApplicationList);
		order.setUserName("Admin");
		
		order.setId(sequenceGeneratorService.getNextSequence(order.SEQUENCE_NAME));
	}
	
	
	
	
}
