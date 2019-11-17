/**
 * 
 */
package com.mbc.hr.recruitment.api.repository;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.S3Object;

/**
 * @author AHimour
 *
 */
public interface AmazonS3ClientRepository
{
    void uploadFileToS3Bucket(MultipartFile multipartFile, boolean enablePublicReadAccess);
    void deleteFileFromS3Bucket(String fileName);
    S3Object downloadFileFromS3Bucket(String CandidateApplicationID);
}