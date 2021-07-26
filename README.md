## Description:
API Test Automation Suite for validating that Covid Challenge API's can be used to successfully get users information as well as create and update users

## Key Features:
1. Schema validation for each API is compared with the schema provided in the Swagger documentation
1. Simple Cucumber Report can be accessed under test-output/cucumber-reports/cucumber-pretty/index.html
1. Detailed Cucumber Report can be accessed under test-output/cucumber-reports/advanced-reports/overview-features.html
   Reports from last run have been retained under the above mentioned directories for reference.

 
## Observations:
1. The Invalid Request For GetUsers API cannot be triggered , since being a get request with no headers in this case the only invalid parameter in this case would to be to modify the url , which would result in a 404 status code instead of a 400 status code.
1. The Invalid Request For Create User API actual response schema does not match with what has been documented in Swagger.
1. On testing The Invalid Request For Update User API, it has been found that passing a null value in the score paramter causes the entire set of API's to crash and be out of service.
1. Due to the above mentioned 3 reasons for error message validation , all scenarios related to error messages have been tagged as skipped, however if needed they can still be run by removing the skip tag on top of the Scenario under CovidChallengeAPITest.feature 

 
## Instruction:
 To trigger the test first please clone the repository to any machine that has Java installed on it and thereafter navigate to the project directory.
 Please type in the below command and hit Enter to launch the tests:
 
 mvn clean install
 
