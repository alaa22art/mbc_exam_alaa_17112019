/**
 * 
 */
package com.mbc.hr.recruitment.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbc.hr.recruitment.api.model.Department;
import com.mbc.hr.recruitment.api.repository.DepartmentRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author AHimour
 *
 */
@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	private DepartmentRepository repository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@PostMapping("/addDepartment")
	@ApiOperation(value = "adding new department")
	public String saveDepartment(@ApiParam(value = "save department object on referance table", required = true) @RequestBody Department dep )
	{
		dep.setId(sequenceGeneratorService.getNextSequence(dep.SEQUENCE_NAME));
		repository.save(dep);
		return "added candidate application with id :" + dep.getId() ;
		
	}
	
	@GetMapping("/findAllDepartment")
	@ApiOperation(value = "get all department list")
	public List<Department> getAllDepartment()
	{
		return repository.findAll();
	}
	
	@GetMapping("/findAllDepartment/{id}")
	@ApiOperation(value = "get all department object by id")
	public Optional<Department> getDepartment(@ApiParam(value = "get all department list based on id referance", required = true)@PathVariable int id)
	{
		return repository.findById(id);
	}
	
	@DeleteMapping("/deleteDepartment/{id}")
	@ApiOperation(value = "delete department object by id")
	public String deleteDepartment(@ApiParam(value = "department Id from which department object will delete from database table", required = true) @PathVariable int id)
	{		
		repository.deleteById(id);
		return "delete Department  with id :" + id ;
	}
 
}
