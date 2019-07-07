import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Cat extends Pets
	{
		public Cat (String identifier, String name, String weight, String owner,
				String gender, String species, String livesInHouse)
			{
				super(identifier, name, weight, owner, gender, species, livesInHouse);
				// TODO Auto-generated constructor stub
			
			} //constructor Cat
		
		/** This method returns the name parameter from a Cat object
		 * 
		 * @param a An object of type Cat
		 * @return The name parameter from a given Cat object
		 */
		public static String getCatName (Cat a) 
			{
				return a.getName();
				
			} // getCatName
		
		/** This method returns the identifier parameter from a Cat object
		 * 
		 * @param a An object of type Cat
		 * @return The ID parameter from a given Cat object
		 */
		
		public static String getCatID (Cat a) 
			{
				return a.getIdentifier();
				
			} // getCatID
		
		/** This method reads a given active patients file and puts the contents
		 * into an arraylist of the given type 
		 * @param a An ArrayList of type Cat
		 */
		public static void catPatients (List <Cat> a) 
			{
				String file = "cats.txt";
				
				try( BufferedReader in = new BufferedReader (new FileReader(file)))
					{
						String str;
						
						// it makes an object of each patient into one each time because of while loop
						while ((str = in.readLine()) != null) 
							{
								String [] values = str.split(",");
								
								a.add (new Cat ( values [0],  values [1], 
												 values [2],  values [3],
										         values [4],  values [5], 
										         values [6]) );
							
							} // while
						
						in.close ();
					
					} //try
 				
				catch (IOException e) 
					{
						System.err.println("The file " + file + " could not be found.");
						System.exit(1);
					
					} // catch
				
			} // catPatients
		
		/** This method returns the number of cat patients 
		 * in the active patients file
		 * @param a An ArrayList of type Cat
		 * @return An integer value that represents the number of cat patients
		 */
		public static int catCount (List <Cat> a) 
			{
				catPatients(a);
				
				return a.size();
				
			} // catCount

		/** This method returns a list of all cat patients 
		 * in the active patients file
		 * @param a An ArrayList of type Cat
		 */
		public static void catList (List <Cat> a) 
			{
				catPatients (a);
				
				for (int i = 0; i < a.size();i++) 
					{
						System.out.println (a.get(i));
						
					} // for
				
				/** the array will then clear itself of its elements, 
				 *  since otherwise the menu will retain the values of the 
				 *  previous call to this method if this method is called again
				 */
				
				a.clear ();
				
				MenuOptions.showMenu();
				
			} // catList
		
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
						+ "\n";
						
			} // toString
	
	} // class Cats
