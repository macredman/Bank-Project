/* Mackenzie Redman
*  2.4.16
*  Deitel book
*/

public class Main {

	public static void main(String[] args) {
		SuperClass mySuperClassObject = new SuperClass();
		SubClass mySubClassObject = new SubClass();
		AnotherSubClass myAnotherSubClassObject = new AnotherSubClass();
		
		mySuperClassObject.getMessage();
		mySubClassObject.getMessage();
		myAnotherSubClassObject.getMessage();
		
		mySuperClassObject.setMessage("Original SuperClass Interface");
		mySubClassObject.setMessage("SubClass Interface");
		myAnotherSubClassObject.setMessage("AnotherSubClass Interface" + "\n");

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
