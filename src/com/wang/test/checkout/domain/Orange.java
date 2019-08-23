package com.wang.test.checkout.domain;

public class Orange extends Product{
	public Orange() {
		super("Orange");
		this.setUnitPrice(25);
	}


	@Override
	public int applySavings() {
		int saving =0;
		if(this.isBogo() && this.getQuantity() > 2) {
			saving = this.getQuantity()/3 *this.getUnitPrice();
			System.out.println("\n"+this.getProductName() +" saved: "+saving);
		}
		return saving;
	}
}
