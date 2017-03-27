import java.util.Scanner;

public class TattooCustomer {
	
	private String name;
	private String tattoo;
	private int minutes;

	TattooCustomer (String name, String tattoo, int minutes){
	
		this.name = name;
		this.tattoo = tattoo;
		this.minutes = minutes;
	}
	
	public String getName() {
		return this.name;
	}
	public String getTattoo() {
		return this.tattoo;
	}
	public int getMinutes() {
		return this.minutes;
	}
}
