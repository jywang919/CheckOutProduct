package com.wang.test.checkout.domain;

public abstract class Product {
	
	private int quantity = 0;;
	
	private int unitPrice;
	
	private boolean bogo=false;
	
	private String productName;
	
	private String savingTerm="";
	
	public Product(String name) {
		this.productName=name;
	}
	
	public int getTotal() {
		Integer total =this.getQuantity() * this.getUnitPrice();
		total = total - applySavings();
		return total;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void addOne() {
		this.quantity++;
		System.out.println(printSubTotals());
//		return this.getQuantity();
	}

	


	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public boolean isBogo() {
		return bogo;
	}

	public void setBogo(boolean bogo) {
		this.bogo = bogo;
	}

	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	abstract int applySavings();
	
	public String printSubTotals() {
		String res= "\n"+this.productName+" "+this.getQuantity() +" @"+this.getUnitPrice()+": "+this.getTotal();
		return res;
	}
}

