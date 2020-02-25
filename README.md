TradelX serenity-restassured
This is a Rest Assured framework for API test automation. Took the approach of using serenity wrapper overRest Assured in order to ensure that the specifications are testable.

Installation Guide : Project installtion & reports explanation can be found in Installation Guide.doc

Run Instructions:

Run it as 'clean verify serenity:aggregate' from the project dir

Report Dir :

/target/site/serenity/index.html

Automation Strategy :

This framework needs to be scaled to cater to the entire API testing of the application

Approach :

Currently a java class named PetCRUDTest perfoms the create,read,update & delete operations on the API

An utility class named ReusableSpecifications has got rest assured methods such as request spec builder, response spec builder,building the request/response headers etc

Report does print JSON query which displays the Request Headers,Content Body,Response Headers,Response Body.

Test Coverage :

Basic tests are covered for :

Create a pet
Verify the pet has been created
Update the pet
Delete the Pet
Currently API allows to add the duplicate records however for each request new petId is created and fraemwork uses the newly created petId to retreive the record. So this test can run multiple times without fail.



Note : Target files are not required for check in however for the serenity reports demo they have been checked in
