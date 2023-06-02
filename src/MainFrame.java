

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Object;

//GUI CLASS
//KYLE PATRICK ROLAND M. FRANCISCO & JOHN ISAAC J. ZUNIGA
//S24

public class MainFrame{
	
	//MAIN WINDOW
	private JFrame mainFrame; 
    private JTextArea infoText;
    private JTextArea statText;
    //ROCK WINDOW
    private JFrame rockFrame;
    private JTextArea rockText;
    private ArrayList<JButton> tileList = new ArrayList<JButton>();
  
    //Game function buttons
    private JButton newGame;
    private JButton checkStore;
    private JButton upgradeFarmer;
    //Rock Option Buttons
    private JButton Rock1;
    private JButton Rock2;
    //Tool Buttons
    private JButton plowTile;
    private JButton waterTile;
    private JButton fertilizeTile;
    private JButton digTile;
    private JButton mineTile;
    private JButton harvestTile;
    //Farming function Buttons
    private JButton nextDay;
    private JButton plantTurnip;
    private JButton plantCarrot;
    private JButton plantPotato;
    private JButton plantRose;
    private JButton plantTulips;
    private JButton plantSunflower;
    private JButton plantMango;
    private JButton plantApple;
	public MainFrame() {
		this.mainFrame = new JFrame("My Farm");

		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.mainFrame.setLayout(new FlowLayout());
		this.mainFrame.setSize(1000, 850);
		this.rockFrame = new JFrame("Rock Settings");
		this.rockFrame.setLayout(new FlowLayout());
		this.rockFrame.setSize(500, 200);
		
		this.showInfoPane();
		this.showTileButtons();
		this.showStatsPane();
		this.showMenuButtons();
		
		this.showRockFrame();
		this.mainFrame.setVisible(true);
		this.rockFrame.setVisible(true);
		
	}
	
	
	//TILE BUTTONS
	private void showTileButtons() {

		JPanel tileButtons = new JPanel();
		tileButtons.setLayout(new GridLayout(10, 5));
		
		for(int i = 1; i < 51; i++) {
			this.tileList.add(new JButton(Integer.toString(i)));
		}

		for(JButton btn : this.tileList) {
			btn.setPreferredSize(new Dimension(75, 55));
			tileButtons.add(btn);
		}
		this.mainFrame.add(tileButtons);
	}
	private void showStatsPane()
	{
		JPanel statsPane = new JPanel();
		statsPane.setLayout(new GridLayout(1, 1));
		statText = new JTextArea(30, 20);
		statText.setEditable(false);
		statText.setText("STATS:");
		statsPane.add(statText);
		
		
		 Color c = new Color(224, 224,224);
		 statText.setBackground(c);
		this.mainFrame.add(statsPane);
		
	}
	//INFORMATION PANE
	private void showInfoPane()
	{
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(1, 1));
		infoText = new JTextArea(30, 20);
		infoText.setEditable(false);
		infoText.setText("GAME INFO:");
		contentPane.add(infoText);
		this.mainFrame.add(contentPane);
		
	}
	//MENU BUTTONS
	private void showMenuButtons() {
		JPanel menuButtons = new JPanel();

		menuButtons.setLayout(new GridLayout(1, 4));

		JPanel menuButtons1 = new JPanel();
		menuButtons1.setLayout(new GridLayout(8, 1));

		JPanel menuButtons2 = new JPanel();
		menuButtons2.setLayout(new GridLayout(9, 1));

		JPanel menuButtons3 = new JPanel();
		menuButtons3.setLayout(new GridLayout(8, 1));

		//action buttons
		this.nextDay = new JButton("Next Day");
		this.upgradeFarmer = new JButton("Upgrade Farmer");
		this.checkStore = new JButton("Store");
		this.newGame = new JButton("START NEW GAME");

		this.plowTile = new JButton("Plow");
		this.waterTile = new JButton("Water");
		this.fertilizeTile = new JButton("Fertilize");
		this.digTile = new JButton("Dig");
		this.mineTile = new JButton("Mine Rock");
		
		this.harvestTile = new JButton("Harvest");

		this.plantTurnip = new JButton("Plant Turnip");
		this.plantCarrot = new JButton("Plant Carrot");
		this.plantPotato = new JButton("Plant Potato");

		this.plantRose = new JButton("Plant Rose");
		this.plantTulips = new JButton("Plant Tulips");
		this.plantSunflower = new JButton("Plant Sunflower");

		this.plantMango = new JButton("Plant Mango");
		this.plantApple = new JButton("Plant Apple");


		menuButtons1.add(plowTile);
		menuButtons1.add(harvestTile);
		menuButtons1.add(waterTile);
		menuButtons1.add(digTile);
		menuButtons1.add(mineTile);
		menuButtons1.add(fertilizeTile);
		
		menuButtons2.add(nextDay);
		menuButtons2.add(upgradeFarmer);
		menuButtons2.add(checkStore);
		menuButtons2.add(newGame);
		
		menuButtons3.add(plantTurnip);
		menuButtons3.add(plantCarrot);
		menuButtons3.add(plantPotato);

		menuButtons3.add(plantRose);
		menuButtons3.add(plantTulips);
		menuButtons3.add(plantSunflower);

		menuButtons3.add(plantMango);
		menuButtons3.add(plantApple);

		
		//menuButtons3.add(newGame);

		menuButtons.add(menuButtons1);
		menuButtons.add(menuButtons2);
		menuButtons.add(menuButtons3);
		

		this.mainFrame.add(menuButtons);
	}
	

	
//TILE BUTTONS
	public void setTileListener (ActionListener actionListener) {
		for(JButton button : this.tileList) {
			button.addActionListener(actionListener);
		}
	}
	
	public int getTileIndex (Object tile) {
		return this.tileList.indexOf(tile);
		
	}
	
	public void tileClicked(int Index, String info) {
		this.infoText.setText("TILE: " + (Index+1) + info);
		
		
	}
	public void setTileColor(int i, int tileIndex) {
		

	switch(i) {
	case 0:
			this.tileList.get(tileIndex).setBackground(new Color(235,200,149)); //LIGHT BROWN unplowed dirt
			break;
	case 1:
			this.tileList.get(tileIndex).setBackground(new Color(142, 84, 51)); //DARK BROWN plowed dirt
			break;
	case 2:
			this.tileList.get(tileIndex).setBackground(Color.gray);// Gray Rock
			break;
	case 3:
			this.tileList.get(tileIndex).setBackground(new Color(204, 255, 204)); //FADED LIGHT GREEN Premature Root Crop
			break;
	case 31:
		this.tileList.get(tileIndex).setBackground(new Color(255, 204, 229)); //FADED PINK Premature Flower
		break;
	case 32:
		this.tileList.get(tileIndex).setBackground(new Color(147, 154, 103)); //FADED DARK GREEN Premature Tree
		break;
	case 4:
			this.tileList.get(tileIndex).setBackground(new Color(0, 255, 0)); //LIGHT GREEN NOURISHED Root Crop
			break;
	case 41:
		this.tileList.get(tileIndex).setBackground(new Color(255, 102, 178)); //PINK NOURISHED Flower 
		break;
	case 42:
		this.tileList.get(tileIndex).setBackground(new Color(0, 102, 0)); // DARK GREEN NOURISHED Tree
		break;
	case 5:
		this.tileList.get(tileIndex).setBackground(new Color(178, 102, 255)); // PURPLE Super Nourished Crop
		break;
	case 6:
		this.tileList.get(tileIndex).setBackground(new Color(255, 153, 51)); // ORANGE Withered Crop
			break;
	}
	}

	//UPDATE TEXT PANELS

	public void updateStats(String Stat) {
		
		statText.setText(Stat);
		
	}
	
public void updateInfoTile(int index, String info) {
		
		infoText.setText("TILE:" + (index+1) + "\n" + info);
		
	}
public void updateInfo(String info) {
	
	infoText.setText(info);
	
}

//ROCK SETTINGS FRAME
	public void showRockFrame()
	{
		JPanel rockSettings = new JPanel();
		rockSettings.setLayout(new GridLayout(1, 1));
		rockText = new JTextArea(2, 2);
		rockText.setEditable(false);
		rockText.setText("Which Setting for Rock generation would you like?");
		rockSettings.add(rockText);
		JPanel rockButtons = new JPanel();
		rockButtons.setLayout(new GridLayout(1, 1));
		this.Rock1 = new JButton("Load File");
		this.Rock2 = new JButton("Randomly Generated");
		rockButtons.add(Rock1);
		rockButtons.add(Rock2);
		this.rockFrame.add(rockSettings);
		this.rockFrame.add(rockButtons);
		//if the player doesn't pick a setting, close the whole program.
		this.rockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	//FUNCTION TO HIDE THE ROCK SETTINGS FRAME (AFTER PLAYER HAS ANSWERED)
	public void removeRockFrame()
	{	
		this.rockFrame.setVisible(false);
	}
//MENU BUTTONS
	public void setToolMenuListeners(ActionListener listener)
	{
		   this.newGame.addActionListener(listener);
		   this.checkStore.addActionListener(listener);
		   this. upgradeFarmer.addActionListener(listener);
		   this.plowTile.addActionListener(listener);
		   this.waterTile.addActionListener(listener);
		   this.fertilizeTile.addActionListener(listener);
		   this.digTile.addActionListener(listener);
		   this.mineTile.addActionListener(listener);
		   this.harvestTile.addActionListener(listener);
		   this.nextDay.addActionListener(listener);
		   this.plantTurnip.addActionListener(listener);
		   this.plantCarrot.addActionListener(listener);
		   this.plantPotato.addActionListener(listener);
		   this.plantRose.addActionListener(listener);
		   this.plantTulips.addActionListener(listener);
		   this.plantSunflower.addActionListener(listener);
		   this.plantMango.addActionListener(listener);
		   this.plantApple.addActionListener(listener);
		   this.Rock1.addActionListener(listener);
		   this.Rock2.addActionListener(listener);
	}
	
	//GETTERS FOR MAINFRAME BUTTONS
	public JButton getRock1()
	{
		return Rock1;
	}
	public JButton getRock2()
	{
		return Rock2;
	}
	public JButton getPlantTurnip()
	{
		return plantTurnip;
	}
	public JButton getPlantCarrot()
	{
		return plantCarrot;
	}
	public JButton getPlantPotato()
	{
		return plantPotato;
	}
	public JButton getPlantRose()
	{
		return plantRose;
	}
	public JButton getPlantTulips()
	{
		return plantTulips;
	}
	public JButton getPlantSunflower()
	{
		return plantSunflower;
	}
	public JButton getPlantMango()
	{
		return plantMango;
	}
	public JButton getPlantApple()
	{
		return plantApple;
	}
	public JButton getNewGame()
	{
		return newGame;
	}
	
	public JButton getCheckStore()
	{
		return checkStore;
	}
	public JButton getUpgradeFarmer()
	{
		return upgradeFarmer;
	}
	public JButton getHarvestTile()
	{
		return harvestTile;
	}
	public JButton getWaterTile()
	{
		return waterTile;
	}
	public JButton getFertilizeTile()
	{
		return fertilizeTile;
	}
	public JButton getNextDay()
	{
		return nextDay;
	}
	public JButton getPlowTile()
	{
		return plowTile;
	}
	
	public JButton getMineTile()
	{
		return mineTile;
	}
	public JButton getDigTile()
	{
		return digTile;
	}
	
	//DISABLES ALL OF THE BUTTONS
	public void disableAllButtons()
	{
		for(int i = 0; i < 50; i++)
		{
			this.tileList.get(i).setEnabled(false);
		}
		
		 
		   this.checkStore.setEnabled(false);
		   this. upgradeFarmer.setEnabled(false);
		   this.plowTile.setEnabled(false);
		   this.waterTile.setEnabled(false);
		   this.fertilizeTile.setEnabled(false);
		   this.digTile.setEnabled(false);
		   this.mineTile.setEnabled(false);
		   this.harvestTile.setEnabled(false);
		   this.nextDay.setEnabled(false);
		   this.plantTurnip.setEnabled(false);
		   this.plantCarrot.setEnabled(false);
		   this.plantPotato.setEnabled(false);
		   this.plantRose.setEnabled(false);
		   this.plantTulips.setEnabled(false);
		   this.plantSunflower.setEnabled(false);
		   this.plantMango.setEnabled(false);
		   this.plantApple.setEnabled(false);
		  this.newGame.setEnabled(false);
	}
	
	//DISABLES ALL BUTTONS EXCEPT FOR TILE AND NEWGAME BUTTONS
	public void disableButtons()
	{

		   this.checkStore.setEnabled(false);
		   this. upgradeFarmer.setEnabled(false);
		   this.plowTile.setEnabled(false);
		   this.waterTile.setEnabled(false);
		   this.fertilizeTile.setEnabled(false);
		   this.digTile.setEnabled(false);
		   this.mineTile.setEnabled(false);
		   this.harvestTile.setEnabled(false);
		   this.nextDay.setEnabled(false);
		   this.plantTurnip.setEnabled(false);
		   this.plantCarrot.setEnabled(false);
		   this.plantPotato.setEnabled(false);
		   this.plantRose.setEnabled(false);
		   this.plantTulips.setEnabled(false);
		   this.plantSunflower.setEnabled(false);
		   this.plantMango.setEnabled(false);
		   this.plantApple.setEnabled(false);
		  this.newGame.setEnabled(true);
	}
	//ENABLES ALL BUTTONS
	public void enableButtons()
	{
	
		for(int i = 0; i < 50; i++)
		{
			this.tileList.get(i).setEnabled(true);
		}
		
		  this.newGame.setEnabled(true);
		   this.checkStore.setEnabled(true);
		   this. upgradeFarmer.setEnabled(true);
		   this.plowTile.setEnabled(true);
		   this.waterTile.setEnabled(true);
		   this.fertilizeTile.setEnabled(true);
		   this.digTile.setEnabled(true);
		   this.mineTile.setEnabled(true);
		   this.harvestTile.setEnabled(true);
		   this.nextDay.setEnabled(true);
		   this.plantTurnip.setEnabled(true);
		   this.plantCarrot.setEnabled(true);
		   this.plantPotato.setEnabled(true);
		   this.plantRose.setEnabled(true);
		   this.plantTulips.setEnabled(true);
		   this.plantSunflower.setEnabled(true);
		   this.plantMango.setEnabled(true);
		   this.plantApple.setEnabled(true);
		  this.newGame.setEnabled(true);
	}
}




