package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.net.http.HttpResponse.BodyHandler;
import java.util.HashMap;

import javax.annotation.meta.When;

public class TC_StudentsAPI {

	//@Test
	public void test_getAllStudents() {

		given()

		.when()
		.get("http://localhost:8080/getStudentsByCourseId")

		.then()
		.statusCode(200);
	}

	//@Test
	public void test_addNewStudent() {

		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("courseId", "001");
		hm.put("studentId", "14");
		hm.put("firstName", "roshi");
		hm.put("lastName", "sai");
		hm.put("gender", "Female");


		Response res=
				given()
				.contentType("application/json")
				.body(hm)

				.when()
				.post("http://localhost:8080/addStudent")

				.then()
				.statusCode(200)
				.log().body()
				.extract().response();


		String jsontoString=res.asString();
		Assert.assertEquals(jsontoString.contains("CREATED"), true);



	}

	@Test
	public void test_putStudent() {

		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("courseId", "001");
		hm.put("studentId", "7");
		hm.put("firstName", "roshi");
		hm.put("lastName", "sai");
		hm.put("gender", "Female");

		given()
		.contentType("application/json")
		.body(hm)

		.when()
		.put("http://localhost:8080/addStudent")

		.then()
		  .statusCode(200)
		  .log().body();
          

	



	}
}
