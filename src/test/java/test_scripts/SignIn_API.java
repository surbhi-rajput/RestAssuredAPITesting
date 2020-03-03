package test_scripts;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SignIn_API {

	@SuppressWarnings("unchecked")
	@Test
	public void SignIn() {

		//Specify base URI
		RestAssured.baseURI = "http://stlukesuat.azurewebsites.net";

		//Request Object
		RequestSpecification httpRequest = RestAssured.given();

		//Payload Sending
		JSONObject requestParams = new JSONObject();

		requestParams.put("password", "Password1");
		requestParams.put("email", "ladybug@grr.la");

		//Adding headers and parameters
		httpRequest.header("Content-Type","application/json");
		httpRequest.header("ApiAccessKey","o1mgpGUMtweufnz2pirg2Yc6NR6hxYwJZtI9ucsqRGhQY7BOrDayKta4It9fGdZU");
		httpRequest.body(requestParams.toJSONString());

		//Response
		Response response=httpRequest.request(Method.POST, "/api/v3/user/signin");
		
		System.out.println(response.getStatusCode());
		
		System.out.println(response.jsonPath().get("access_Token"));

		System.out.println(response.getBody().asString());
	}

}
