package com.jobsity.greenfield;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	int opt = 0;
    	while(opt != 3) {
    		Scanner sc= new Scanner(System.in);
    		System.out.println("Choose an option:");
    		System.out.println("1. Read file");
    		System.out.println("2. Show output");
    		System.out.println("3. Exit");
    		opt = sc.nextInt();
    		switch(opt) {
	    		case 1:
	    			System.out.println("opcion 1");
	    			// Read file and allocate to PlayerSet
	    			break;
	    		case 2:
	    			System.out.println("opcion 2"); 
	    			// Output of set, titles + player set string
	    			break;
	    		case 3:
	    			System.out.println("Bye!"); break;
	    		default:
	    			System.out.println("Unknown choice");
    		
    		}
    		sc.close();
    	}
    }
}
