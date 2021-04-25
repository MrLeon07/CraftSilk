package customExceptions;

public class AlchemyPlusLimitException extends Exception{
	String Message;
	public AlchemyPlusLimitException(String Message) {
		this.Message = Message;
	}
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() {
		return this.Message;
	}



}
