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
			e1.checkOut();
	}

}
