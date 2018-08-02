# vehicleservice

a.	Instruction to run it locally:
-----------------------------------------------------------------------------------
1.	Clone or Download the project from https://github.com/padirigopi/vehicleservice
2.	Import the project as Maven project into eclipse and run the pom.xml with maven (run maven build as  “clean install”)
3.	This will build the WAR under target folder(Refer target folder for WAR)
4.	Deploy the WAR in application server.
5.	Also the application was developed by integrating with H2 database. Hence a local database to be created with name “testing” and have the user name and password as “sa”. If any change in database name, the same need to be update in “servlet-context.xml”
6.	H2 database can be downloaded from the path. Click on h2.bat file under bin folder and create the database with name “testing” and username, password as “sa” http://www.h2database.com/html/download.html
7.	Execute the below create statement after creating the database with name “testing”. Table name can be configured in Vehicle.java class. Here I have used the table with name VEHICLEDETAILS1

CREATE TABLE VEHICLEDETAILS1(ID VARCHAR2(10) NOT NULL PRIMARY KEY, NUMBER VARCHAR2(10), TYPE VARCHAR2(20), NAME VARCHAR2(20));

b.	Endpoints and their description along with / c. Sample request and response:
---------------------------------------------------------------------------------
1.	http://localhost:8080/vehicleservice/rest/vehicles 
The above operation is to retrieve all the Vehicles 
Request: 
http://localhost:8080/vehicleservice/rest/vehicles 

Response: 
[{"vehicleID":"999","vehicleNumber":"9999","vehicleType":"Four Wheel","vehicleName":"Honda City"},{"vehicleID":"111","vehicleNumber":"4899","vehicleType":"Two Wheel","vehicleName":"Fascino"}]

2.	http://localhost:8080/vehicleservice/rest/vehicle/{id}
The above operation is to retrieve the vehicle by vehicle ID
Request:
http://localhost:8080/vehicleservice/rest/vehicle/999

Response:
{"vehicleID":"999","vehicleNumber":"9999","vehicleType":"Four Wheel","vehicleName":"Honda City"}

3.	http://localhost:8080/vehicleservice/rest/vehicle/create
The above operation is to create a new Vehicle

Invoke the above URL with POST option in Rest Client with below Sample Request as Request body

Sample Request:
{
  "vehicleID": "111",
  "vehicleNumber": "4899",
  "vehicleType": "Two Wheel",
  "vehicleName": "Fascino"
}

Sample Response:

Return HTTP status code 201 for created

4.	http://localhost:8080/vehicleservice/rest/vehicle/delete/{id}
The above operation is to delete the vehicle 

Sample Request:

Invoke the below from Rest client with Put option selected
http://localhost:8080/vehicleservice/rest/vehicle/delete/111

Sample Response:

Return HTTP status code 200 and return the deleted object 
