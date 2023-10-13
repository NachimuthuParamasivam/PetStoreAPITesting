package test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import controller.PetsController;
import io.restassured.response.Response;
import main.DataCreation;
import pojo.PetPojo;
import pojo.UploadUpdateForm;

public class PetApiTests {

	List<Integer> dogId = new ArrayList<Integer>();
	List<String> dogName = new ArrayList<String>();

	@Test(priority = 0)
	public void createPet() {

		DataCreation dc = new DataCreation();
		PetsController pc = new PetsController();
		PetPojo pp = dc.createData();
		Response response = pc.createPet(pp);
		int statuscode = response.statusCode();
		String resp1 = response.then().extract().response().asString();// remove finally
		PetPojo bodyresponse = response.then().extract().response().as(PetPojo.class);
		dogId.add(bodyresponse.getId());
		dogName.add(bodyresponse.getName());
		Assert.assertEquals(statuscode, 100);
		Assert.assertEquals(pp.getId(), bodyresponse.getId());
		System.out.println(resp1);// remove finally
	}

	@Test(priority = 1)
	public void updatePet() {
		DataCreation dc = new DataCreation();
		PetsController pc = new PetsController();
		PetPojo p = dc.updateData(dogId.get(0));
		Response response = pc.updatePet(p);
		int statuscode = response.statusCode();
		PetPojo bodyreponse = response.then().extract().response().as(PetPojo.class);
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(p.getId(), bodyreponse.getId());
		Assert.assertEquals(p.getName(), bodyreponse.getName());
		Assert.assertEquals(p.getStatus(), bodyreponse.getStatus());
		String resp1 = response.then().extract().response().asString();
		System.out.println(resp1);
	}

	@Test(priority = 2)
	public void findByStatus() {
		String status = "sold";
		PetsController pc = new PetsController();
		Response response = pc.findByStatus(status);
		int statuscode = response.statusCode();
		String bodyresponse = response.then().extract().response().asString();// removefinally
		Assert.assertEquals(statuscode, 200);
		String resp1 = response.then().extract().response().asString();
		System.out.println(resp1);

	}

	@Test(priority = 3)
	public void findById() {

		PetsController pc = new PetsController();
		Response response = pc.findById(dogId.get(0));
		int statuscode = response.statusCode();
		PetPojo bodyresponse = response.then().extract().response().as(PetPojo.class);
		Assert.assertEquals(statuscode, 200);
		System.out.println(dogId.get(0));// removefinally
		Assert.assertEquals(dogId.get(0), bodyresponse.getId());
		String resp1 = response.then().extract().response().asString();
		System.out.println(resp1);
	}

	@Test(priority = 4)
	public void updateForm() {

		PetsController pc = new PetsController();
		Response response = pc.updateForm(dogId.get(0));
		int statuscode = response.statusCode();
		String bodyresponse = response.then().extract().response().asString();
		UploadUpdateForm output = response.then().extract().response().as(UploadUpdateForm.class);
		System.out.println(output.getMessage());
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(output.getCode(), 200);
		String idAsString = Integer.toString(dogId.get(0));
		Assert.assertEquals(output.getMessage(), idAsString);
		System.out.println(bodyresponse);

		// Assert.assertEquals(dogId.get(0),resp.getId());
	}

	@Test(priority = 5)
	public void uploadImage() {

		PetsController pc = new PetsController();
		Response response = pc.uploadImage(dogId.get(0));
		int statuscode = response.statusCode();
		String bodyresponse = response.then().extract().response().asString();
		UploadUpdateForm output = response.then().extract().response().as(UploadUpdateForm.class);
		System.out.println(output.getMessage());
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(output.getCode(), 200);
		boolean check = output.getMessage().contains("File uploaded");
		Assert.assertEquals(output.getMessage().contains("File uploaded"), true);
		System.out.println(bodyresponse);
	}

	@Test(priority = 6)
	public void deleteById() {

		PetsController pc = new PetsController();
		Response response = pc.deleteById(dogId.get(0));
		int statuscode = response.statusCode();
		String bodyresponse = response.then().extract().response().asString();
		Assert.assertEquals(statuscode, 200);
		System.out.println(bodyresponse);// removefinally
		// Assert.assertEquals(dogId.get(0),resp.getId());
	}
}
