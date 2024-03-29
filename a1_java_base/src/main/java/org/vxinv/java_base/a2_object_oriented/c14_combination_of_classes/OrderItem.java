package org.vxinv.java_base.a2_object_oriented.c14_combination_of_classes;

public class OrderItem {
	//购买产品
	private Product product;

	//购买数量
	private int quantity;

	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public double computePrice(){
		return product.getPrice()*quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}



