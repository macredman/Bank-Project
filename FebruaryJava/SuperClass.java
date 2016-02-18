
public class SuperClass {

	public SuperClass() {
		super();
	}
	
	String objectmessage = "This is the original superclass message.";
	
	public void getMessage(){
		System.out.println("This is the SUPERCLASS message: " + objectmessage);
	}

	public void setMessage(String newMessage){
			this.objectmessage = newMessage;
		}
}
