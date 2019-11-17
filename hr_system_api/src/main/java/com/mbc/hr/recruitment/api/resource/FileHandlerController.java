/**
 * 
 */
package com.mbc.hr.recruitment.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.mbc.hr.recruitment.api.repository.AmazonS3ClientRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
/**
 * @author AHimour
 *
 */
@RestController
@RequestMapping("/api")
public class FileHandlerController {

    @Autowired
    private AmazonS3ClientRepository amazonS3ClientRepository;

    @PostMapping("/uploadFile")
    @ApiOperation(value = "upload files to server")
    public Map<String, String> uploadFile(@RequestPart(value = "file") MultipartFile file)
    {
    	
        this.amazonS3ClientRepository.uploadFileToS3Bucket(file, true);

        Map<String, String> response = new HashMap<>();
        response.put("message", "file [" + file.getOriginalFilename() + "] uploading request submitted successfully.");

        return response;
    }

    @DeleteMapping("/deleteFile/{file_name}")
    @ApiOperation(value = "delete file from server server based on file name")
    public Map<String, String> deleteFile(@ApiParam(value = "file name referance uploaded based on candidate aplication id", required = true) @PathVariable("file_name") String fileName)
    {
        this.amazonS3ClientRepository.deleteFileFromS3Bucket(fileName);

        Map<String, String> response = new HashMap<>();
        response.put("message", "file [" + fileName + "] removing request submitted successfully.");

        return response;
    }
    
  
    @GetMapping("/document/{candidate_id}")
    @ApiOperation(value = "get file from server server based on file name (candidate application id) ")
    public ServletOutputStream getDocument(
    		@ApiParam(value = "file name referance uploaded based on candidate aplication id", required = true) @PathVariable("candidate_id")  String candidate_id , 
    		@ApiParam(value = "user type parameter admin user will get all candidate application data", required = true) @RequestHeader("X-ADMIN") String userID,
    		HttpServletResponse response) throws IOException {

    	if(userID.equals("1")) 
    	{
    		S3Object s3Object = amazonS3ClientRepository.downloadFileFromS3Bucket(candidate_id);
    	 
	    	 if(s3Object == null)
	    	 {
	    		 return null;
	    	 }
	    	 
	         InputStream stream = s3Object.getObjectContent();
	         response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
	         IOUtils.copy(stream, response.getOutputStream());
	         
	         return response.getOutputStream() ;
	    	
    	}else
    	{
    		//not authorized
    		 return null;
    		
    	}
         
         
    }
    
}