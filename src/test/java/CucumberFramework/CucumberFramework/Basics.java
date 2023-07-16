package CucumberFramework.CucumberFramework;

import static org.testng.AssertJUnit.assertThat;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import java.nio.file.Paths;

import org.testng.reporters.Files;

import Files.Payload;

import static io.restassured.RestAssured.*;


public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub4
		
		//given-all details
		//when-
		//convert to the file to String ->content of the file can convert into byte ->byte data to string  
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key","qaclick123").header("content-type","application/json")
		.body(Payload.Addplace()).when().post("maps/api/place/add/json")
//	.body(new String(Files.readAllbytes(Paths.get("")))).when()
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		//add place--->Update place with new place --->get place to validate if new address is updated or not
		
		JsonPath js=new JsonPath(response);
		String placeid=js.getString("place_id");
		System.out.println(placeid);
		
		String newAddress="Summer Walk, Africa";
		
       given().log().all().queryParam("key","qaclick123").header("content-type","application/json")
       .body("{\r\n" + 
				"\"place_id\":\""+placeid+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").when().put("maps/api/place/update/json").
               then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
	
	//Get Place
   String getStringResposne= given().log().all().queryParam("key","qaclick123")
    .queryParam("place_id", placeid)
    .when().get("maps/api/place/get/json")
    .then().assertThat().log().all().extract().response().asString();
   
   JsonPath js1=new JsonPath(getStringResposne);
    String actualaddress=js.getString(getStringResposne);
    System.out.println(actualaddress);
}
}