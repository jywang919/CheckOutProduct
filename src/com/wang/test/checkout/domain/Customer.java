package com.wang.test.checkout.domain;

import java.util.List;

public class Customer {
	private String id;
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


	public Customer(String id, List<String> prods, Boolean save) {
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
}
