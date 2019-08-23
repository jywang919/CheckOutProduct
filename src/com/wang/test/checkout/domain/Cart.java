package com.wang.test.checkout.domain;

import java.util.List;

public class Cart {
	private String id ="0";
	private Orange orange;
	private Apple apple; 
	
	
	public Orange getOrange() {
		return orange;
	}


	public void setOrange(Orange orange) {
		this.orange = orange;
	}


	public Apple getApple() {
		return apple;
	}


	public void setApple(Apple apple) {
		this.apple = apple;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public Cart(Orange orange, Apple apple) {
		this.orange = orange;
		this.apple = apple;
	}

	public Cart(String id, List<String> prods, Boolean save) {
		orange = new Orange();
		orange.setBogo(save.booleanValue());
		apple= new Apple();
		apple.setBogo(save.booleanValue());
		for(String s : prods) {
			if(s.startsWith("A")||s.startsWith("a")) {
				apple.addOne();
			}
			if(s.startsWith("O")|| s.startsWith("o") ) {
				orange.addOne();
			}
				
		}
		this.id=id;
	}
	
	public void empty() {
		this.orange.setQuantity(0);
		this.apple.setQuantity(0);
	}
	public void checkOut() {
		int t=this.getOrange().getTotal()+this.getApple().getTotal();
		System.out.println("\n==============================================");
		System.out.println("\n======= Final Check Out Cart: " +this.getId()+" ==========");
		System.out.println("\n==============================================");
		String out ="";
		if(this.getOrange().getQuantity() > 0) out = this.getOrange().printSubTotals();
		if(this.getApple().getQuantity() > 0) out = this.getApple().printSubTotals();
		
		if(this.getApple().getQuantity() > 0) {
			out = this.getApple().printSubTotals();
			if(this.getApple().isBogo()) {
				out += " \n  Savings applied: "+this.getApple().applySavings();
			}
		}
		if(this.getOrange().getQuantity() > 0) {
			out += this.getOrange().printSubTotals();
			if(this.getOrange().isBogo()) {
				out += "\n  Savings applied: "+this.getOrange().applySavings();
			}
		}
	
		System.out.println(out+"\nGrand Total: "+t);
		System.out.println("\n---------------------------------------------");
		
	}
}
