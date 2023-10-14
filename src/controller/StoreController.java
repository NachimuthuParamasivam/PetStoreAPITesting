package controller;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.PetPojo;
import pojo.StorePojo;

public class StoreController {

	RequestSpecification req;

	public StoreController() {
		req = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io").setContentType(ContentType.JSON)
				.build();

	}

	public Response createStore(StorePojo p) {

		Response response = given().spec(req).body(p).when().post("v2/store/order");
		return response;

	}
	
	public Response findById(int orderId) {

		Response response = given().spec(req).when().get("v2/store/order/" + orderId + "");

		return response;

	}
	
	public Response deleteById(int orderId) {

		Response response = given().spec(req).when().delete("v2/store/order/" + orderId + "");

		return response;

	}
	
	public Response inventory() {

		Response response = given().spec(req).when().get("v2/store/inventory");

		return response;

	}
	
	public Response findByIdLogic() {

		Response response = given().spec(req).when().get("v2/store/inventory");

		return response;

	}
	
}
