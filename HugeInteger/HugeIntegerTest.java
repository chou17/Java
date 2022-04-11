
//hw1 8.16 test file(main file)

import java.util.Scanner;

public class HugeIntegerTest {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Please enter first number: ");
		String num1 = input.nextLine();
		System.out.print("Please enter second number: ");
		String num2 = input.nextLine();
	    
		HugeInteger x = new HugeInteger(num1);
	    HugeInteger y = new HugeInteger(num2);
	    
	    //check num1 is 0 or not
	    if(x.isZero())
	        System.out.println("first number is 0.");
	    else 
	    	System.out.println("first number is not 0, first number is " + x.toString());
	    	
	    //check num2 is 0 or not    
	    if(y.isZero())
	        System.out.println("second number is 0");
	    else
		    System.out.println("second number is not 0, second number is " + y.toString());
	   
	    //check =, !=, >, <, >=, <=
	    if(x.isEqualTo(y)) 
	        System.out.println(x.toString() + " = " + y.toString());
	    else if(x.isNotEqualTo(y))
	        System.out.println(x.toString() + " != " + y.toString());
	    
	    if(x.isGreaterThan(y)) 
	        System.out.println(x.toString() + " > " + y.toString());
	        
	    else if(x.isLessThan(y)) 
	        System.out.println(x.toString() + " < " + y.toString());
	        
	    if(x.isGreaterThanOrEqualTo(y))
	        System.out.println(x.toString() + " >= " + y.toString());    
	    else if(x.isLessThanOrEqualTo(y))
	        System.out.println( x.toString() + " <= " + y.toString());
	    
	    //subtract
	    if(x.isEqualTo(y)) 
	        System.out.println("subtract: 0" );
	    else if(x.isLessThan(y)) 
	        System.out.println("subtract: It will be negative." );    
	    else {
	    	HugeInteger diff = x.subtract(y);
	        System.out.println("subtract: " + diff.toString());
	    }
	    //add
	    HugeInteger sum = x.add(y);
	    System.out.println("add: " + sum.toString());
	}

}
