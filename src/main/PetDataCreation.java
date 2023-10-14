package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import pojo.PetPojo;
import pojo.PetPojoSubCategory;
import pojo.PetPojotags;

public class PetDataCreation {

	public PetPojo createData()

	{
		PetPojo p = new PetPojo();
		PetPojoSubCategory c = new PetPojoSubCategory();
		PetPojotags t = new PetPojotags();
		Random random = new Random();
		int rand = random.nextInt(50000, 100000);
		p.setId(rand);
		p.setName("WillDog");
		p.setStatus("Available");
		List<String> myList = new ArrayList<String>();
		myList.add("abc.jpg");
		p.setPhotoUrls(myList);
		c.setId(1);
		c.setName("cat 1");
		p.setCategory(c);

		HashMap<String, String> tag = new HashMap<String, String>();
		tag.put("id", "1");
		tag.put("name", "abc");

		ArrayList<HashMap<String, String>> tags = new ArrayList<HashMap<String, String>>();
		tags.add(tag);
		p.setTags(tags);

		return p;

	}

	public PetPojo updateData(int dogId)

	{
		PetPojo p = new PetPojo();
		PetPojoSubCategory c = new PetPojoSubCategory();
		PetPojotags t = new PetPojotags();

		p.setId(dogId);
		p.setName("BullupdateDog");
		p.setStatus("pending");
		List<String> myList = new ArrayList<String>();
		myList.add("abc.jpg");
		p.setPhotoUrls(myList);
		c.setId(1);
		c.setName("cat 1");
		p.setCategory(c);

		HashMap<String, String> tag = new HashMap<String, String>();
		tag.put("id", "1");
		tag.put("name", "abc");

		ArrayList<HashMap<String, String>> tags = new ArrayList<HashMap<String, String>>();
		tags.add(tag);
		p.setTags(tags);

		return p;

	}

}
