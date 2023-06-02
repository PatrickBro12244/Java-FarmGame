

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
//KYLE PATRICK ROLAND M. FRANCISCO & JOHN ISAAC J. ZUNIGA
//S24

////Constructor for Application
//				-Application is the menu where players can input their desired action
//@param isRunning = a boolean that represents whether the game is running or not, a false value will end the program
//@param stats = the stats class
//@param tile = the tile class
//@param index2 = the index used to select from the seedlsit
//@ param seedlist = the list of available crops, containing all their information
//@ param rockSetting = the rock generate type the player selected
public class Application {
	
	// Input
	public static final Scanner input = new Scanner(System.in);

	// Global state
	public static boolean isRunning = true;
	public static boolean gameOver = false;
	
	public static final Stats stats = new Stats();
	public static final Tile tile = new Tile();
	public static final Farm Farm = new Farm();
	public static int index2;
	public static int rockSetting = 0;
	
	
	public static final List<Crop> seedList = new ArrayList<Crop>(Arrays.asList(
			 //Name,type,harvestTime ,WaterNeeded, MaxWater, FertilizerNeeded, MaxFertilizer minProduced, maxProduced ,SellPrice, seedCost, exp
			new Crop("Turnip", "Root Crop",2, 1, 2, 0, 1, 1, 2, 6, 5, 500), //5
			  new Crop("Carrot","Root Crop",3, 1,2, 0, 1, 1, 2, 9, 10, 7.5),
			 new Crop("Potato", "Root Crop",5, 3,4, 1, 2, 1, 10, 3, 20, 12.5),
			   new Crop("Rose", "Flower",1, 1, 2, 0, 1, 1, 1, 5, 5, 2.5),
			    new Crop("Tulips","Flower",2, 2, 3, 0, 1, 1, 1, 9, 10, 5),
			  new Crop("Sunflower","Flower",3, 2, 3, 1, 2, 1, 1, 19, 20, 7.5),
			 new Crop("Mango Tree","Fruit Tree",10, 7, 7, 4, 4, 5, 15, 8, 200, 25),
			 new Crop("Apple Tree","Fruit Tree",10, 7, 7, 5, 5, 10, 15, 5, 200, 25)
	));
	

	public static void main(String[] args) {
		
		//GENERATE THE TILES AND DISPLAY UI
		Farm.generateTiles();
		MainFrame mainFrame = new MainFrame();
		MainInput mainInput = new MainInput(mainFrame);
		mainInput.GamePause();
		
			
		while (isRunning) {
			
		//PLAYER MUST SELECT A ROCK SETTING BEFORE PROCEEDING
		if(!Farm.doneGenerating)
		{
			rockSetting = mainInput.hasAnswered();
			
			Farm.generateRocks(rockSetting);
			
			if (Farm.invalid)
			{
				mainInput.setInfo("INVALID SET OF INDEXES\n Rocks were randomly generated instead");
			}
		}
			
		//UPDATE PLAYER STATS, TILE STATUS, AND CHECK FOR GAMEOVER CONDITIONS
			mainInput.setStats(stats.displayStats());
			mainInput.updateTileStatus(Farm);
			checkConditions();
			
			//GAME OVER STATE
			if(gameOver)
			{
				mainInput.GameOver();
			}
		}
		
		
	}
	
	
		
		//METHOD FOR PLANTING TURNIPS
		public static String playerPlantTurnip(int tileIndex)
		{
			String plantReport;
			if(playerPay(seedList.get(0).getSeedCost()))
			{
					var seed = seedList.get(0);		
					plantReport = Farm.tileList.get(tileIndex).plantSeed(seed, Farm.checkFreeSpace((tileIndex), seedList.get(0))).toString();
							
					
					stats.addTimesPlanted();
					return plantReport;		
			}
			else		
			plantReport = "Insufficient funds";
			return plantReport;
		}
			
		//METHOD FOR PLANTING CARROTS
		public static String playerPlantCarrot(int tileIndex)
		{
			String plantReport;
			if(playerPay(seedList.get(1).getSeedCost()))
			{
					var seed = seedList.get(1);		
					plantReport = Farm.tileList.get(tileIndex).plantSeed(seed, Farm.checkFreeSpace((tileIndex), seedList.get(1))).toString();
					
		
					
					stats.addTimesPlanted();
					return plantReport;
					
			}
			else
				
			plantReport = "Insufficient funds";
			return plantReport;
		}
		
		
		//METHOD FOR PLANTING POTATOES
		public static String playerPlantPotato(int tileIndex)
		{
			String plantReport;
			if(playerPay(seedList.get(2).getSeedCost()))
			{
					var seed = seedList.get(2);		
					plantReport = Farm.tileList.get(tileIndex).plantSeed(seed, Farm.checkFreeSpace((tileIndex), seedList.get(2))).toString();
					
					
					
					stats.addTimesPlanted();
					return plantReport;
					
			}
			else
				
			plantReport = "Insufficient funds";
			return plantReport;
		}
		
		
		//METHOD FOR PLANTING ROSES
		public static String playerPlantRose(int tileIndex)
		{
			String plantReport;
			if(playerPay(seedList.get(3).getSeedCost()))
			{
					var seed = seedList.get(3);		
					plantReport = Farm.tileList.get(tileIndex).plantSeed(seed, Farm.checkFreeSpace((tileIndex), seedList.get(3))).toString();
					
					
					
					stats.addTimesPlanted();
					return plantReport;
					
			}
			else
				
			plantReport = "Insufficient funds";
			return plantReport;
		}
		
		//METHOD FOR PLANTING TULIPS
		public static String playerPlantTulip(int tileIndex)
		{
			String plantReport;
			if(playerPay(seedList.get(4).getSeedCost()))
			{
					var seed = seedList.get(4);		
					plantReport = Farm.tileList.get(tileIndex).plantSeed(seed, Farm.checkFreeSpace((tileIndex), seedList.get(4))).toString();
					
					
					
					stats.addTimesPlanted();
					return plantReport;
					
			}
			else
				
			plantReport = "Insufficient funds";
			return plantReport;
		}
		
		//METHOD FOR PLANTING SUNFLOWER
		public static String playerPlantSunflower(int tileIndex)
		{
			String plantReport;
			if(playerPay(seedList.get(5).getSeedCost()))
			{
					var seed = seedList.get(5);		
					plantReport = Farm.tileList.get(tileIndex).plantSeed(seed, Farm.checkFreeSpace((tileIndex), seedList.get(5))).toString();
					
					
					
					stats.addTimesPlanted();
					return plantReport;
					
			}
			else
				
			plantReport = "Insufficient funds";
			return plantReport;
		}
		 
		//METHOD FOR PLANTING MANGO TREE
		public static String playerPlantMango(int tileIndex)
		{
			String plantReport;
			if(playerPay(seedList.get(6).getSeedCost()))
			{
					var seed = seedList.get(6);		
					plantReport = Farm.tileList.get(tileIndex).plantSeed(seed, Farm.checkFreeSpace((tileIndex), seedList.get(6))).toString();
					
					
					
					stats.addTimesPlanted();
					return plantReport;
					
			}
			else
				
			plantReport = "Insufficient funds";
			return plantReport;
		}
		
//METHOD FOR PLANTING APPLE TREE
		public static String playerPlantApple(int tileIndex)
		{
			String plantReport;
			if(playerPay(seedList.get(7).getSeedCost()))
			{
					var seed = seedList.get(7);		
					plantReport = Farm.tileList.get(tileIndex).plantSeed(seed, Farm.checkFreeSpace((tileIndex), seedList.get(7))).toString();
					
					
					
					stats.addTimesPlanted();
					return plantReport;
					
			}
			else
				
			plantReport = "Insufficient funds";
			return plantReport;
		}
//METHOD TO ADVANCE THE DAY
		public static void playerAdvDay()
		{
	
			nextDay();
		}
		
//METHOD FOR BUYING SEEDS 
		public static boolean playerPay(int seedCost)
		{
		
			
			if(stats.getCoins() >= (seedCost - stats.getFarmerTypeint()))
			{
			stats.setCoinChange(stats.getCoins() - stats.getFarmerTypeint());
			stats.deductCoin(stats.getCoins(), (seedCost -  stats.getFarmerTypeint()));
			return true;
			//ADD TO INVENTORY
			}
			else
				System.out.println("Insufficient Coins!");
			
			return false;
			
		}
//PLOW METHOD
		public static String playerPlow(int tileIndex)
		{
			
			var tIndex = tileIndex;
			String PlowResult =Farm.tileList.get(tIndex).plow().toString();
			System.out.println(PlowResult);
			if(PlowResult.contains("true"))
			{
			stats.addExp(stats.getExp(), 0.5);
			stats.addTimesPlowed();
			}
			return PlowResult;
		}
			
			
//WATER METHOD		
		public static String playerWater(int tileIndex)
		{
			
			var tIndex2 = tileIndex;
			String  waterResult = Farm.tileList.get(tIndex2).water(stats.getFarmerTypeint()).toString();
			
			//ADD TO CROP WATER
			
			//System.out.println("Current Water:"+" " + Farm.tileList.get(tIndex2).getPlantedCrop().getWater());
			//ADD EXP FROM WATERING
			if(waterResult.contains("true"))
			{
			stats.addExp(stats.getExp(), 0.5);
			stats.addTimesWatered();
			}
		
			return waterResult;
			
			
		}
//USE PICKAXE METHOD			
		public static String playerMine(int tileIndex)
		{
			
			var tIndexM = tileIndex;
			
			if(stats.getCoins() >= 50)
			{
				String  MineResult = Farm.tileList.get(tIndexM).mine().toString();
			if(MineResult.contains("true"))
			{
			stats.addExp(stats.getExp(), 15);
			stats.deductCoin(stats.getCoins(), 50);
			stats.addTimesMined();
			}
			return MineResult;
			}
			else
				return "Insufficient Funds";
		}
		
//USE SHOVEL METHOD		
		public static String playerDig(int tileIndex)
		{
		

			var tIndexR = tileIndex;
			
			if(stats.getCoins() >= 7)
			{
				String  DigResult = Farm.tileList.get(tIndexR).dig().toString();
			stats.deductCoin(stats.getCoins(), 7);
			
			if(DigResult.contains("true"))
			{
			stats.addExp(stats.getExp(), 2);
			
			}
			stats.addTimesDug();
			return DigResult;
			}
			else
				return "Insufficient Funds";
			
		}
		
// FERTILIZE METHOD
		public static String playerFertilize(int tileIndex)
		{
			
			var tIndex3 = tileIndex;
			String fertilizeResult = Farm.tileList.get(tIndex3).fertilize(stats.getFarmerTypeint()).toString();
			System.out.println();
			//FERTILIZER COST IS 10 COINS
			if(fertilizeResult.contains("true"))
			{
				if(stats.getCoins() >=  10)
				{
				stats.deductCoin(stats.getCoins(), 10);
				//ADD EXP FROM FERTILIZING
				stats.addExp(stats.getExp(), 4);
				stats.addTimesFertilized();
				}
				else
					return"You cannot afford to fertilize!";
			}
			return fertilizeResult;
			
		  }
			
		
	//HARVEST METHOD
		public static String playerHarvest(int tileIndex)
		{		
			var tIndex4 = tileIndex;
			String harvestResult = Farm.tileList.get(tIndex4).harvest(stats.getFarmerTypeint()).toString();
			
			stats.addTimesHarvested();
			
			if(harvestResult.contains("true"))
			{
			stats.addTimesHarvestedSuccessfully();
			stats.addCoin(stats.getCoins(), Farm.tileList.get(tIndex4).getCoinAdd());
			stats.addExp(stats.getExp(), Farm.tileList.get(tIndex4).getExpAdd());
			stats.getPlayerLvl();
			}
			
			return harvestResult;
			
			}
		
		//UPGRADE FARMER METHOD
		public static String playerUpgrade()
		{
			String result = " ";
			switch(stats.getFarmerTypeint())
			{
			 case 0: 
			
				if(stats.getPlayerLvl() >= 5 && stats.getCoins() >= 200)
				{
			
					stats.upgradeFarmer("Registered Farmer");
					stats.deductCoin(stats.getCoins(), 200);
					result = "You successfully upgraded to Registered Farmer";
				}
				else
					result = "You need to be Player Level 5 and pay 200 coins to upgrade!";
			
				
			 break;  
			 case 1:
				 if(stats.getPlayerLvl() >= 10 && stats.getCoins() >= 300)
					{
						stats.upgradeFarmer("Distinguished Farmer");
						stats.deductCoin(stats.getCoins(), 300);
						result = "You successfully upgraded to Distinguished Farmer";
					}
					else
						result ="You need to be Player Level 10 and pay 300 coins to upgrade!";
				 break;  
			 case 2: 
				 if(stats.getPlayerLvl() >= 15 && stats.getCoins() >= 400)
					{
						
						stats.upgradeFarmer("Legendary Farmer");
						stats.deductCoin(stats.getCoins(), 400);
						result = "You successfully upgraded to Legendary Farmer";
					}
					else
						result = "You need to be Player Level 15 and pay 400 coins to upgrade!";
				 break;  
			 case 3: 
				 result = "You cannot upgrade further!";
				 break;  
			 default:stats.upgradeFarmer("farmer");
			}
			return result;
		}
			
		public static String getCropInfo(int index)
		{
			 return Farm.tileList.get(index).CroptoString();
		}
	
	
	public static void checkConditions() {
		int nCount = 0;
		for(int i = 0; i <= 49; i++) {

		 
		// END THE GAME IF NO SEEDS, NO ACTIVE CROPS, NO MONEY TO BUY NEW SEEDS, (turnips have the lowest seed cost)      (farmer type is accounted for)
			if(Farm.tileList.get(i).getPlantedCrop() != null && !Farm.tileList.get(i).getIsWithered())
			{				
				nCount++;
			}
		}
		
		if(nCount < 1 && stats.getCoins() < seedList.get(0).getSeedCost() - stats.getFarmerTypeint())
			gameOver = true;;
		    
		
	}
		
	//METHOD TO ADVANCE TO NEXT DAY
	public static int nextDay() {
		stats.changeDay();
		
		for(int i = 49; i >= 0; i--)
		{
		if(Farm.tileList.get(i).getPlantedCrop() != null)
		{
			Farm.tileList.get(i).deductTileHarvestTime();
			System.out.println("Crop #" + (i+1) + "|| Days until Harvest Time: " + Farm.tileList.get(i).getTileHarvestTime());
		}
		if(Farm.tileList.get(i).getTileHarvestTime() < 0)
		{
			Farm.tileList.get(i).addWither();
		}
		}
		return stats.getDay();

		
	}
	
	//METHOD TO SHOW THE PRICES OF EACH SEED IN THE STORE
public static String ShowPrices() {
		
		String specialM;
		
		if(stats.getFarmerTypeint() > 0)
		specialM = "\nSPECIAL DISCOUNT FOR:\n" + stats.getFarmerType() + "!\n" +  Integer.toString(stats.getFarmerTypeint()) + " coin/s off on all seeds!!!\n\n" ;
		else
			specialM = "";
		 
		return specialM + "SEED PRICES: \nTURNIP :" + Integer.toString(seedList.get(0).getSeedCost() -  stats.getFarmerTypeint()) + "\nCARROT :" + Integer.toString(seedList.get(1).getSeedCost() -   stats.getFarmerTypeint())
				+ "\nPOTATO :" + Integer.toString(seedList.get(2).getSeedCost() -  stats.getFarmerTypeint()) + "\nROSE :" + Integer.toString(seedList.get(3).getSeedCost() -   stats.getFarmerTypeint())
				+ "\nTULIPS :" + Integer.toString(seedList.get(4).getSeedCost() -  stats.getFarmerTypeint()) + "\nSUNFLOWER :" + Integer.toString(seedList.get(5).getSeedCost() -  stats.getFarmerTypeint())
				+ "\nMANGO :" + Integer.toString(seedList.get(6).getSeedCost() - stats.getFarmerTypeint())+ "\nAPPLE :" + Integer.toString(seedList.get(7).getSeedCost() - stats.getFarmerTypeint());
	}
	
//METHOD TO RESET GAME
public static void Reset() 
{
	 Farm.resetilles();
	 Farm.generateRocks(rockSetting);
	 stats.Reset();
	 gameOver = false;
	
	 
	
}
}
