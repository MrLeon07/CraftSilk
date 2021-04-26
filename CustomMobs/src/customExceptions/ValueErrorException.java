package customExceptions;

public class ValueErrorException extends Exception{

	String Message;
	private static final long serialVersionUID = 1L;
	public ValueErrorException(String Message) {
		this.Message = Message;
	}
	public String getMessage() {
		return Message;
	}


}
