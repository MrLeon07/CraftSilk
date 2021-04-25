package customExceptions;

public class AlchemyEnchantmentLimitException extends Exception{
	String Message;
	private static final long serialVersionUID = 1L;
	public AlchemyEnchantmentLimitException(String Message) {
		this.Message = Message;
	}
	public String getMessage() {
		return Message;
	}

}
