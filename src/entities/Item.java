package entities;

public class Item{
	private int id;
	private String name;
	
	public Item(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// Getters and Setters
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}