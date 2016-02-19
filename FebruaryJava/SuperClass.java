
public class SuperClass {
	

	String objectmessage = "This is the original superclass message.";
	int pin;
	public int value1;
	int value2;
	int[] intArray;

	public SuperClass() {
		super();
		value1 = 66;
		value2 = 2;
		intArray  = new int[3];
		pin = hashCode(); 
	}
	
	public void getMessage(){
		System.out.println("This is the SUPERCLASS message: " + objectmessage);
	}

	public void setMessage(String newMessage){
			this.objectmessage = newMessage;
		}
	
	public void getID(){
		System.out.println(pin);
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
