# mbc_exam_alaa_17112019
small HR system api

1. you may face a silent exception when you run the solution .....please pass it , No need create a db just mack sure that host and port are correct 
2.After DB auto generated with related objects , you should add department to lkp table :

Post ---> localhost:8080\api\addDepartment
data----> 
------------------
[
	{
	"name" : "IT"
	}
	------------------
	{
	"name" : "HR"
	}
	------------------
	{
	"name" : "Finance"
	}
]
------------------
3.you can add any candidate application using :
Post ------> localhost:8080\api\addCandidateApplication
data ------>
------------------
{
    "name": "khalied saleem alma",
    "dateOfBirth": "2000-10-10",
    "resume": "Hi I need this job",
    "department": {
        "id": "1",
        "name": "sale"
    }
}
--------------------
4. you can get All Candidate Application if you use Admin
Get -----> localhost:8080\api\findAllOrder  
Condition ------> request header param X-ADMIN = 1
Return Data------->
----------------------
[
    {
        "id": 1,
        "name": "khalied saleem alma",
        "dateOfBirth": "2000-10-10T00:00:00.000+0000",
        "yearsOfExpereance": 0,
        "department": {
            "id": 1,
            "name": "sale"
        },
        "resume": "Hi",
        "registrationDate": "2019-11-16T22:57:54.902+0000",
        "file": null
    }
]
----------------------
5. To upload Candidate File to S3 you should use 
Post ---------> localhost:8080\api\uploadFile
if success Response with--------->
--------------------------------
{
    "message": "file [2.docx] uploading request submitted successfully."
}
---------------------------------
6. to download Candidate file you should use 
Get------------> localhost:8080\api\document\1.docx 
if operation success and file is exist you will get outputStream data need data encoding  
-----------------------------------
7. to retrieve swagger documentation you should go to : http://localhost:8080/swagger-ui.html#/ 

---------------------------------------------------------------------------------------------------------
