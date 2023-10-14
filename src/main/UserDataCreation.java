package main;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

import pojo.UserCreationPojo;

public class UserDataCreation {
	
	public static UserCreationPojo user;
    public static Faker fake = new Faker();
    // public static String userId;
    public static List<String> finalName=new ArrayList<String>();
    public static List<String> password=new ArrayList<String>();
     

    public UserCreationPojo userData() {
        user = new UserCreationPojo();
        user.setId(fake.number().randomDigitNotZero());
        user.setUsername(fake.name().username());
        user.setFirstName(fake.name().firstName());
        user.setLastName(fake.name().lastName());
        user.setEmail(fake.internet().emailAddress());
        user.setPassword(fake.internet().password());
        user.setPhone(fake.phoneNumber().phoneNumber());
        user.setUserStatus(1);
        finalName.add(user.getUsername());
        return user;
    }
    public List<UserCreationPojo> createUser(long numberOfUsers){

    	List<UserCreationPojo> userPojoList = new ArrayList<>();

        for(int count=0;count<numberOfUsers;count++){
        	
            userPojoList.add(userData());
        }

        return userPojoList;
    }
    
    public UserCreationPojo userUpdate(String userNameUpdate)
    {
    	UserCreationPojo p = new UserCreationPojo();
    	p.setId(101);
    	p.setFirstName("Test");
    	p.setUsername(userNameUpdate);
    	p.setLastName("User");
    	p.setEmail(fake.internet().emailAddress());
    	p.setPhone("03323232");
    	p.setUserStatus(1);
    	p.setPassword("abc123");
    	
		
		
		return p;
    }
	
}
