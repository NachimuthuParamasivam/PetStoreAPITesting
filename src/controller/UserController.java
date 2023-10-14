package controller;

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.UserCreationPojo;

public class UserController {
	RequestSpecification req;

	public UserController() {
		req = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io").setContentType(ContentType.JSON)
				.build();

	}

	public Response createUserwithArray(List<UserCreationPojo> userList) {

		Response response = given().spec(req).body(userList).when().post("v2/user/createWithList");
		return response;

	}

	public Response getUser(String userName) {

		Response response = given().spec(req).when().get("v2/user/" + userName + "");
		return response;

	}

	public Response updateUser(UserCreationPojo up, String userName) {

		Response response = given().spec(req).body(up).when().put("v2/user/" + userName + "");
		return response;

	}

	public Response userLogin(String userNameLogin, String password) {
		Response response = given().spec(req).when()
				.get("v2/user/login?username=" + userNameLogin + "&password=" + password + "");
		return response;
	}

	public Response userLogout() {
		Response response = given().spec(req).when().get("v2/user/logout");
		return response;
	}

	public Response deleteUser(String userName) {
		Response response = given().spec(req).when().delete("v2/user/" + userName + "");
		return response;
	}
}
