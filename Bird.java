import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Bird extends Pets
	{
		private String isFowl;
		private String canFly;
		
		public Bird (String identifier, String name, String weight, String owner,
				String gender, String species, String fly, String fowl)
			{
				super(identifier, name, weight, owner, gender, species, fly);
				
				this.isFowl = fowl;
				this.canFly = fly;
				
			} //constructor Bird
		
		/** This method returns the name parameter from a Bird object
		 * 
		 * @param a An object of type Bird
		 * @return The name parameter from a given Bird object
		 */
		
		public static String getBirdName (Bird a) 
			{
				return a.getName();
				
			} // getBirdName
		
		/** This method returns the identifier parameter from a Bird object
		 * 
		 * @param a An object of type Bird
		 * @return The ID parameter from a given Bird object
		 */
		public static String getBirdID (Bird a) 
			{
				return a.getIdentifier();
				
			} // getBirdID
		
		public String getCanFly () 
			{
				return canFly;
				
			} // getCanfLy
		
		public String getIsFowl()
			{
				return isFowl;
			
			} // getIsFowl

		public void setIsFowl(String isFowl)
			{
				this.isFowl = isFowl;
			
			} // setIsFowl
		
		/**
		 * This method reads a given active patients file and puts the contents
		 * into an arraylist of the given type 
		 * @param a An ArrayList of type Bird
		 */
		public static void birdPatients (List <Bird> a) 
			{
				String file = "birds.txt";
				
				try(BufferedReader in = new BufferedReader (new FileReader(file)))
					{
						String str;
						
						// it makes an object of each patient into one each time because of while loop
						while ((str = in.readLine()) != null) 
							{
								String [] values = str.split(",");
								
								a.add (new Bird (  values [0],  values [1], 
												   values [2],  values [3],
										           values [4],  values [5], 
										           values [6],  values[7]) );
							
							} // while
						
						in.close ();
					
					} //try
 				
				catch (IOException e) 
					{
						System.err.println("The file " + file + " could not be found.");
						System.exit(1);
					
					} // catch
				
			} // birdPatients
		
		/** This method returns the number of all bird patients 
		 *  in the active patients file
		 * @param a An ArrayList of type Bird
		 * @return An integer value of the number of bird patients
		 */
		public static int birdCount (List <Bird> a) 
			{
				birdPatients(a);
				
				return a.size();
				
			} // birdCount
		
		/** This method returns a list of all bird patients 
		 *  in the active patients file
		 * @param a An ArrayList of type Bird
		 */
		public static void birdList (List <Bird> a) 
			{
				birdPatients (a);
				
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
				
			} // birdList
		
		@Override
		public String toString ()
			{
				return  "ID: "            + getIdentifier()
						+ "\nName: "      + getName() 
						+ "\nWeight: "    + getWeight() 
						+ "\nOwner: "     + getOwner()
						+ "\nGender: "    + getGender() 
						+ "\nSpecies: "   + getSpecies()
						+ "\nCan Fly: "   + getCanFly ()
						+ "\nIs a Fowl: " + getIsFowl () + "\n";
						
			} // toString
		
	} // class Bird
