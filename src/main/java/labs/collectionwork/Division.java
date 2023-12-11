package labs.collectionwork;

public class Division {

	public Division(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Division() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;
	private String name;
}
