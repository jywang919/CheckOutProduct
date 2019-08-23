package com.wang.test.checkout;

import com.wang.test.checkout.domain.Apple;
import com.wang.test.checkout.domain.Orange;

public class CheckOut {
	Orange o = new Orange();
	Apple a = new Apple();
	Integer t =0;
	boolean save =false;
	
	public static void main(String[] args) throws Exception {
		CheckOut c= new CheckOut();
		if(args.length > 0 ) {
			c.save=true;
			c.a.setBogo(true);
			c.o.setBogo(true);
		}
        c.Run();
	}
	
	public void batchBuying() {
		
	}
	
    public void Run() throws java.lang.Exception {
            try {
                System.out.print("\nWelcome to our fruit shop.\n");
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
                    		this.t=o.getTotal()+this.a.getTotal();
                    		System.out.println("\n==============================================");
                    		System.out.println("\n========== Final Check Out ===================");
                    		System.out.println("\n==============================================");
                    		String out ="";
                    		if(this.a.getQuantity() > 0) {
                    			out = this.a.printSubTotals();
                    			if(this.a.isBogo()) {
                    				out += " \n  Savings applied: "+this.a.applySavings();
                    			}
                    		}
                    		if(this.o.getQuantity() > 0) {
                    			out += this.o.printSubTotals();
                    			if(this.o.isBogo()) {
                    				out += "\n  Savings applied: "+this.o.applySavings();
                    			}
                    		}
                    		System.out.println(out+"\nGrand Total: "+this.t);
                    		this.a=new Apple();
                    		this.o=new Orange();
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
