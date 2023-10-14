package main;

import java.util.Random;

import pojo.StorePojo;

public class StoreDataCreation {

	public StorePojo createData(int dogId)

	{
		StorePojo s = new StorePojo();

		Random random = new Random();
		int rand = random.nextInt(1, 10);

		s.setId(rand);
		s.setPetId(dogId);
		s.setQuantity(2);
		s.setShipDate("2023-10-13T23:04:48.034Z");
		s.setStatus("placed");
		s.setComplete(true);

		return s;

	}
}
