package com.wang.test.checkout.domain;

public class Apple extends Product{
	public Apple() {
		super("Apple");
		this.setUnitPrice(60);
	}
	

	@Override
	public int applySavings() {
		int saving =0;
		if(this.isBogo() && this.getQuantity() > 1) {
			saving = this.getQuantity()/2 *this.getUnitPrice();
			System.out.println("\n"+this.getProductName() +" saved: "+saving);
		}
		return saving;
	}
}
