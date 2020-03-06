package test_scripts;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import spreadsheet.ReadSpreadSheet;

public class SignIn_API {

	ReadSpreadSheet readSpreadSheet;
	List<List<Object>> TestData;

	public SignIn_API() {
		readSpreadSheet=new ReadSpreadSheet();
		try {
			TestData=readSpreadSheet.readSpreadSheet("TestData");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void SignIn() {

		//Specify base URI
		RestAssured.baseURI = "http://stlukesuat.azurewebsites.net";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();

		//Adding headers
		  httpRequest.header("Content-Type","application/json");
		  httpRequest.header("ApiAccessKey",
		  "o1mgpGUMtweufnz2pirg2Yc6NR6hxYwJZtI9ucsqRGhQY7BOrDayKta4It9fGdZU");
		 
		  //Passing request body
		httpRequest.body(TestData.get(1).get(5).toString());
		
		//Response
		Response response=httpRequest.request(Method.POST, "/api/v3/user/signin");

		System.out.println(response.getStatusCode());

		//System.out.println(response.jsonPath().get("access_Token"));

		System.out.println(response.getBody().asString());
	}

}
