
public class SubClass extends SuperClass{

	public SubClass() {
		super();
	}
	
	public void getMessage(){
		System.out.println("This is the SUBCLASS message: " + objectmessage);
	}
	
	public void getID(){
		System.out.println("Here is your pin! :" + pin);
	}
	
	public void getArray(){
		intArray[0] = pin;
		intArray[1] = value1;
		intArray[2] = value2;
	}
	
	public void setArray(){
		for (int i=0; i<intArray.length; i++){
			System.out.println(intArray[i]);
		}
	}

}
