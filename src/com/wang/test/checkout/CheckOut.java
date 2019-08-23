package com.wang.test.checkout;

import com.wang.test.checkout.domain.Apple;
import com.wang.test.checkout.domain.Cart;
import com.wang.test.checkout.domain.Orange;

public class CheckOut {
	Orange o = new Orange();
	Apple a = new Apple();
	Integer t =0;
	boolean save =false;
	Cart cart = new Cart(o,a);
	
	public static void main(String[] args) throws Exception {
		CheckOut c= new CheckOut();
		if(args.length > 0 ) {
			c.save=true;
			c.a.setBogo(true);
			c.o.setBogo(true);
		}
        c.Run();
	}
	
    public void Run() throws java.lang.Exception {
            try {
            		System.out.println("\n==============================================");
                System.out.print("\n============ Welcome to our shop =============\n");
                System.out.println("\n==============================================");
                if (this.save) System.out.print("\nSavings will be applied\n");
                int state= 1;
                do {
                    // only prompt after processing a command.
                    if (state==1) {
                        System.out.print("\n[O]range [A]ple [T]otal [Q]uit?\n==> ");
                        state=0;
                    }
                    int c= System.in.read(); // read one char at a time
                    	if (c=='O'||c=='o') this.o.addOne();
                    	if (c=='A'||c=='a') this.a.addOne();
                    	if (c=='T'||c=='t') {
                    		this.cart.checkOut();
                    		this.cart.empty();
                    	}
                    	
                    if ((c=='Q')||(c=='q')) state=99;
                    	
                } while (state!=99);

                System.out.println("\n");
            }

            catch (Exception ex1) {
                System.out.println("Exception: " + ex1);
                ex1.printStackTrace();
            }
        }
    
}
