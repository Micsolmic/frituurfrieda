package be.vdab.repositories;

public class CustomDBException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public CustomDBException(Throwable ex) {
		
		super(ex);
		
	}
	
	
}
