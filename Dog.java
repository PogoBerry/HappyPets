import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Dog extends Pets
	{
		private String isWorking;
		
		public Dog(String identifier, String name, String weight, String owner,
				String gender, String species, String livesInHouse, 
				String isWorking)
			{
				super(identifier, name, weight, owner, gender, species, livesInHouse);
				
				this.isWorking = isWorking;
			
			} // constructor Dog
		
		/** This method returns the name parameter from a Dog object
		 * 
		 * @param a An object of type Dog
		 * @return The name parameter from a given Dog obejct
		 */
		public static String getDogName (Dog a) 
			{
				return a.getName();
				
			} // getDogName
		
		/** This method returns the name parameter from a Dog object
		 * 
		 * @param a An object of type Dog
		 * @return The name parameter from a given Dog object
		 */
		public static String getDogID(Dog a)
			{
				return a.getIdentifier ();
			
			} // getDogID
		
		public String getIsWorking()
			{
				return isWorking;
			
			} // getIsWorking

		public void setIsWorking(String isWorking)
			{
				this.isWorking = isWorking;
			
			} // setIsWorking
		
		/**
		 * This method reads a given active patients file and puts the contents
		 * into an arraylist of the given type 
		 * @param a An ArrayList of type Dog
		 */
		public static void dogPatients (List <Dog> a) 
			{
				String file = "dogs.txt";
				
				try(BufferedReader in = new BufferedReader (new FileReader(file)))
					{
						String str;
						
						while ((str = in.readLine()) != null) 
							{
								String [] values = str.split(",");
								
								a.add (new Dog ( values [0],  values [1], 
												 values [2],  values [3],
										         values [4],  values [5], 
										         values [6],  values [7]) );
								
							} // while
						
						in.close ();
					
					} //try
 				
				catch (IOException e) 
					{
						System.err.println("The file " + file + " could not be found.");
						System.exit(1);
						
					} // catch
				
			} // dogPatients

		/** This method returns the number of dog patients in the active patients file
		 * @param a An ArrayList of type Dog
		 * @return An integer value of the number of dog patients
		 */
		public static int dogCount (List <Dog> a) 
			{
				dogPatients(a);
				
				return a.size();
			
			} // dogCount
		
		/** This method returns A list of all dog patients
		 * in the active patients file
		 * @param a An ArrayList of type Dog
		 */
		public static void dogList (List <Dog> a) 
			{
				dogPatients (a);
				
				for (int i = 0; i < a.size();i++) 
					{
						System.out.println (a.get(i));
						
					} // for
				
				/** the array will then clear itself of its elements, 
				 *  since otherwise the menu will retain the values of the 
				 *  previous call to this method if this method is called again
				 */
				
				a.clear();
				
				MenuOptions.showMenu();
				
			} // dogList
		
		@Override
		public String toString ()
			{
				return  "ID: "          + getIdentifier()
						+ "\nName: "    + getName() 
						+ "\nWeight: "  + getWeight() 
						+ "\nOwner: "   + getOwner()
						+ "\nGender: "  + getGender() 
						+ "\nSpecies: " + getSpecies()
						+ "\nLives in the House: " + getLivesInHouse ()
						+ "\nIs Working: " + isWorking + "\n";
						
			} // toString
		
	} // class Dog
