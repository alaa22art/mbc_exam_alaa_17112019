/**
 * 
 */
package com.mbc.hr.recruitment.api.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.util.IOUtils;
import com.mbc.hr.recruitment.api.model.CandidateApplication;
import com.mbc.hr.recruitment.api.repository.AmazonS3ClientRepository;
import com.mbc.hr.recruitment.api.repository.CandidateApplicationRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author AHimour
 *
 */
@RestController
@RequestMapping("/api")
public class CandidateApplicationController {

	@Autowired
	private CandidateApplicationRepository repository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	AmazonS3ClientRepository amazonS3ClientService;

	@PostMapping("/addCandidateApplication")
	@ApiOperation(value = "applicant can adding a new job application request here")
	public String saveCandidateApplication(@ApiParam(value = "candidate application param include id , name , department , reg date and uploaded files", required = true) @RequestBody CandidateApplication app )
	{
		app.setId(sequenceGeneratorService.getNextSequence(app.SEQUENCE_NAME));
		app.setRegistrationDate();
		
		/*if(app.getFile() != null)
		{
			amazonS3ClientService.uploadFileToS3Bucket(app.getFile(),true);
		
		}*/
		
		
       // amazonS3ClientService.uploadFileToS3Bucket(app.getFile(), true);
		repository.save(app);
		return "added candidate application with id :" + app.getId() ;
		
	}
	
	@GetMapping("/findAllCandidateApplication")
	@ApiOperation(value = "get all candidate application list")
	public List<CandidateApplication> getAllCandidateApplication()
	{
		return repository.findAll();
	}
	
	@GetMapping("/findCandidateApplication/{id}")
	@ApiOperation(value = "get all candidate application by candidate application id")
	public Optional<CandidateApplication> getCandidateApplication(@PathVariable int id)
	{
		return repository.findById(id);
	}
	
	@DeleteMapping("/deleteCandidateApplication")
	@ApiOperation(value = "delete an candidate application by id")
	public String deleteCandidateApplication(@ApiParam(value = "candidate application Id from which candidate application object will delete from database table", required = true)@RequestBody CandidateApplication app )
	{
		repository.deleteById((int) app.getId());
		
		return "delete candidate application with id :" + app.getId() ;
		
	}
 
}
