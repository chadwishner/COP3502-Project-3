import java.util.*;

public class LucyTattooParlor {
	
	//create a global variable in order to know the max amount of customers that an artist can take
	public static int maxCustomers;
	
	public static void main(String [] args){
		
		//create new scanner
		Scanner input = new Scanner(System.in);
		
		//create and initialize variables
		String name = "";
		String artist = "";
		String tattoo = "";
		int time;
		int artistNum = 0;
		
		//set maxCustomers to the second  command line argument passed in
		maxCustomers = Integer.parseInt(args[1]);
		
		//create and initialize the size of the 2D array to store the TattooCustomers
		TattooCustomer [][] array = makeArray(args);
		
		//create a while loop to be able to input new customers unless the program is ended by printing the waitlist
		while (name.compareToIgnoreCase("Print Waitlist") != 0){
			
			//ask for the Customer's name
			System.out.println("Please enter your name.");
			name = input.nextLine();
			
			//If user types in "Print Waitlist", print waitlist, and terminate program
			if (name.compareToIgnoreCase("Print Waitlist") == 0){
				printArray(array);
				break;
			}
			else {		
				
				//ask user what tattoo they would like to get
				System.out.println("Hi " + name + ", what tattoo would you like?");
				tattoo = input.nextLine();
		
				//ask user if they would like to request a specific artist, or to be placed in the shortest waitlist
				System.out.print("If you would like a specific tattoo artist, please enter their index (");
				
				//use a for loop to print out the available artists' indexes
				for (int i = 0; i < array.length; i++){
					System.out.print(i);
					
					//if statement to only print out right amount of comma/space separators 
					if (i < (array.length - 1)){
						System.out.print(", ");
					}
				}
				System.out.println("). If you would like to be added to the shortest waiting list, please enter 'shortest'.");
				artist = input.next();
				
				//if the user did not choose to be placed in the shortest waitlist, convert their String input into an integer 
				if (artist.compareToIgnoreCase("shortest") != 0){
					artistNum = Integer.parseInt(artist);
				}
				
				//ask how many minutes their tattoo will take
				System.out.println("How many minutes is your tattoo expected to take?");
				time = input.nextInt();
				
				//clear the scanner line
				input.nextLine();
				
			}
	
			//create an instance of the TattooCustomer object
			TattooCustomer customer = new TattooCustomer(name, tattoo, time);
		
			//use a do-while loop in order to allow the user to choose to be placed in a new line if their artist's waitlist is full
			do {
				//if the user chose to be in the shortest line, use proper method
				if (artist.compareToIgnoreCase("shortest") == 0){
				
					//if the customer was not successfully added, all waitlists are full
					if (addCustomer(array, customer) == false){
						System.out.println("Unfortunetly, all artists are full for tomorrow night, please come again another night. \n");
					break;
					}
					//if the user was successfully added, break from loop and allow a new customer to enter their information
					else {
						System.out.println("You have successfully been added to the waitlist, we will see you tomorrow. \n");
						break;
					}
				}
				else {
					
					//if the customer was not successfully added, allow the user to enter into a different waitlist
					if (addCustomer(array, customer, artistNum) == false){
						System.out.println("Unfortunetly, the artist you selected is completely booked for tomorrow night, please choose a different artist, as an integer.");
						artistNum = input.nextInt();
						
						//clear the scanner line
						input.nextLine();
					}
					else {
						//if the user was successfully added, break from loop and allow a new customer to enter their information
						System.out.println("You have successfully been added to the waitlist, we will see you tomorrow. \n");
						break;
					}
				}
			} while (addCustomer(array, customer) != true || addCustomer(array, customer, artistNum) != true);
		}
	}
	/**Method to create the array with the command line arguments that define the array size
	 * @return the array
	 */
	public static TattooCustomer [][] makeArray(String [] args){
		//save the command line arguments as integers to set array size
		int numArtist = Integer.parseInt(args[0]);
		int maxCustomers = Integer.parseInt(args[1]);
		
		//create new array of proper size
		TattooCustomer [][] array = new TattooCustomer [numArtist][maxCustomers];

		return array;
	}
	
	/**Method in order to print the array
	 * @param The 2D array of TattooCustomers
	 */
	public static void printArray(TattooCustomer [][] array){
		
		//for loop to run through all Tattoo artists
		for (int i = 0; i < array.length; i++){
			
			//Print out formatting
			System.out.print("\t\t|\t");
			//Prints the first row of formatting and TattooCustomer Names
			for (int j = 0; j < array [i].length; j++){
				//Print out name if they are not null
				if (array[i][j] != null){
				System.out.print(array[i][j].getName() + "\t\t");
				}	
			}
	
			//Print out formatting
			System.out.print("\nArtist " + i + "\t|\t");
			//Prints the first row of formatting and TattooCustomer Names
			for (int j = 0; j < array [i].length; j++){
				//Print out name if they are not null
				if (array[i][j] != null){
				System.out.print(array[i][j].getTattoo() + "\t\t");
				}
			}
			
			//Print out formatting
			System.out.print("\n\t\t|\t");
			//Prints the first row of formatting and TattooCustomer Names
			for (int j = 0; j < array [i].length; j++){
				//Print out name if they are not null
				if (array[i][j] != null){
				System.out.print(array[i][j].getMinutes() + "\t\t");
				}
			}
			//Prints new line
			System.out.print("\n\n");
		}
	}
	
	
	
	/**
	* Computes how many minutes of work the specified tattoo artist has. 
	* @param The array of customers for one particular tattoo artist
	* @return The total wait time for one particular tattoo artist
	*/
	public static int computeMinutesOfWork(TattooCustomer [] a) {
		int total = 0;
		//runs through all the customers of a single artist and adds up their total wait time
		for (int i = 0; i < a.length; i++){
			if (a[i] != null){
				total = total + a[i].getMinutes();
			}
		}		
		return total; 
	}
	
	/**
	* Adds customer to the waitlist for a specific artist.
	* If the artist is at capacity (in terms of number of customers or minutes)
	* Then the customer is not added and the method returns false
	* If the customer is successfully added the method returns true
	* @param 2D array for TattooCustomers, an instance of object TattooCustomer, artistNum for which artist to place customer in
	* @return true if the customer was added to the waitlist, false otherwise (if all artists were full) 
	*/
	public static boolean addCustomer(TattooCustomer [][] a, TattooCustomer c, int artistNum) {
		
		//if the first slot in an artist's waitlist is null, add the Customer their and return True
		if (a[artistNum][0] == null){
			a[artistNum][0] = c;
			return true;
		}
		
		//check to make sure that the waitlist isn't full through time or slots, add the customer to the waitlist and return true
		else if ((computeMinutesOfWork(a[artistNum]) <= 480) && (a[artistNum].length < maxCustomers)){
			for (int i = 0; i < a[artistNum].length; i++){
				if (a[artistNum][i] == null){
					a[artistNum][i] = c;
					return true;
				}
			}
		}
		
		//return false if the customer could not be added to the waitlist
		return false;
	}
	
	/**
	* Adds customer to the shortest waitlist in terms of minutes. If some artists have equal length waitlists
	* then the customer is added to the lowest numbered artist. If no artist has space then the method does not * add the customer, and returns false.
	* @param 2D array for TattooCustomers, an instance of object TattooCustomer
	* @return true if the customer was added to the waitlist, false otherwise (if all artists were full) 
	*/
	public static boolean addCustomer(TattooCustomer [][] a, TattooCustomer c) {
			
		//Initialize array index for the shortest time
		int shortest = 0;
		
		//find the artist with the shortest wait time
		for (int i = 1; i < a.length; i++){
			if (computeMinutesOfWork(a[i]) < computeMinutesOfWork(a[shortest])){
				shortest = i;
			}
		}
		
		//add the TattooCustomer to the first available index in the array, return true if added
		for (int j = 0; j < a[shortest].length; j++){
			if (a[shortest][j] == null){
				a[shortest][j] = c;
				return true;
			}
		}
		
		//return false if the customer could not be added to the waitlist
		return false;
	}
}
