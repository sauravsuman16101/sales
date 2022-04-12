package io.calculatecost;

public class ItemSpecification
{
	private String name;
	private double price;
	private int quantity;
	private String type;
	
	public ItemSpecification(String name, double price, int quantity, String type)
	{
		this.setName(name);
		this.setPrice(price);
		this.setQuantity(quantity);
		this.setType(type);
	}

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
}
