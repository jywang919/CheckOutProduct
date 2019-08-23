package com.wang.test.checkout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.wang.test.checkout.domain.Customer;

public class CheckOutBulk {

	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<>();
		Customer e;
		
		Boolean save = args.length > 0;
		e = new Customer("1",Arrays.asList("Apple"), save) ;
		customers.add(e);
		e = new Customer("2",Arrays.asList("Apple","Apple"),save) ;
		customers.add(e);
		e = new Customer("3",Arrays.asList("Apple","Orange","Orange","Apple"), save) ;
		
		customers.add(e);
		
		for(Customer e1: customers)
			CheckOutBulk.checkOutCustomer(e1);
	}
	
	
	public static void checkOutCustomer(Customer customer) {
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
