public class SuperClass {

	String objectmessage = "This code is from the SuperClass" + "\n";
	int pin;
	public int value;
	int ID;
	int[] intArray;

	//constructor
	public SuperClass() {
		super();
		value = 66;
		ID = hashCode();;
		intArray  = new int[3];
		pin = hashCode(); 
	}
	
	//superclass message
	public void getMessage(){
		System.out.println("Welcome user: " + objectmessage);
	}

	public void setMessage(String newMessage){
			this.objectmessage = newMessage;
		}
	
	//getID
	public void getID(){
		System.out.println(pin);
	}
	
	//get array
	public void getArray(){
		intArray[0] = pin;
		intArray[1] = ID;
		intArray[2] = value;
	}
	
	//set array
	public void setArray(){
		for (int i=0; i<intArray.length; i++){
			System.out.println("your pin is" + intArray[0]);
			System.out.println("your User ID is" + intArray[1]);
		}
	}

}
