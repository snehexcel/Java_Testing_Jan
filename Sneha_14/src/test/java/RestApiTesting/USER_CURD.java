package RestApiTesting;
 
import org.json.simple.JSONObject;

import org.testng.annotations.Test;
 
import io.restassured.http.ContentType;
 
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
 
 
public class USER_CURD {

	String userid;

	@Test(priority=1)

	  public void postuser1() {

		  baseURI = "https://api.restful-api.dev";

		  JSONObject data=new JSONObject();

		  data.put("year", 2019);

		  data.put("price", 2000.00 );

		  data.put("CPU model", "Intel Core i9");

		  data.put("Hard disk size","1 TB");

		  JSONObject reqbody=new JSONObject();

		  reqbody.put("name", "Apple MacBook Pro 16");

		  reqbody.put("data",data);

		  Response response=given()

		  .contentType(ContentType.JSON)

		  .body(reqbody.toString())

		  .when()

		  .post("/objects");

		   userid=response.jsonPath().getString("id");

		  response.then()

		  .statusCode(200)

		  .log().all();

		  System.out.println("Posted id:"+userid);

	  }


  @Test(priority=2)

  public void putuser() {

	  baseURI = "https://api.restful-api.dev";

	  JSONObject data=new JSONObject();

	  data.put("year", 2026);

	  data.put("price", 60000000.00 );

	  data.put("CPU model", "DELL");

	  data.put("Hard disk size","100 TB");

	  data.put("color","Blue");

	  JSONObject reqbody=new JSONObject();

	  reqbody.put("name", "Apple MacBook Pro 16");

	  reqbody.put("data",data);

	  given()

	  .contentType(ContentType.JSON)

	  .body(reqbody.toString())

	  .when()

	  .put("/objects/"+userid)

	  .then()

	  .statusCode(200)

	  .log().all();

  }


  @Test(priority=3)

  public void patchuser() {

	  baseURI = "https://api.restful-api.dev";

	  JSONObject reqbody=new JSONObject();

	  reqbody.put("name", "DELL PRO 16");

	   given()

	  .contentType(ContentType.JSON)

	  .body(reqbody.toString())

	  .when()

	  .patch("/objects/"+userid)

	  .then()

	  .statusCode(200)

	  .log().all();

  }

  @Test(priority=4)

  public void deleteuser() {

	  baseURI = "https://api.restful-api.dev";


	   given()

	   .when()

	  .delete("/objects/"+userid)

	  .then()

	  .statusCode(200)

	  .log().all();

  }

}

 