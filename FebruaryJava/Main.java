
public class Main {

	public static void main(String[] args) {
		SuperClass mySuperClassObject = new SuperClass();
		SubClass mySubClassObject = new SubClass();
		AnotherSubClass myAnotherSubClassObject = new AnotherSubClass();
		
		mySuperClassObject.getMessage();
		mySubClassObject.getMessage();
		myAnotherSubClassObject.getMessage();
		
		mySuperClassObject.setMessage("Hey homie this is a SUPERCLASS!");
		mySubClassObject.setMessage("Hey homie this is a SUBCLASS!");
		myAnotherSubClassObject.setMessage("Hey homie this is a ANOTHERSUBCLASS!");

		mySuperClassObject.getMessage();
		mySubClassObject.getMessage();
		myAnotherSubClassObject.getMessage();
		
		mySubClassObject.getID();
	
		mySubClassObject.getArray();
		mySubClassObject.setArray();
		
		myAnotherSubClassObject.test();
		myAnotherSubClassObject.testInputType();
		myAnotherSubClassObject.testZero();
	}

}
