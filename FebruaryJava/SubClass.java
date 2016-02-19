public class SubClass extends SuperClass{

	//constructor
	public SubClass() {
		super();
	}
	
	@Override
	public void getMessage(){
		System.out.println("Welcome faculty user: " + objectmessage);
	}
	
	@Override
	public void getID(){
		System.out.println("Here is your pin: " + pin);
	}
	
	@Override
	public void getArray(){
		intArray[0] = pin;
		intArray[1] = ID;
	}
	
	@Override
	public void setArray(){
		for (int i=0; i<intArray.length; i++){
			System.out.println("your pin is " + intArray[0]);
			System.out.println("your faculty ID is " + intArray[1]);
		}
	}

}
