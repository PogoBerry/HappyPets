import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuOptions
	{
		private static List <Dog>  dogs  = new ArrayList <Dog> ();
		private static List <Cat>  cats  = new ArrayList <Cat> ();
		private static List <Bird> birds = new ArrayList <Bird> ();
		
		/** This method presents the menu for the application
		 */
		public static void showMenu () 
			{
				Scanner scan = new Scanner (System.in);
				
				// 30 asterisks	
				String welcome =   "\n******************************\n"  
								  + "  Happy Pets Animal Hospital\n"
							      +"\n******************************\n";
				
				System.out.println (welcome);
				System.out.print ("Please select from the following menu options:\n"
						+ "1) Print total patient count\n" 
						+ "2) Print a list of patients by type\n"
						+ "3) Search for pet by name\n"
						+ "4) Search for pet by ID\n"
						+ "0) Exit\n"
						+ "\nPlease make a selection: ");
				
				if (scan.hasNextInt () == false) 
					{
						System.out.println ("Invalid input. Please select a " +
								"number between 0 and 4.");
						showMenu();
						
					} // if
				int selection = scan.nextInt (); // try catch
				
						switch (selection) 
							{
									case 1: MenuOptions.petCount ();
										break;
									case 2: MenuOptions.petPatients ();
										break;
									case 3:	MenuOptions.searchByName ();
										break;
									case 4: MenuOptions.searchByID ();
										break;
									case 0: System.exit(0);
									
									scan.close();
							
							} // switch
				
				if (selection != 0 && selection != 1 && selection != 2 && selection != 3 
						&& selection != 4) 
					{
						System.out.println ("Invalid input. Please select a " +
								"number between 0 and 4.");
						showMenu();
						
					} // if
			
			} // showMenu
		
		/** Option 1; returns a count of all of the patients in the 
		 * active patientt file, along with a count of patients by
		 * type
		 */
		public static void petCount ()
			{
				int dogPatients  = Dog.dogCount(dogs);
				int catPatients  = Cat.catCount (cats);
				int birdPatients = Bird.birdCount (birds);
				
				int total = dogPatients + catPatients + birdPatients;
				
				System.out.print ("\nTotal Patients: "    + total + "\n"
									+ "\n\tDogs: "  + " " + dogPatients
									+ "\n\tCats: "  + " " + catPatients
									+ "\n\tBirds: " + 		birdPatients + "\n");
				
				/** each of the arrays will then clear themselves of all 
				 *  of their elements, since otherwise the menu will retain the values of the 
				 *  previous call to this method if this method is called again
				 */
				dogs.clear  ();
				cats.clear  ();
				birds.clear ();
				
				showMenu();
			
			} // petCount
		
		/** Option 2; prints a list of patients by type based 
		 *  on user input
		 */
		public static void petPatients () 
			{
				Scanner scan1 = new Scanner (System.in);
				
				System.out.println ("What type of pet would you like to list?");
				
				String input = scan1.nextLine();
				
				switch (input) 
					{
						case "Dog": Dog.dogList (dogs);
							break;
						
						case "Cat": Cat.catList (cats);
							break;
						
						case "Bird": Bird.birdList (birds);
							break;
						
					} // switch
				
				if (!input.equals ("Dog") && !input.equals ("Cat") && !input.equals ("Bird")) 
					{
						System.out.println ("Invalid input, please enter a valid pet type.\n");
						
						petPatients();
						
					} // if
				
				showMenu();
				
				scan1.close();
				
			} // petPatients
		
		/** Option 3; this method asks the user for the name of a patient,
		 *  and will then list the record with a matching name; if a record 
		 *  is not found, the method will indicate this to the user
		 */
		public static void searchByName () 
			{
				Scanner scan2 = new Scanner (System.in);
				
				System.out.println ("What is the name of the pet?"); 
				
				String input = scan2.nextLine();
				
				Dog.dogPatients (dogs);
				
				Cat.catPatients (cats);
				
				Bird.birdPatients (birds);
				
				int count = 0;
				
				int total = dogs.size() + cats.size() + birds.size();
				
				for (int i = 0; i < dogs.size (); i++) 
					{
						if (input.equalsIgnoreCase (Dog.getDogName (dogs.get(i)))) 
									{
										System.out.println (dogs.get(i));
									
									} // if
						else 
							{
							  count++;
								
							} // else
					
					} // for
				
				for (int j = 0; j < cats.size (); j++) 
					{
						if (input.equalsIgnoreCase (Cat.getCatName (cats.get(j)))) 
							{
								System.out.println (cats.get(j));
													
							} // if
						else 
							{
								count++;
								
							} // else
										
					} // for
				
				for (int k = 0; k < birds.size (); k++) 
					{
						if (input.equalsIgnoreCase (Bird.getBirdName (birds.get(k)))) 
							{
								System.out.println (birds.get(k));
																	
							} // if
						
						else 
							{
								count++;
								
							} // else
					
					} // for
				
				if (count == total) 
					{
						System.out.println ("Record not found.");
						
					} // if
				
				/** each of the arrays will then clear themselves of all 
				 *  of their elements, since otherwise the menu will retain the values of the 
				 *  previous call to this method if this method is called again
				 */
				dogs.clear();
				cats.clear();
				birds.clear();
				
				showMenu();
				
				scan2.close();
				
			} // searchByName
		
		/** Option 4; this method asks the user for the identifier of a patient,
		 *  and will then list the record with a matching ID; if a record 
		 *  is not found, the method will indicate this to the user
		 */
		public static void searchByID () 
			{
				Scanner scan3 = new Scanner (System.in);
				
				System.out.println ("What is the ID of the pet?"); 
				
				String input = scan3.nextLine();
				
				Dog.dogPatients (dogs);
				
				Cat.catPatients (cats);
				
				Bird.birdPatients (birds);
				
				int i,j,k;
				
				int count = 0;
				
				int total = dogs.size() + cats.size() + birds.size();
				
				for (i = 0; i < dogs.size (); i++) 
					{
						if (input.equals (Dog.getDogID (dogs.get(i)))) 
							{
								System.out.println (dogs.get(i));
									
							} // if
						
						else 
							{ 
								count++; 
							
							} // else
					
					} // for
				
				for (j = 0; j < cats.size (); j++) 
					{
						if (input.equals (Cat.getCatID (cats.get(j)))) 
							{
								System.out.println (cats.get(j));
													
							} // if
						else 
							{
								count++;
							
							} // else
										
					} // for
				
				for (k = 0; k < birds.size (); k++) 
					{
						if (input.equals (Bird.getBirdID (birds.get(k)))) 
							{
								System.out.println (birds.get(k));
																	
							} // if
						
						else 
							{
								count++;
							
							} // else
												
					} // for
				
				if (count == total) 
					{
						System.out.println ("Record not found.");
					
					} // if
				
				/** each of the arrays will then clear themselves of all 
				 *  of their elements, since otherwise the menu will retain the values of the 
				 *  previous call to this method if this method is called again
				 */
				dogs.clear();
				cats.clear();
				birds.clear();
				
				showMenu();
				
				scan3.close();
				
			} // searchById
		
	} // class MenuOptions
