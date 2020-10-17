package demo2;

import java.util.Scanner;

public class ConditionalStatements {
	
	public static void main(String[] args) {
		
		System.out.println(" Which Coffee do you prefer ? S/M/L?");
		
		Scanner inp = new Scanner(System.in);
		String Choice = inp.nextLine();
	    
	   /* if(Choice.equals("S")) {
	    	System.out.println("Price is : $1");
	    }
	    else if(Choice.equals("M")) {
	    	System.out.println("Price is : $2");
	    }
	    
	    else if(Choice.equals("L")) {
	    	System.out.println("Price is : $3");
	    } */
		
		switch(Choice) {
		case "S":
			System.out.println("Price is : $1");
		    break;
		    
		case "M":
			System.out.println("Price is : $2");
		    break;
		case "L":
			System.out.println("Price is : $3");
		    break;
		case "XL":
			System.out.println("Price is : $4");
		    break;
		case "XXL":
			System.out.println("Price is : $5");
		    break;   
		 
		}
	}

}
