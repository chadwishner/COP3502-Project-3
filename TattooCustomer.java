import java.util.Scanner;

public class TattooCustomer {
	public static void main(String [] args){
		
		Scanner input = new Scanner(System.in);
		

		
		System.out.println("Please enter your name.");
		String name = input.next();
			if (name.compareToIgnoreCase("Print Waitlist") == 0){
				//print the waitlist array
			}
					
		System.out.println("Hi " + name + ", what tatoo would you like?");
		String tattoo = input.next();
		
		System.out.println("If you would like a specific tattoo artist, please enter their index (0, 1, 2, ect.). If you would like to be added to the shortest waiting list, please enter 'shortest'.");
		String artist = input.next();
					
			if (artist.compareToIgnoreCase("shortest") == 0){
				//add to shortest wait time
			}
			else {
				// add the person to the specific artists index
				
			}
		System.out.println("How many minutes is your tattoo expected to take?");
		int time = input.nextInt();
		 
		
		//add if the artist's indexes are full or if time > 8 hours, then the customer cannot be added to that artist and must print out an error message.
		//add if for if all artists are full in either indexes or in time (8 hour max)

		//must add name, tattoo, and time to specified artist or artist of shortest time
	}
}
