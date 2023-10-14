package test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import controller.StoreController;
import io.restassured.response.Response;
import main.StoreDataCreation;
import pojo.StorePojo;
import pojo.UploadUpdateForm;

public class StoreApiTests {

	PetApiTests p = new PetApiTests();
	int m = 99695;
	public List<Integer> orderId = new ArrayList<Integer>();

	@Test(priority = 7, dependsOnMethods = "createPet")
	public void placeOrder() {

		StoreDataCreation sdc = new StoreDataCreation();
		StoreController sc = new StoreController();
		StorePojo sp = sdc.createData(m);
		Response response = sc.createStore(sp);
		int statuscode = response.statusCode();
		StorePojo bodyresponse = response.then().extract().response().as(StorePojo.class);
		orderId.add(bodyresponse.getId());
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(sp.getId(), bodyresponse.getId());

	}

	@Test(priority = 8)
	public void findById() {

		StoreController sc = new StoreController();
		Response response = sc.findById(orderId.get(0));
		int statuscode = response.statusCode();
		StorePojo bodyresponse = response.then().extract().response().as(StorePojo.class);
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(orderId.get(0), bodyresponse.getId());

	}

	@Test(priority = 9)
	public void deleteById() {

		StoreController sc = new StoreController();
		Response response = sc.deleteById(orderId.get(0));
		int statuscode = response.statusCode();
		UploadUpdateForm bodyresponse = response.then().extract().response().as(UploadUpdateForm.class);
		Assert.assertEquals(statuscode, 200);
		String idAsString = Integer.toString(orderId.get(0));
		Assert.assertEquals(bodyresponse.getMessage(), idAsString);
		Response verification = sc.findById(orderId.get(0));
		int verificationstatuscode = verification.statusCode();
		UploadUpdateForm verificationbodyresponse = verification.then().extract().response().as(UploadUpdateForm.class);
		Assert.assertEquals(verificationstatuscode, 404);
		String verificationText = "Order not found";
		Assert.assertEquals(verificationText, verificationbodyresponse.getMessage());
		String resp2 = verification.then().extract().response().asString();
		System.out.println(resp2);
	}

	@Test(priority = 10)
	public void inventory() {

		StoreController sc = new StoreController();
		Response response = sc.inventory();
		int statuscode = response.statusCode();
		Assert.assertEquals(statuscode, 200);

	}

}
