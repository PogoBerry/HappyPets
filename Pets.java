
public abstract class Pets 
	{
		private  String identifier;
		private  String    name;
		private  String  weight;
		private  String   owner;
		private  String  gender;
		private  String species;
		private  String livesInHouse;
		
		//override this constructor in the subclasses
		public Pets(String identifier, String name, String weight, String owner, String gender, 
				String species, String livesInHouse) 
			{
				this.identifier = identifier;
				this.name = name;
				this.weight = weight;
				this.owner = owner;
				this.gender = gender;
				this.species = species;
				this.livesInHouse = livesInHouse;
				
			} // Pets
		
		/**
		 * @return The identifier
		 */
		public String getIdentifier()
			{
				return identifier;
			}

		/**
		 * @return The name
		 */
		public String getName()
			{
				return name;
			}
		
		/**
		 * @return The weight
		 */
		public String getWeight()
			{
				return weight;
			}

		/**
		 * @return The owner
		 */
		public String getOwner()
			{
				return owner;
			}
		
		/**
		 * @return The gender
		 */
		public String getGender()
			{
				return gender;
			}

		/**
		 * @return The species
		 */
		public String getSpecies()
			{
				return species;
			}
		
		/**
		 * @return The livesInHouse
		 */
		public String getLivesInHouse()
			{
				return livesInHouse;
			}

		/**
		 * @param The identifier to set
		 */
		public void setIdentifier(String identifier)
			{
				this.identifier = identifier;
			
			}

		/**
		 * @param The name to set
		 */
		public void setName(String name)
			{
				this.name = name;
			}

		/**
		 * @param The weight to set
		 */
		public void setWeight(String weight)
			{
				this.weight = weight;
			}

		/**
		 * @param The owner to set
		 */
		public void setOwner(String owner)
			{
				this.owner = owner;
			}

		/**
		 * @param The gender to set
		 */
		public void setGender(String gender)
			{
				this.gender = gender;
			
			} // setGender

		/**
		 * @param The species to set
		 */
		public void setSpecies(String species)
			{
				this.species = species;
			
			} // setSpecies

		/**
		 * @param The livesInHouse to set
		 */
		public void setLivesInHouse(String livesInHouse)
			{
				this.livesInHouse = livesInHouse;
			
			} // setLivesInHouse

		@Override
		public String toString()
			{
				return  "ID: "         + getIdentifier()
				+ "\nName: "           + getName() 
				+ "\nWeight: "         + getWeight() 
				+ "\nOwner: "          + getOwner()
				+ "\nGender: " 	       + getGender() 
				+ "\nSpecies: " 	   + getSpecies()
				+ "\nLives in House: " + getLivesInHouse ();
			
			} //toString

	} // class Pets
