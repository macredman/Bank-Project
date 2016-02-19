import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AnotherSubClass extends SuperClass{

	Scanner scnr;
	int[] SubArray;
	int value3;
	int value4;
	String hello;
	
	public AnotherSubClass() {
		super();
		SubArray = new int[5]; 
		value3 = 55;
		value4 = 12;
		scnr = new Scanner(System.in);
	}

	public void getMessage(){
		System.out.println("This is the ANOTHERSUBCLASS message: " + objectmessage);
	}
	
	public void getArray(){
		SubArray[0] = pin;
		SubArray[1] = value1;
		SubArray[2] = value2;
		SubArray[3] = value3;
		SubArray[4] = value4;
	}
	
	public void test(){
		boolean present;
		try {
		  if(hello == null)
		   present = true;
		} catch (NoSuchElementException e) {
		   present = false;
		   System.out.print("Error");
		}
	}
	
	public void testInputType(){
		System.out.println("Enter midterm grade");
		
		int userChoice = scnr.nextInt();//<-- use this variable

		
		
		  do
		  { 
		      try {
		          String s = scnr.nextLine();
		          userChoice = Integer.parseInt(s);
		          break;
		      }
		      catch (Exception e)
		      {
		          System.out.println("Couldn't parse input, please try again");
		      }
		  }
		  while (true);

        // Variable used for storing what the user's main menu choice
        if (0 > userChoice || userChoice > 8)
        {
            System.out.println("Error: Invalid Menu Selection.");
            userChoice = scnr.nextInt();
        }
	}
	
	public void testZero(){
		System.out.println("Pick a numerator");
		int numerator = scnr.nextInt();
		System.out.println("Pick a denominator to divide by");
		int divisor = scnr.nextInt();
		int result;
		result = numerator / divisor;
		
		if (divisor != 0) {
			System.out.println(result);
		} else{
			 System.out.println("Error: Can't divide by zero.");
	            divisor = scnr.nextInt();
		}
		
		
		
	}
}
