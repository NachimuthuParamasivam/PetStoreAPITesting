package test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import controller.PetsController;
import io.restassured.response.Response;
import main.PetDataCreation;
import pojo.PetPojo;
import pojo.UploadUpdateForm;

public class PetApiTests {

	public List<Integer> dogId = new ArrayList<Integer>();
	public List<String> dogName = new ArrayList<String>();

	@Test(priority = 0)
	public void createPet() {

		PetDataCreation dc = new PetDataCreation();
		PetsController pc = new PetsController();
		PetPojo pp = dc.createData();
		Response response = pc.createPet(pp);
		int statuscode = response.statusCode();
		PetPojo bodyresponse = response.then().extract().response().as(PetPojo.class);
		dogId.add(bodyresponse.getId());
		dogName.add(bodyresponse.getName());
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(pp.getId(), bodyresponse.getId());
	
	}

	//@Test(priority = 1)
	public void updatePet() {
		PetDataCreation dc = new PetDataCreation();
		PetsController pc = new PetsController();
		PetPojo p = dc.updateData(dogId.get(0));
		Response response = pc.updatePet(p);
		int statuscode = response.statusCode();
		PetPojo bodyreponse = response.then().extract().response().as(PetPojo.class);
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(p.getId(), bodyreponse.getId());
		Assert.assertEquals(p.getName(), bodyreponse.getName());
		Assert.assertEquals(p.getStatus(), bodyreponse.getStatus());
		
	
	}

	//@Test(priority = 2)
	public void findByStatus() {
		String status = "sold";
		PetsController pc = new PetsController();
		Response response = pc.findByStatus(status);
		int statuscode = response.statusCode();
		Assert.assertEquals(statuscode, 200);
	

	}

	//@Test(priority = 3)
	public void findById() {

		PetsController pc = new PetsController();
		Response response = pc.findById(dogId.get(0));
		int statuscode = response.statusCode();
		PetPojo bodyresponse = response.then().extract().response().as(PetPojo.class);
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(dogId.get(0), bodyresponse.getId());
		
	}

	//@Test(priority = 4)
	public void updateForm() {

		PetsController pc = new PetsController();
		Response response = pc.updateForm(dogId.get(0));
		int statuscode = response.statusCode();
		UploadUpdateForm output = response.then().extract().response().as(UploadUpdateForm.class);
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(output.getCode(), 200);
		String idAsString = Integer.toString(dogId.get(0));
		Assert.assertEquals(output.getMessage(), idAsString);
	
	}

	//@Test(priority = 5)
	public void uploadImage() {

		PetsController pc = new PetsController();
		Response response = pc.uploadImage(dogId.get(0));
		int statuscode = response.statusCode();
		UploadUpdateForm output = response.then().extract().response().as(UploadUpdateForm.class);
		System.out.println(output.getMessage());
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(output.getCode(), 200);
		Assert.assertEquals(output.getMessage().contains("File uploaded"), true);
		
	}

	@Test(priority = 6)
	public void deleteById() {

		PetsController pc = new PetsController();
		Response response = pc.deleteById(dogId.get(0));
		int statuscode = response.statusCode();
		Assert.assertEquals(statuscode, 200);
		Response verificationResponse = pc.findById(dogId.get(0));
		int verificationStatusCode = verificationResponse.statusCode();
		UploadUpdateForm bodyresponse = verificationResponse.then().extract().response().as(UploadUpdateForm.class);
		Assert.assertEquals(verificationStatusCode, 404);
		String verificationText = "Pet not found";
		Assert.assertEquals(bodyresponse.getMessage(),verificationText);
	

	}
}
