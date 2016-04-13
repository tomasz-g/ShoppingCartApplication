package shoppingCart;

public class Product {
	
	private String name;
	private double price;
	private int quantity;
	private String type;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void print() {
		
		System.out.print(name + "\t\t");
		System.out.print(price + "\t");
		System.out.print(quantity + "\t \t");		
	}

}
