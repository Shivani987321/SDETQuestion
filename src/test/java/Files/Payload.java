package Files;

public class Payload {

	public static String Addplace() {
		
		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Rahul Shetty Academy\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://rahulshettyacademy.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"";
		

	}
	public static String Addbook(String isbn, String aisle) {
		String payload="{\r\n"
		+ "\r\n"
		+ "\"name\":\" Appium Automation with Java\",\r\n"
		+ "\"isbn\":\"+isbn+\",\r\n"
		+ "\"aisle\":\"+aisle+\",\r\n"
		+ "\"author\":\"John mark\"\r\n"
		+ "}\r\n"
		+ " \r\n"
		+ "";
		
		return payload;
		
	}

}
