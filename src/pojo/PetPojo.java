package pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PetPojo {

	private int id;

	private String name;
	private String status;
	private List<String> photoUrls;
	private PetPojoSubCategory category;
	private List<HashMap<String, String>> tags = new ArrayList<>();

	public List<HashMap<String, String>> getTags() {
		return tags;
	}

	public void setTags(ArrayList<HashMap<String, String>> tags) {
		this.tags = tags;
	}

	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PetPojoSubCategory getCategory() {
		return category;
	}

	public void setCategory(PetPojoSubCategory category) {
		this.category = category;
	}

}
