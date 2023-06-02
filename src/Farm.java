import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections; 
//KYLE PATRICK ROLAND M. FRANCISCO & JOHN ISAAC J. ZUNIGA
//S24

//Constructor for Farm()
//  -Farm represents the 5x10 array of tiles.
//@param tileList = the arraylist which holds all 50 tiles
//@param doneGenerating = a bool representing whether the rocks have been successfully generated or not
//@param doneGenerating = a bool whether the file input of the user was valid

public class Farm {

	
	public final List<Tile> tileList = new ArrayList<Tile>(Arrays.asList(
			
	));
	public boolean doneGenerating = false;
	public boolean invalid = false;
	
	//THIS FUNCTION IS RESPONSIBLE FOR GENERATING ROCKS OVER THE TILES
	public void generateRocks(int mode)
		{
		
			//MODE1 IS ROCKS LOADED FROM A FILE
			if(mode == 1)
			{
				int[] rockIndex = readFile("rocks.txt");
				
				if(rockIndex.length >= 10 && rockIndex.length<= 30)
				{
					for (int i = 0; i < rockIndex.length; i++) { 
						
			        	tileList.get(rockIndex[i] - 1).addRock();
			            System.out.println("Tile " + (rockIndex[i]) + " has a rock"); 
			        }
					doneGenerating = true;
				}
				else
				{
					invalid = true;
					 generateRocks(2);
				}
	
			}
			
	
			//MODE2 IS RANDOMLY GENERATED ROCKS
			else if(mode == 2)
			{
				int i;
				int rockNum;
				int index;
				Random r = new Random();
				rockNum = r.nextInt(30 - 10) + 10;		
				
			  ArrayList<Integer> list = new ArrayList<Integer>(); 
		        for (i = 0; i <= 49; i++) { 
		            list.add(i); 
		        } 
		        Collections.shuffle(list); 
		        for (i = 0; i < rockNum; i++) { 
		        	index = list.get(i);
		        	tileList.get(index).addRock();
		            System.out.println("Tile " + (index+1) + " has a rock"); 
		        }
		        doneGenerating = true;
			}
		
		}
	public int[] readFile(String file)
	{
		
		try
		{
			File rockSettings = new File(file);
			Scanner scan = new Scanner(rockSettings);
			int j = 0;
					
			while(scan.hasNextInt())
			{
				j++;
				scan.nextInt();
			}
			
			int[] rockIndexArr = new int[j];
			
			Scanner scan2 = new Scanner(rockSettings);
			
			for(int i = 0; i<rockIndexArr.length; i++)
			{
				rockIndexArr[i] = scan2.nextInt();
			}
			return rockIndexArr;
		}
		catch(Exception e) {
			return null;
		}
		
	}
	public void generateTiles()
	{
		
		for (int i=0; i<=49; i++) {
			tileList.add(new Tile());
		}
	}
	public void resetilles()
	{
		for  (int i=0; i<=49; i++)
		{
			tileList.get(i).resetTile();
		}
	}
	
	public Boolean checkFreeSpace(int index, Crop Crop)
	{
		if(Crop.getType().equals("Fruit Tree"))
		{
			//Cannot plant in row 1
			if(index <5)
			{
				return false;
			}
			//Cannot plant in row 10
			if(index >44)
			{
				return false;
			}
			//Cannot plant in column 1
			if((index+1)%5==1)
			{
				return false;
			}
			//Cannot plant in column 5
			if((index+1)%5==0)
			{
				return false;
		
			}
			//Cannot plant to immediate Right
			if(tileList.get(index+1).getPlantedCrop() != null)
				{
					return false;
				}
			//Cannot plant to immediate Left
			if(tileList.get(index-1).getPlantedCrop() != null)
			{
				return false;
			}
			//Cannot plant below
			if(tileList.get(index+5).getPlantedCrop() != null)
			{
				return false;
			}
			//Cannot plant above
			if(tileList.get(index-5).getPlantedCrop() != null)
			{
				return false;
			}
			//Cannot plant bottom-left
			if(tileList.get(index+4).getPlantedCrop() != null)
			{
				return false;
			}
			//Cannot plant top-right
			if(tileList.get(index-4).getPlantedCrop() != null)
			{
				return false;
			}
			//cannot plant bottom-right
			if(tileList.get(index+6).getPlantedCrop() != null)
			{
				return false;
			}
			//cannot plant top-left
			if(tileList.get(index-6).getPlantedCrop() != null)
			{
				return false;
			}
		
			 
			
			else
				return true;
			
		}
		
			return true;
		
		
	}
}