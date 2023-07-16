package Files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


public class Dynammicjson {

	
	@Test(dataProvider="Bookdata")
	public void Addbook(String isbn,String aisle) {
		
		RestAssured.baseURI="http://216.10.245.166/";
		String resp=given().header("content-type","application/json")
		.body(Payload.Addbook("isbn","aisle")).when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js=Resusablemethods.rawToJson(resp);
		String id=js.get("ID");
		System.out.println(id);
	}
	
		//Delete Book
		@DataProvider(name="Bookdata")
		public Object[][] getData() {
			//array=collection of element
			//multidimensional array=collection of array
		return new Object[][]{{"yuiyii","7899"},{"gjhjii","8988"},{"tyttut","78799"}};
		
		}
	}

