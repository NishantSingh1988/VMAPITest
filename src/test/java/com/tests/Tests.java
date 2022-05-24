package com.tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.entities.Profile;
import com.entities.User;
import com.utils.PropertyReader;
import com.utils.Utils;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tests {
	PropertyReader pr = PropertyReader.getInstance();
	Map<String, String> userData = new HashMap<String, String>();
	
	@BeforeSuite
	public void setup() {
		RestAssured.baseURI = pr.getURL();
	}
	
	@Test
	public void Login() {
		User loginUser = new User(pr.getProperty("useremail"), pr.getProperty("userpassword"));
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		request.header(new Header("tenant", pr.getProperty("tenant")));
		Response loginRes = request.body(loginUser).post(pr.getProperty("login"));
		assertEquals(loginRes.statusCode(), 201);
		System.out.println(loginRes.body().jsonPath().getString("payload.token.value"));
	}
	
	
	@Test
	public void Register() {
		//Setting up body
		String email = pr.getProperty("useremail");
		email = email.substring(0, email.indexOf("@"))+Utils.getUUID()+email.substring(email.indexOf("@"));
		User registerUser = new User(email, pr.getProperty("userpassword"));
		Profile profile = new Profile("test");
		registerUser.setProfile(profile);
		registerUser.setLocale(pr.getProperty("locale"));
		registerUser.setStoreUUID(pr.getProperty("storeId"));
		
		//Sending the request
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		request.header(new Header("tenant", pr.getProperty("tenant")));
		Response loginRes = request.body(registerUser).post(pr.getProperty("register"));
		assertEquals(loginRes.statusCode(), 201);
		System.out.println(loginRes.body().jsonPath().getString("payload.token.value"));
		
	}
	

}
