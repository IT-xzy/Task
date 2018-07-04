package services;

public class Item {
	private String name;
	private String price;
	
	public Item() {
	}
	
	public Item(String name, String price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setNmae(String name) {
		this.name = name;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
}
