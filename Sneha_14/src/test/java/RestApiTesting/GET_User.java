package RestApiTesting;
 
import org.testng.annotations.Test;
 
import com.aventstack.extentreports.gherkin.model.Given;
 
import io.restassured.RestAssured;
import io.restassured.response.Response;
 
public class GET_User {
  @Test
//  public void getuser() {
//	  
//	  RestAssured.baseURI="https://api.restful-api.dev";
//	  
//	  RestAssured.given()
//			  .when()
//			  .get("/objects")
//			  .then()
//			  .statusCode(200)
//			  .log().all();
//			
//	  
//  }
  
  
//public void getuser2() {
//	  
//	  RestAssured.baseURI="https://api.restful-api.dev/";
//	  
//	  RestAssured.given()
//			  .when()
//			  .get("/objects?id=3&id=5&id=10")
//			  .then()
//			  .statusCode(200)
//			  .log().all();
//			
//	  
//  }
//  
  
public void getuser3() {
	  
	  RestAssured.baseURI="https://api.restful-api.dev/";
	  
	  RestAssured.given()
			  .when()
			  .get("/objects/7")
			  .then()
			  .statusCode(200)
			  .log().all();
			
	  
  }
  
  
}
 