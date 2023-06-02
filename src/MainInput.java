import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
//KYLE PATRICK ROLAND M. FRANCISCO & JOHN ISAAC J. ZUNIGA
//S24


//CONTROLLER CLASS
public class MainInput {

	private MainFrame mainFrame;
	private int tileIndex = 0;
	private int rockAns = 0;
	
	
	
	
	
	
	public MainInput(MainFrame frame) {
		mainFrame = frame;
	

		
		frame.setTileListener(new ActionListener () {
		public void actionPerformed(ActionEvent e) {

			tileIndex = frame.getTileIndex(e.getSource());
			
			updateTileClicked();
			
		}
	});
		
	//FUNCTION TO SET FUNCTIONS OF ALL BUTTONS
		frame.setToolMenuListeners(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == mainFrame.getRock1())
				{
					setAns(1);
					mainFrame.enableButtons();
					mainFrame.removeRockFrame();
				}
				if(e.getSource() == mainFrame.getRock2())
				{
					setAns(2);
					mainFrame.enableButtons();
					mainFrame.removeRockFrame();
				}
				
				if(e.getSource() == mainFrame.getPlantTurnip())
				{
					mainFrame.updateInfoTile(tileIndex, Application.playerPlantTurnip(tileIndex));
				}
				if(e.getSource() == mainFrame.getPlantCarrot())
				{
					mainFrame.updateInfoTile(tileIndex, Application.playerPlantCarrot(tileIndex));
				}
				if(e.getSource() == mainFrame.getPlantPotato())
				{
					mainFrame.updateInfoTile(tileIndex, Application.playerPlantPotato(tileIndex));
				}
				if(e.getSource() == mainFrame.getPlantRose())
				{
					mainFrame.updateInfoTile(tileIndex, Application.playerPlantRose(tileIndex));
				}
				if(e.getSource() == mainFrame.getPlantTulips())
				{
					mainFrame.updateInfoTile(tileIndex, Application.playerPlantTulip(tileIndex));
				}
				if(e.getSource() == mainFrame.getPlantSunflower())
				{
					mainFrame.updateInfoTile(tileIndex, Application.playerPlantSunflower(tileIndex));
				}
				if(e.getSource() == mainFrame.getPlantMango())
				{
					mainFrame.updateInfoTile(tileIndex, Application.playerPlantMango(tileIndex));
				}
				if(e.getSource() == mainFrame.getPlantApple())
				{
					mainFrame.updateInfoTile(tileIndex, Application.playerPlantApple(tileIndex));
				}
				if(e.getSource() == mainFrame.getNextDay())
				{
					
					mainFrame.updateInfo("DAY ADVANCED! \n\n IT IS DAY: " + Integer.toString(Application.nextDay()));
				}
				
				if(e.getSource() == mainFrame.getPlowTile())
				{
					mainFrame.updateInfoTile(tileIndex, Application.playerPlow(tileIndex));
				}
				if(e.getSource() == mainFrame.getDigTile())
				{
					mainFrame.updateInfoTile(tileIndex, Application.playerDig(tileIndex));
				}
				if(e.getSource() == mainFrame.getMineTile())
				{
					mainFrame.updateInfoTile(tileIndex, Application.playerMine(tileIndex));
				}
				if(e.getSource() == mainFrame.getWaterTile())
				{
					mainFrame.updateInfoTile(tileIndex, Application.playerWater(tileIndex));
				}
				if(e.getSource() == mainFrame.getFertilizeTile())
				{
					mainFrame.updateInfoTile(tileIndex, Application.playerFertilize(tileIndex));
				}
				
				if(e.getSource() == mainFrame.getHarvestTile())
				{
					mainFrame.updateInfoTile(tileIndex, Application.playerHarvest(tileIndex));
				}
				if(e.getSource() == mainFrame.getUpgradeFarmer())
				{
					mainFrame.updateInfoTile(tileIndex, Application.playerUpgrade());
				}
				if(e.getSource() == mainFrame.getCheckStore())
				{
					mainFrame.updateInfo(Application.ShowPrices());
				}
				if(e.getSource() == mainFrame.getNewGame())
				{

					Application.Reset();
					mainFrame.enableButtons();
					
				}
				//updateText();
			}
		});

	}
	
	//FUNCTION TO UPDATE WHICH TILE THE PLAYER HAS CLICKED
	public void updateTileClicked()
	{
		mainFrame.tileClicked(tileIndex, Application.getCropInfo(tileIndex));
	}
	
	//FUNCTION TO GET THE CROP DATA OF THE TILE
	public void getTileInfo()
	{
		mainFrame.tileClicked(tileIndex, Application.getCropInfo(tileIndex));
	}
	
	
	//UPDATES THE TILES COLOR BASED ON THEIR STATUS
	public void updateTileStatus(Farm farm)
	{
		for(int i = 0; i < 50; i++)
		{
			if(farm.tileList.get(i).getPlantedCrop() == null)
			{
				if(farm.tileList.get(i).getRock())
				{
					mainFrame.setTileColor(2, i);
				}
				else if(farm.tileList.get(i).getPlowed())
				{
					mainFrame.setTileColor(1, i);
				}
				else
				{
					mainFrame.setTileColor(0, i);
				}
			}
			else
			{
				if(farm.tileList.get(i).getIsWithered())
				{
					mainFrame.setTileColor(6, i);
				}
				else if(farm.tileList.get(i).getTileHarvestTime() == 0 && farm.tileList.get(i).getWaterStatus() > 0 && farm.tileList.get(i).getFertilizerStatus() > 0)
				{
					mainFrame.setTileColor(5, i);
				}
				else if(farm.tileList.get(i).getTileHarvestTime() == 0 && farm.tileList.get(i).getWaterStatus() >= 0 && farm.tileList.get(i).getFertilizerStatus() >= 0)
				{
					if(farm.tileList.get(i).getPlantedCrop().getType() == "Root Crop") // DIFFERENT CROP TYPES HAVE DIFFERENT COLORS (NOURISHED)
					mainFrame.setTileColor(4, i);
					else if(farm.tileList.get(i).getPlantedCrop().getType() == "Flower")
						mainFrame.setTileColor(41, i);
					else if(farm.tileList.get(i).getPlantedCrop().getType() == "Fruit Tree")
						mainFrame.setTileColor(42, i);
				}
				
				else
				{
					if(farm.tileList.get(i).getPlantedCrop().getType() == "Root Crop") // DIFFERENT CROP TYPES HAVE DIFFERENT COLORS (IMMATURE)
					mainFrame.setTileColor(3, i);
					else if(farm.tileList.get(i).getPlantedCrop().getType() == "Flower")
					mainFrame.setTileColor(31, i);
					else if(farm.tileList.get(i).getPlantedCrop().getType() == "Fruit Tree")
						mainFrame.setTileColor(32, i);
				}
			}
		}
	}
	//DISABLES ALL BUTTONS EXCEPT THE NEWGAME AND TILE BUTTONS FROM THE PLAYER (FOR GAME OVERS)
	public void GameOver()
	{
	
			mainFrame.disableButtons();
		
	}
	//DISABLES ALL BUTTONS FROM THE PLAYER (FOR START OF GAME WHEN PLAYER HAS NOT YET PICEKD ROCKSETTING)
	public void GamePause()
	{
			mainFrame.disableAllButtons();
	}
	
	//SETTER FOR PLAYER'S ROCKSETTING CHOICE
	public void setAns(int ans)
	{
	
			this.rockAns = ans;
	}
	
	//RETURNS THE PLAYER'S ROCKSETTINGS CHOICE
	public int hasAnswered()
	{
			return(rockAns);
	}
	
	//DISPLAYS THE STATS ON RIGHT PANEL
	public void setStats(String stats)
	{
	
		mainFrame.updateStats(stats);
	}
	//SETS TEXT ON INFO PANE
	public void setInfo(String info)
	{
	
		mainFrame.updateInfo(info);
	}
	
	
}
