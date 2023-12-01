package com.restassured.testing;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;




public class restassurednew {
	
//	@Test
	void singlerepository() {
	String bearertoken="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";
	given()
	.headers("Authorization","Bearer "+bearertoken)
	
	.when().get("https://api.github.com/repos/shobanasubramani/restassured")
	.then()
	.statusCode(200)
	.contentType("application/json;charset=utf-8")
	.body("name",equalTo("restassured"))
	.body("default_branch",equalTo("main"))
	.log().all();
	}






//	@Test
	void nonsinglerepository() {
	String bearertoken="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";
	given()
	.headers("Authorization","Bearer "+bearertoken)
	
	.when().get("https://api.github.com/repos/shobanasubramani/restassured1")
	.then()
	.statusCode(200)
	.contentType("application/json;charset=utf-8")
	.body("name",equalTo("restassured1"))
	.body("default_branch",equalTo("main"))
	.log().all();
	}

	
	@Test
	
	void createsecrepository() {
		HashMap data=new HashMap();
		
		data.put("name","Hello-Worlds");
		data.put("description","This is your secrepo!");
		data.put("homepage","https://github.com\\");
	 data.put("private","false");
	String bearertoken="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";
	
			given()
	.headers("Authorization","Bearer "+bearertoken)
	.contentType("application/json;charset=utf-8")
	.body(data)
	
	.when()
	.post("https://api.github.com/user/repos")
	
	.then()
	.body("name",equalTo("Hello-Worlds"))
	.body("owner.login",equalTo("shobanasubramani"))
	.body("owner.type",equalTo("User"))
	.statusCode(201)
	.log().all();

	}
	
	//@Test
	
	void createsamerepository() {
		HashMap data=new HashMap();
		
		data.put("name","Hello-World");
		data.put("description","This is your firstrepo!");
		data.put("homepage","https://github.com\\");
	 data.put("private","false");
	String bearertoken="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";
	Response res=RestAssured
			.given()
	.headers("Authorization","Bearer "+bearertoken)
	.contentType("application/json;charset=utf-8")
	.body(data)
	
	.when()
	.post("https://api.github.com/user/repos");
	
	res.then()
	.statusCode(201)
	.log().all();
	
	
	}
	
	//@Test
	void patchrepository() {
		String bearertoken="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";
         HashMap data=new HashMap();
		
		data.put("name","New-World");
		data.put("description","my repository created using apis after update");
		data.put("private","false");
		
		given()
		.headers("Authorization","Bearer "+bearertoken)
		.contentType("application/json;charset=utf-8")
        .body(data)
		
		.when().patch("https://api.github.com/repos/shobanasubramani/restassured")
		.then()
		.statusCode(200)
		.contentType("application/json;charset=utf-8")
		.log().all();
		
	}
	
	@Test
	void delrepository() {
	String bearertoken="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";

	given()
	.headers("Authorization","Bearer "+bearertoken)
	.contentType("application/json;charset=utf-8")
	
	.when().delete("https://api.github.com/repos/shobanasubramani/Hello-World")
	.then()
	.statusCode(204)
	.log().all();
	}
	
	
	
	
	
	
	
	@Test
	void dummyrepository() {
	String bearertoken="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";

	given()
	.headers("Authorization","Bearer "+bearertoken)
	
	
	.when().delete("https://api.github.com/repos/shobanasubramani/Hello-World")
	.then()
	.statusCode(204)
	.log().all();
	}
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	









	
	
	
	
	
	
	
	

