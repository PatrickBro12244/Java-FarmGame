//
//KYLE PATRICK ROLAND M. FRANCISCO & JOHN ISAAC J. ZUNIGA
//S24

//Constructor for Crop
//			-crop contains all values related to the crops including their selling and buying price, exp value, and possible yield
//@param name = the crop's name
//@param water = the current water value
//@param waterNeeded = the minimum water value
//@param maxWater = the max possible water 
//@param fertilizer = the current fertilizer value
//@param fertilizerNeeded= the minimum fertilizer value
//@param maxFertilizer = the max possible Fertilizer
//@param type = the Crop type
//@param seedCost = the cost to buy a seed of the crop
//@param harvestTime = the days needed until a crop needs to be harvested
//@param harvestTimeVal = the days neded until a crop needs to be harvested altered to how many days have already passed
//@param maxProduced = the highest yield a crop can give
//@param minProduced = the smallest yield a crop can give
//@param sellPrice = the value of a crop when sold
//@param exp = the exp value of a crop
//@return toString returns the full information of a crop
public class Crop { 
	
	private String name; 
	private int waterNeeded; 
	private int maxWater;
	private int fertilizerNeeded; 
	private int maxFertilizer;
	private String type;
	private int seedCost;
	private int harvestTime;
	private int maxProduced;
	private int minProduced;
	private double sellPrice;
	private double exp;
	public Crop(String name, String type, int harvestTime, int waterNeeded, int maxWater, int fertilizerNeeded, int maxFertilizer, int minProduced , int maxProduced, int sellPrice, int seedCost, double exp) { 
		this.name = name; 
		this.type = type; 
		this.harvestTime = harvestTime;
		this.waterNeeded = waterNeeded; 
		this.maxWater = maxWater;
		this.fertilizerNeeded = fertilizerNeeded; 
		this.maxFertilizer = maxFertilizer;
		this.maxProduced = maxProduced;
		this.minProduced = minProduced;
		this.sellPrice = sellPrice;
		this.seedCost = seedCost;
		this.exp = exp;
	}

	public String getName() { 
		return name; 
	}

	public String getType()
	{
		return type;
	}
	

	public int getWaterNeeded() { 
		return waterNeeded; 
	}
	public int getMaxWater() { 
		return maxWater; 
	}
	
	
	

	public int getFertilizerNeeded() { 
		return fertilizerNeeded; 
	}
	public int getMaxFertilizer() { 
		return maxFertilizer; 
	}
	public int getMaxHarvestYield() {
		return maxProduced;
	}
	public int getMinHarvestYield() {
		return minProduced;
	}
	
	public int getHarvestTime() {
		return harvestTime;
	}
	
	public int getSeedCost() { 
		return seedCost; 
	}
	public double getSellPrice() { 
		return sellPrice; 
	}
	public double getExp() { 
		return exp; 
	}
	@Override
	public String toString() { 
		return name + "\n waterNeeded=" + waterNeeded + "\n" + "\n fertilizerNeeded=" + fertilizerNeeded + "\n HarvestTime =" + harvestTime; 
	}
}
