package com.wang.test.checkout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.wang.test.checkout.domain.Cart;

public class CheckOutBulk {

	public static void main(String[] args) throws InterruptedException {
		List<Cart> customers = new ArrayList<>();
		Cart e;
		
		Boolean save = args.length > 0;
		e = new Cart("1",Arrays.asList("Apple"), save) ;
		customers.add(e);
		e = new Cart("2",Arrays.asList("Apple","Apple"),save) ;
		customers.add(e);
		e = new Cart("3",Arrays.asList("Apple","Orange","Orange","Apple"), save) ;
		
		customers.add(e);
		
		for(Cart e1: customers)
			CheckOutBulk.checkOutCustomer(e1);
	}
	
	
	public static void checkOutCustomer(Cart customer) {
		int t=customer.getOrange().getTotal()+customer.getApple().getTotal();
		System.out.println("\n==============================================");
		System.out.println("\n======= Final Check Out Customer: " +customer.getId()+" ==========");
		System.out.println("\n==============================================");
		String out ="";
		if(customer.getOrange().getQuantity() > 0) out = customer.getOrange().printSubTotals();
		if(customer.getApple().getQuantity() > 0) out = customer.getApple().printSubTotals();
		
		if(customer.getApple().getQuantity() > 0) {
			out = customer.getApple().printSubTotals();
			if(customer.getApple().isBogo()) {
				out += " \n  Savings applied: "+customer.getApple().applySavings();
			}
		}
		if(customer.getOrange().getQuantity() > 0) {
			out += customer.getOrange().printSubTotals();
			if(customer.getOrange().isBogo()) {
				out += "\n  Savings applied: "+customer.getOrange().applySavings();
			}
		}

		System.out.println(out+"\nGrand Total: "+t);
		System.out.println("\n==============================================");
	}

}
