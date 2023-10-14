package test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import controller.UserController;
import io.restassured.response.Response;
import main.UserDataCreation;
import pojo.UploadUpdateForm;
import pojo.UserCreationPojo;

public class UserApiTests {

	public static List<UserCreationPojo> userList;

	public String userName;
	public String userName1;
	public String password = "abc123";

	@Test(priority = 11)
	public void createUserwithArray() {

		UserDataCreation dc = new UserDataCreation();
		UserController uc = new UserController();
		userList = dc.createUser(2);
		Response response = uc.createUserwithArray(userList);
		int statuscode = response.statusCode();
		userName = UserDataCreation.finalName.get(0);
		userName1 = UserDataCreation.finalName.get(1);
		UploadUpdateForm bodyResponse = response.then().extract().response().as(UploadUpdateForm.class);
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(200, bodyResponse.getCode());

	}

	@Test(dependsOnMethods = "createUserwithArray", priority = 12)
	public void userLogin() {

		UserController uc = new UserController();
		Response response = uc.userLogin(userName1, password);
		int statuscode = response.statusCode();
		UploadUpdateForm bodyResponse = response.then().extract().response().as(UploadUpdateForm.class);
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(200, bodyResponse.getCode());

	}

	@Test(dependsOnMethods = "createUserwithArray", priority = 13)
	public void getUserData() {

		UserController uc = new UserController();
		Response response = uc.getUser(userName);
		int statuscode = response.statusCode();
		UserCreationPojo bodyResponse = response.then().extract().response().as(UserCreationPojo.class);
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(userName, bodyResponse.getUsername());

	}

	@Test(dependsOnMethods = "createUserwithArray", priority = 14)
	public void updateUserData() {

		UserDataCreation dc = new UserDataCreation();
		UserController uc = new UserController();
		UserCreationPojo up = dc.userUpdate(userName);
		Response response = uc.updateUser(up, userName);
		int statuscode = response.statusCode();
		UploadUpdateForm bodyResponse = response.then().extract().response().as(UploadUpdateForm.class);
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(200, bodyResponse.getCode());

	}

	@Test(priority = 15)
	public void userLogout() {
		UserController uc = new UserController();
		Response response = uc.userLogout();
		int statuscode = response.statusCode();
		UploadUpdateForm bodyResponse = response.then().extract().response().as(UploadUpdateForm.class);
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(200, bodyResponse.getCode());

	}

	@Test(dependsOnMethods = "createUserwithArray", priority = 16)
	public void deleteUserData() {

		UserController uc = new UserController();
		Response response = uc.deleteUser(userName1);
		int statuscode = response.statusCode();
		UploadUpdateForm bodyResponse = response.then().extract().response().as(UploadUpdateForm.class);
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(200, bodyResponse.getCode());

	}

}
