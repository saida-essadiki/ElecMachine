package data;

public class Fish {
	private int id;
	private String breed;
	public Fish(String id, String breed) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.breed=breed;
	}
	public Fish() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
}
