package com.vehiclemanagement.test;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VehicleServiceTest {
	@BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void testRetrieveAllVehicles() {
    	RestAssured.baseURI ="http://localhost:8080/vehicleservice/rest";
    	RequestSpecification request = RestAssured.given();
    	request.header("Content-Type", "application/json");
    	Response response = request.get("/vehicles");
    	int statuscode = response.getStatusCode();
    	Assert.assertEquals(statuscode, 200);

    }
    
    @Test
    public void testRetrieveByVehicleID() {
    	RestAssured.baseURI ="http://localhost:8080/vehicleservice/rest";
    	RequestSpecification request = RestAssured.given();
    	request.header("Content-Type", "application/json");
    	Response response = request.get("/vehicle/222");
    	int statuscode = response.getStatusCode();
    	Assert.assertEquals(statuscode, 200);

    }

    @Test
    public void testcreateVehicle() {
    	RestAssured.baseURI ="http://localhost:8080/vehicleservice/rest";
    	RequestSpecification request = RestAssured.given();
    	
    	JSONObject requestParams = new JSONObject();
    	requestParams.put("vehicleID", "444"); // Cast
    	requestParams.put("vehicleNumber", "AP11 5689");
    	requestParams.put("vehicleType", "Air Line");
    	requestParams.put("vehicleName", "JetAirways");
    	
    	request.body(requestParams.toJSONString());
    	request.header("Content-Type", "application/json");
    	Response response = request.post("/vehicle/create");
    	
    	int statuscode = response.getStatusCode();
    	Assert.assertEquals(statuscode, 201);

    }
    
    @Test
    public void testdeleteVehiclebyID() {
    	RestAssured.baseURI ="http://localhost:8080/vehicleservice/rest";
    	RequestSpecification request = RestAssured.given();
    	request.header("Content-Type", "application/json");
    	Response response = request.put("/vehicle/delete/444");
    	int statuscode = response.getStatusCode();
    	Assert.assertEquals(statuscode, 200);
    }
}
