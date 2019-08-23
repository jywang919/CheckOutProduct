## This project simulates a check out scenarios.

The products are Apple and Orange.  Apples cost 60p, Oranges cost 20p

Shop may provide offers as follows:

 - Buy one, get one for free on Apple

 - 3 for the price of 2 on Oranges

It can be run in interactive mode or as bulk mode

# To run in bulk mode

    java -cp checkout.jar com.wang.test.checkout.CheckOutBulk

# To run in bulk mode with savings:

   java -cp checkout.jar com.wang.test.checkout.CheckOutBulk save
 
# To run in interactive mode

	java -cp checkout.jar com.wang.test.checkout.CheckOut
	
	type A for Apple 
	
	type O for Orange
	
	type T to checkout the total
	
	type Q to quit the process 
	
# To run in interactive mode with savings

	java -cp checkout.jar com.wang.test.checkout.CheckOut save
	