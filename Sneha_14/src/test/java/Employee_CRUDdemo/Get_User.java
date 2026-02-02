package Employee_CRUDdemo;
 
import static io.restassured.RestAssured.baseURI;
 
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
 
import io.restassured.RestAssured;
 
public class Get_User {
	String userId;
	
  @Test(priority=1)
  public void getEmp() {
	  RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
	  JSONObject data=new JSONObject();
	  
	  RestAssured.given()
	  .when()
	  .get("/employees")
	  .then()
	  .statusCode(200)
	  .log().all();
  					
  }
}
 
 
 