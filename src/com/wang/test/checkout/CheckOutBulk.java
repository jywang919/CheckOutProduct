package com.wang.test.checkout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.wang.test.checkout.domain.Customer;

public class CheckOutBulk {

	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<>();
		Customer e;
		
		e = new Customer("1",Arrays.asList("Apple")) ;
		customers.add(e);
		e = new Customer("2",Arrays.asList("Apple","Apple")) ;
		customers.add(e);
		e = new Customer("3",Arrays.asList("Apple","Orange","Orange","Apple")) ;
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
		
		System.out.println(out+"\nGrand Total: "+t);
	}

}
