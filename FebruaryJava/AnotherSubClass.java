import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AnotherSubClass extends SuperClass{

	Scanner scnr;
	int[] SubArray;
	int value3;
	int value4;
	String hello;
	
	//constructor
	public AnotherSubClass() {
		super();
		SubArray = new int[5]; 
		value3 = 55;
		value4 = 12;
		scnr = new Scanner(System.in);
	}

	@Override
	public void getMessage(){
		System.out.println("Welcome student user: " + objectmessage);
	}
	
	@Override
	public void getArray(){
		SubArray[0] = pin;
		SubArray[1] = ID;
		SubArray[2] = value;
		SubArray[3] = value3;
		SubArray[4] = value4;
	}
	
	@Override
	public void setArray(){
		for (int i=0; i<intArray.length; i++){
			System.out.println("your pin is " + intArray[0]);
			System.out.println("your student ID is " + intArray[1]);
		}
	}
	
	//test if object is present
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
	
	//test input type & range
	public void testInputType(){
		System.out.println("Enter first number of ID");
		
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
        if (0 > userChoice || userChoice > 101)
        {
            System.out.println("Error: Invalid Menu Selection.");
            userChoice = scnr.nextInt();
        }
	}
	
	//test for divide by zero
	public void testZero(){
		System.out.println("How many points total for the semester?");
		int numerator = scnr.nextInt();
		System.out.println("How many assignments were completed?");
		int divisor = scnr.nextInt();
		int result;
		result = numerator / divisor;
		
		if (divisor != 0) {
			System.out.println("Grade in class equals: " + result);
		} else{
			 System.out.println("Error: Can't divide by zero.");
	            divisor = scnr.nextInt();
		}
		
		
		
	}
}
