public class TattooCustomer {
	
	//create the private variables to store the characteristics of the object TattooCustomer
	private String name;
	private String tattoo;
	private int minutes;

	TattooCustomer (String name, String tattoo, int minutes){
	
		//map the constructors to the private variables
		this.name = name;
		this.tattoo = tattoo;
		this.minutes = minutes;
	}
	
	/**
	 * Getter Method in order to retrieve TattooCustomer name
	 * @return Name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Getter Method in order to retrieve TattooCustomer name
	 * @return Tattoo
	 */
	public String getTattoo() {
		return this.tattoo;
	}
	
	/**
	 * Getter method in order to retrieve TattooCustomer name
	 * @return Minutes
	 */
	public int getMinutes() {
		return this.minutes;
	}
}
