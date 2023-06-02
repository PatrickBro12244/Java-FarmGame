import java.util.Random;
import java.text.DecimalFormat;
//KYLE PATRICK ROLAND M. FRANCISCO & JOHN ISAAC J. ZUNIGA
//S24

//Constructor for tile()
//			-tile represents the tile that the player interacts with to plant, water, fertilize, plow, and harvest crops.
//@param plantedCrop = this is the type of crop picked by the user
//@param isPlowed = a bool representing whether the tile has been plowed
//@param isWithered = a bool representing whether a crop has withered
//@param addExp = the value of exp to be added to the totalEXP after a successful harvest
//@param addCoins = the value of coins to be added to the objectCoins after a successful harvest
//@param harvestVal = an int that represents a random number picked between the min and max harvest yield of a crop
//@param harvestBonus = the bonus yield a player gets depending on their farmerType
//@param tileWater = the current water on the tile
//@param tileFertilizer = the current Fertilizer on the tile
//@param tileHarvestTime = the time until the crop on the tile needs to be harvested
//@param Dec = the format of which objectcoins should be represented
public class Tile {

	private boolean hasRock;
	private Crop plantedCrop = null;
	private boolean isPlowed = false;
	private boolean isWithered = false;
    private double addExp = 0;
    private double addCoins = 0;
    private int harvestVal = 0;
    private int harvestBonus = 0;
    private int tileWater;
    private int tileFertilizer;
    private int tileHarvestTime;
    private static final DecimalFormat Dec = new DecimalFormat("0.00");
  
/*
	public void witherCrop() {
		isWithered = true;
		plantedCrop = null;
	}
	
	public boolean checkWither() {
		return isWithered;
	}
	*/
    
//	Report Plantseed()
//	    - This Method is responsible for the seed planting action. It may return a fail or success state
//	    		@param seed - this is the seed type picked by the user
//				@param plantedCrop - this is the type of crop picked by the user
//	    		@param isPlowed - a bool representing whether the tile has been plowed
	public Report plantSeed(Crop seed , Boolean space) {
		
		if(hasRock)
		{
		
			return new Report(false, "There is a rock on this tile");
		}
		if(isWithered)
		{
			return new Report(false, "There is a withered crop on this tile");
		}
		
		if(seed == null)
		{
		
			return new Report(false, "No seed picked!");
		}
		
		if(plantedCrop != null)
		{
			
			return new Report(false, "A crop has already been planted there!");
		}
	
		if(!isPlowed)
		{
		
			return new Report(false, "The tile is not yet plowed!");
		}
		if(!space)
		{
		
			return new Report(false, "You do not have space to plant a tree there!");
		}
		
		
		plantedCrop = seed;
		tileWater = 0;
		tileFertilizer = 0;
		tileHarvestTime = plantedCrop.getHarvestTime();
		return new Report(true, "Successfulyl planted seed!");
	}
		
		
		
	
//	Report plow()
//    - This Method is responsible for the plowing action. It may return a fail or success state
//    		@param plantedCrop - this is the type of crop picked by the user
//		@param isPlowed - a bool representing whether the tile has been plowed
//	    @param isWithered - a bool representing whether the tile has a Withered Crop
//    
	public Report plow() {
		
		if(hasRock)
		{
		
			return new Report(false, "There is a rock on this tile");
		}
		if(isWithered)
		{
			return new Report(false, "There is a withered crop on this tile");
		}
		if(isPlowed)
		{
			return new Report(false, "The tile has already been plowed!");
		}
	
		if(plantedCrop != null)
		{
			return new Report(false, "There is already a crop planted there!");
		}
		
		
		isPlowed = true;
		
		return new Report(true, "Successfully plowed tile!");
	}
		
//	Report water()
//  - This Method is responsible for the crop watering action. It may return a fail or success state
//  		@param plantedCrop - this is the type of crop picked by the user
//			@param wMax - This is the maxWater value of the crop, it is changed depending on the Player's farmer type
//  		@param fType - This is the int value of the farmer type of the player, (0- farmer, 1- registered farmer, 2 - distinguished farmer, 3 - legendary farmer)
	public Report water(int fType) {
		
		if(plantedCrop == null)
		{
			return new Report(false, "There is no Crop planted!");
		}
		if(isWithered)
		{
			return new Report(false, "This crop is withered!");
		}
		int wMax = plantedCrop.getMaxWater();
		//Check farmer type for Water bonus
		if (fType == 2)
		{
			wMax += 1;
		}
		if (fType == 3)
		{
			wMax += 2;
		}
		if(tileWater == wMax)
		{
			return new Report(false, "You cannot water further!");
		}

			tileWater++;
		
		return new Report(true, "Successfully watered Crop");
		
	}
//	Report mine()
//  - This Method is responsible for the rock mining action, an action used to remove rocks from tiles
//  		@param hasRock - a bool to represent if the tile contains a rock
//			
	public Report mine() {
		
		if(!hasRock)
		{
		
			return new Report(false, "There is no rock on this tile");
		}
		
		hasRock = false;
		return new Report(true, "Successfully Mined Rock on this tile!");
	}
//	Report dig()
//  - This Method is responsible for the digging action, whether there is a withered crop on it or not, it will remove the current
//		crop and unplow the tile
//  		@param isPlowed - a bool to represent if the tile has been plowed
//			@param isWithered - a bool representing whether the tile has a Withered Crop
//       	@param plantedCrop - this is the type of crop picked by the user
public Report dig() {
		isPlowed = false;
		if(!isWithered)
		{
			plantedCrop = null;
			isWithered = false;
			return new Report(false, "There was no withered crop, \nYou cleared the tile");
		}
		plantedCrop = null;
		isWithered = false;
		return new Report(true, "Successfully removed withered crop on this tile!");
	}
//	Report fertilize()
//  - This Method is responsible for the crop fertilizing action. It may return a fail or success state
//  		@param plantedCrop - this is the type of crop picked by the user
//			@param fMax - This is the maxFertilizer value of the crop, it is changed depending on the Player's farmer type
//  		@param fType - This is the int value of the farmer type of the player, (0- farmer, 1- registered farmer, 2 - distinguished farmer, 3 - legendary farmer)
	public Report fertilize(int fType) {
		
		if(plantedCrop == null)
		{
			return new Report(false, "There is no Crop planted!");
		}
		if(isWithered)
		{
			return new Report(false, "This crop is withered!");
		}
		
		int fMax = plantedCrop.getMaxFertilizer();
		//Check farmer type for Fertilizer bonus
		if (fType == 3)
		{
			fMax += 1;
		}
		if(tileFertilizer == fMax)
		{
			return new Report(false, "You cannot Fertilize further!");
		}
		
			tileFertilizer++;
		
		
		return new Report(true, "Successfully fertilized crop!");
	}
//	Report harvest()
//  - This Method is the harvest method, it returns a success or fail and the many initial harvest price, water bonus, fertilizer bonus, final harvest price, and exp gain of the player
//  		@param plantedCrop - this is the type of crop picked by the user
//			@param isPlowed - a bool representing whether the tile has been plowed
//			@param fMax - This is the maxFertilizer value of the crop, it is changed depending on the Player's farmer type
//  		@param fType - This is the int value of the farmer type of the player, (0- farmer, 1- registered farmer, 2 - distinguished farmer, 3 - legendary farmer)
//			@param harvestTimeVal - this is the harvest time of the crop, adjusted by the number of days that have passed since the crop was planted
//          @param harvestVal - this is a random number picked between the max and min harvest of a crop
	public Report harvest(int fType) {
		//fail if no crop planted
		String hReport;
		if(plantedCrop == null)
		{
			isPlowed = false;
			return new Report(false, "There is no crop to harvest!");
		}
		//fail if late harvest
		if(tileHarvestTime < 0)
		{
			
			return new Report(false, "The crop is now withered!");
		}
		//fail if premature harvest
		if(tileHarvestTime > 0)
		{
			addWither();
			return new Report(false, "The crop has not yet sprouted!");
		}
		//fail if both watering and fertilizer are insufficient
		if(tileWater < plantedCrop.getWaterNeeded() && tileFertilizer < plantedCrop.getFertilizerNeeded())
		{
			
			addWither();
			return new Report(false, "The Crop was not fully watered nor fertilized");

		}
		// Fail if crop.fertilizer < crop.fertilizerNeeded 
		else if(tileFertilizer < plantedCrop.getFertilizerNeeded())
		{
			
			addWither();
			return new Report(false, "The Crop was not yet fully fertilized");
			
		}
		// Fail if crop.water < crop.waterNeeded 
		else if(tileWater < plantedCrop.getWaterNeeded())
		{
			addWither();
			return new Report(false, "The Crop was not yet fully watered");
		}
		//Check the Farmer Type to add respective bonus harvest point
			if(fType == 1)
			{
				 harvestBonus = 1;
			}
			if(fType == 2)
			{
				 harvestBonus = 2;
			}
			if(fType == 3)
			{
				 harvestBonus = 4;
			}
		
				
			//random yield
			if(plantedCrop.getMinHarvestYield() != plantedCrop.getMaxHarvestYield())
			{
			Random r = new Random();
		    harvestVal = r.nextInt(plantedCrop.getMaxHarvestYield() - plantedCrop.getMinHarvestYield()) + plantedCrop.getMinHarvestYield();
			}
			else
			{
				harvestVal = plantedCrop.getMaxHarvestYield();
			}
		    harvestVal += harvestBonus;
		    double totalHarvest = plantedCrop.getSellPrice() * harvestVal; //INITIAL HARVEST
		    double waterBonus = totalHarvest * 0.2 * (tileWater-1); // WATER BONUS
		    double fertilizerBonus = totalHarvest * 0.5 * (tileFertilizer); // FERTILIZERBONUS
		    double FinalharvestVal = totalHarvest + waterBonus + fertilizerBonus; //FINAL VALUE
		    if(plantedCrop.getType().equals("Flower"))
		    {
		    	FinalharvestVal *= 1.1;
		    }
		    hReport = "\nYou harvested " +harvestVal+ " " + plantedCrop + " !" + "\nYour initial Harvest Price is " + totalHarvest + " !"+"\nYour Water Bonus is " + Dec.format(waterBonus) + " !"+"\nYour Fertilizer Bonus is " +  Dec.format(fertilizerBonus) + " !"
		    		+"\nYour total Harvest Price is " + FinalharvestVal + " !";
		   
			addExp = plantedCrop.getExp() * harvestVal;
			addCoins = FinalharvestVal;
			plantedCrop = null;
			isPlowed = false;
		
		return new Report(true, "\nSuccesfully harvested the Crop!\n" + hReport);
	}

	public Crop getPlantedCrop() { 
		return plantedCrop; 
	}
	
	public void deductTileHarvestTime() { 
		 this.tileHarvestTime--; 
	}
	public int getTileHarvestTime() { 
		 return tileHarvestTime; 
	}

	public double getExpAdd()
	{
		return this.addExp;
	}
	public double getCoinAdd()
	{
		return this.addCoins;
	}
	public void addRock()
	{
		this.hasRock = true;
	}
	public void addWither()
	{
		this.isWithered = true;
	}
	public boolean getPlowed()
	{
		return this.isPlowed;
	}
	public boolean getRock()
	{
		return this.hasRock;
	}
	public int getWaterStatus()
	{
		int i;
		
		i = tileWater - plantedCrop.getWaterNeeded();
				return i;
	}
	public int getFertilizerStatus()
	{
		int i;
		
		i = tileFertilizer - plantedCrop.getFertilizerNeeded();
				return i;
	}
	public boolean getIsWithered()
	{
		return this.isWithered;
	}
	  public void resetTile()
	    {
		  		this.isWithered = false;
	    	 this.isPlowed = false;
	    	 this.plantedCrop = null;
	    	 this.tileHarvestTime = 0;
	    	 this.tileFertilizer = 0;
	    	 this.tileWater = 0;
	    	 this.hasRock = false;
	    	 
	    }
	public String CroptoString() { 
		String state = "";
		
		if(isWithered)
		{
			state = "Withered ";
		}
		
		return "\n\nCurrent Crop: " + state + plantedCrop + "\n\n\nWater: " + tileWater + "\nFertilizer: " + tileFertilizer + "\n Days until harvest: " + tileHarvestTime; 
	}
}