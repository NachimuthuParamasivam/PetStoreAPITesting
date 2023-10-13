package controller;

import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.PetPojo;

public class PetsController {
	RequestSpecification req;

	public PetsController() {
		req = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io").setContentType(ContentType.JSON)
				.build();

	}

	public Response createPet(PetPojo p) {

		Response response = given().spec(req).body(p).when().post("v2/pet");
		return response;

	}

	public Response updatePet(PetPojo p) {

		Response response = given().spec(req).body(p).when().post("v2/pet");
		return response;

	}

	public Response findByStatus(String status) {

		Response response = given().spec(req).when().get("v2/pet/findByStatus?status=" + status + "");

		return response;

	}

	public Response findById(int dogId) {

		Response response = given().spec(req).when().get("v2/pet/" + dogId + "");

		return response;

	}

	public Response deleteById(int dogId) {

		Response response = given().spec(req).when().delete("v2/pet/" + dogId + "");

		return response;

	}

	public Response updateForm(int dogId) {

		RequestSpecification req1 = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io")
				.addHeader("Content-Type", "application/x-www-form-urlencoded").build();
		Response response = given().spec(req1).param("name", "updatedformdog").param("status", "sold").when()
				.post("v2/pet/" + dogId + "");

		return response;

	}

	public Response uploadImage(int dogId) {
        String userDir=System.getProperty("user.dir");
		RequestSpecification req1 = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io")
				.addHeader("Content-Type", "multipart/form-data").build();
		Response response = given().spec(req1).param("additionalMetadata", "AddedImage")
				.multiPart("file", new File(userDir+"//CAR.png")).when()
				.post("v2/pet/" + dogId + "/uploadImage");
		// File("/Users//nachi//documents//CAR.png")
		
		return response;

	}

}
