
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.text.DecimalFormat;
//KYLE PATRICK ROLAND M. FRANCISCO & JOHN ISAAC J. ZUNIGA
//S24

//Constructor for Stats
//			-stats contains values relevant to the player character's status and achievements
//@param timesPlanted = total no. of times the player planted
//@param timesPlowed= total no. of times the player plowed
//@param timesWatered = total no. of times the player watered
//@param timesFertilized = total no. of times the player fertilized
//@param timesHarvested= total no. of times the player harvested
//@param timesHarvested successfully= total no. of times the player harvested successfully
//@param currentDay = the current day of the game, default is day 1
//@param objectCoins = the player's wallet, game starts with 100 coins by default
//@param coinChange = the value of coins to be altered from objectCoins
//@param totalExp = the player's total experience points
//@param playerLvl = the player's level, based on their experience points
//@param expChange = the value of exp to be altered from totalExp
//@param inventory[] = an array of the player's seed wallet, the index refers to a crop (i.e. 0 = turnip, 1 = carrot, 2 = potato)
//@param farmerType = the string value of a player's farmer type
//@param farmerTypeint = the int value of a player's farmer type
//@param inventoryCheck = the value of the number of empty slots in a player's seed wallet, a value of 8 means the player does not own any type of seed, while 0 mean the player owns every type of seed.
public class Stats { 

	private int timesPlanted = 0; 
	private int timesPlowed = 0; 
	private int timesWatered = 0; 
	private int timesFertilized = 0; 
	private int timesHarvested = 0; 
	private int timesHarvestedSuccessfully = 0;
	private int totaltilesDug = 0; 
	private int totalRocksMined = 0; 
	private int currentDay = 1;
	private double objectCoins = 1000;
	private double coinChange = 0;
	private double totalExp = 0;
	private double expChange = 0;
	private int playerLvl = 0;
	private int inventory[] = new int[8];
	private String farmerType = "Basic Farmer";
	private int farmerTypeint = 0;
	private static final DecimalFormat Dec = new DecimalFormat("0.00");
	
	
	public int getDay() {
		return currentDay;
	}
	public void changeDay() {
			
			currentDay++;
		}
	public void upgradeFarmer(String farmerType)
	{
		//cannot upgrade past Legendary Farmer
		if(farmerTypeint <= 3)
		{
		farmerTypeint++;
		 this.farmerType = farmerType;
		}
	}

	public int getFarmerTypeint()
	{
		return this.farmerTypeint;
	}
	
	public String getFarmerType()
	{
		return this.farmerType;
	}
	
	public int getPlayerLvl() { 
		// Set level of player based on total Exp
		return this.playerLvl = (int)this.totalExp / 100;
	}

	
	
	public int addToInventory(int index) {
		return inventory[index]++;
	}
	public int subtractFromInventory(int index) {
		return inventory[index]--;
	}
	
	//Reset all stat values;
		public void Reset() {
			
			 this.timesPlanted = 0; 
			 this.timesPlowed = 0; 
			 this.timesWatered = 0; 
			 this.timesFertilized = 0; 
			 this.timesHarvested = 0; 
			 this.timesHarvestedSuccessfully = 0; 
			 this.currentDay = 1;
			 this.objectCoins = 100;
			 this.coinChange = 0;
			 this.totalExp = 0;
			 this.expChange = 0;
			 this.playerLvl = 0;
			 this.farmerType = "Basic Farmer";
			 this.farmerTypeint = 0;
		}
	
	public double getCoins() {
		return this.objectCoins;
	}
	
	public double setCoinChange(double coinChange) {
		return this.coinChange = coinChange;
	}
	
	public double deductCoin(double objectCoins, double coinChange) {
		return this.objectCoins = objectCoins - coinChange;
	};
	public double addCoin(double objectCoins, double coinChange) {
		return this.objectCoins = objectCoins + coinChange;
	};
	public double getExp()
	{
		return this.totalExp;
	}
	public double setExpChange(double expChange) {
		return this.expChange = expChange;
	}
	public double addExp(double totalExp, double expChange)
	{
		return this.totalExp = totalExp + expChange;
	}
	public int addTimesPlowed() { 
		return ++timesPlowed; 
	}
	public int addTimesDug() { 
		return ++totaltilesDug; 
	}
	public int addTimesMined() { 
		return ++totalRocksMined; 
	}
	public int addTimesWatered() { 
		return ++timesWatered; 
	}
	public int addTimesFertilized() { 
		return ++timesFertilized; 
	}
	public int addTimesPlanted() { 
		return ++timesPlanted; 
	}
	public int addTimesHarvested() { 
		return ++timesHarvested; 
	}
	public int addTimesHarvestedSuccessfully() { 
		return ++timesHarvestedSuccessfully; 
	}
	
	
	public String displayStats()
	{
	return "--DAY:"+ currentDay +"--\n\nFARMER TYPE: " + farmerType +"\nPLAYER LEVEL: " + playerLvl + "\n\nTOTAL COINS: " + Dec.format(objectCoins) + "\nEXP: " + totalExp
	+ "\n\n\n\nTimes You Planted:  " + timesPlanted + "\nTimes You Plowed:  " + timesPlowed + "\nTimes You Watered:  " + timesWatered + 
	 "\nTimes You Fertilized:  " + timesFertilized +  "\nTimes You Dug:  " + totaltilesDug + "\nTimes You Mined:  " + totalRocksMined +
	 "\nTimes You Harvested:  " + timesHarvested + "\nTimes You Harvested Successfully:  " + timesHarvestedSuccessfully;
	}
	
}
