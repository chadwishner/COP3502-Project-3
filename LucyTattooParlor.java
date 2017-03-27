import java.util.*;

public class LucyTattooParlor {

	public static int maxCustomers;
	
	public static void main(String [] args){
		
		Scanner input = new Scanner(System.in);
		
		maxCustomers = Integer.parseInt(args[2]);
		

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
		 
			
//		}
		//add if the artist's indexes are full or if time > 8 hours, then the customer cannot be added to that artist and must print out an error message.
		//add if for if all artists are full in either indexes or in time (8 hour max)

		//must add name, tattoo, and time to specified artist or artist of shortest time
	}
	
	/**
	* Computes how many minutes of work the specified tattoo artist has. 
	* @param The array of customers for one particular tattoo artist
	*/
	public static int computeMinutesOfWork(TattooCustomer [] a) {
		int total = 0;
		for (int i = 0; i >= a.length; i++){
			total = total + a[i].getMinutes(); 	
		}		
		return total; 
	}
	
	/**
	* Adds customer to the waitlist for a specific artist.
	* If the artist is at capacity (in terms of number of customers or minutes)
	* Then the customer is not added and the method returns false
	* If the customer is successfully added the method returns true
	* @param
	*/
	public static boolean addCustomer(TattooCustomer [][] a, TattooCustomer c, int artistNum) {
		
		if ((computeMinutesOfWork(a [artistNum]) <= 480) && (a[artistNum].length < maxCustomers)){
			for (int i = 0; i < a[artistNum].length; i++){
				if (a[artistNum][i] == null){
					a[artistNum][i] = c;
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	* Adds customer to the shortest waitlist in terms of minutes. If some artists have equal length waitlists
	* then the customer is added to the lowest numbered artist. If no artist has space then the method does not * add the customer, and returns false.
	* TODO - finish this javadoc  
	* @return true if the customer was added to the waitlist, false otherwise (if all artists were full) 
	*/
	public static boolean addCustomer(TattooCustomer [][] a, TattooCustomer c) {
	
		int currentShortest = 0;
		int filledSlots = 0;
		
		for (int i = 0; i< a[0].length; i++){
			if(a[0][i] != null){
				currentShortest++;
			}
		}
					
		for (int x = 0; x >= a.length; x++){
			for (int j = 0; j < (a.length); j++){
				for (int i = 0; i< a[j].length; i++){
					if(a[j][i] != null){
						filledSlots++;
					}
					if(filledSlots < current)
				}
			}
		}	
	return false;
	}

}
