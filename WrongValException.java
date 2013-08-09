
public class WrongValException extends Exception {

	/** Author - Ishaan Bahal
	 * 
	 * Test Exception Class
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WrongValException(){
		printLocalisedMessage();
	}
	void printLocalisedMessage(){
		System.out.println("Wrong Choice/Val Entered");
	}
}
