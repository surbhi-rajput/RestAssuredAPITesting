package test_scripts;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ForgotPassword_API {

	@SuppressWarnings("unchecked")
	@Test
	public void ForgotPassword() {

		//Specify base URI
		RestAssured.baseURI = "http://stlukesuat.azurewebsites.net";

		//Request Object
		RequestSpecification httpRequest = RestAssured.given();

		//Payload Sending
		JSONObject requestParams = new JSONObject();

		requestParams.put("EmailId", "ladybug@grr.la");
		System.out.append(requestParams.toJSONString());

		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());

		Response response=httpRequest.request(Method.POST, "/api/v1/user/forgot/verify");

		System.out.println(response.getBody().asString());
	}

}
