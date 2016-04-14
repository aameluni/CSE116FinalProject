package code;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
/**
 * The Board Class represents the 7 by 7 game board and supervises board movements made by the players
 * and creates and contains all the basis of the board while moderating the player movements and coordinates
 * on the board.
 * 
 * 
 * @author Ziyi Liu
 * @author Ryan Wong
 */
public class Board {
	/**
	 * array list of array list that represents our rows and columns  
	 */
	private ArrayList <ArrayList<Tile>> board = new ArrayList <ArrayList<Tile>> ();
	/**
	 * array list that contains the players that are on the board
	 */
	private ArrayList <Player> player = new ArrayList <Player> ();
	/**
	 * array list of tiles that are not currently on the board
	 */
	private ArrayList<Tile> eTiles = new ArrayList<Tile>();
	/**
	 * constructor creates the extra tile in order to create the 21 tokens
	 * and then populate the board of tiles
	 */
	private UI u;
	private int playerCount=0;
	private int max;
	private int currentToken=1;
	private String[] names;
	private Player currentPlayer;
	private int cpindex;
	public Board(String[] p){
	Tile t=new Tile();
	t.createToken();
	names = p;
	max = names.length;
	playerCount = p.length;
	if(playerCount<2 || playerCount>4)
		throw new IndexOutOfBoundsException();
	populateBoard();
	currentPlayer = player.get(cpindex);
	currentPlayer.toggleTurn();
	eTiles.add(t);
	
}
/**
 * creates a 7 by 7 board of tiles
 * adds tokens to the tiles that are on the inner portion of the board other than the players starting tiles
 * 
 */
	
public void populateBoard(){
	
	for (int x=0; x<7; x++){
		board.add(new ArrayList<Tile>());
		for (int y=0;y<7;y++){
			Tile tile =new Tile ();
			tile.setX(x);
			tile.setY(y);
			if( ( (x>0 && x<6) && (y>0 && y<6) ) && (!checker(x,y)) ){
				tile.setToken();
			}
			board.get(x).add(tile);
			if (checker(x,y) && playerCount>0){
				player.add(new Player(board,x,y,names[max-playerCount]));
				playerCount--;
			}	
		}
	}
}
/**
 * returns true if the x and y coordinates match the starting positions of the players
 * 
 * @param x the column number going from left to right
 * @param y the row number going up and down
 * @return false if the x and y don't match the players coordinates
 */
private boolean checker (int x, int y){
if (x==2&&y==2)	{
	return true;
}
if (x==2&&y==4)	{
	return true;
}
if (x==4&&y==2)	{
	return true;
}
if (x==4&&y==4)	{
	return true;
}
	
return false;	
}


/**
 * checks to see if the requested tile movement is on an odd column or row on the board
 * @param x the column number going from left to right
 * @param y the row number going up and down
 * @return false on any even positions
 */
public boolean tileShifting(int x, int y){
	if(x%2==1 && x>=0 && x<7){
		shiftColumn(x,y);
	//	refresh();
		changeState();
		return true;
	}
	if(y%2==1 && y>=0 && y<7){
		shiftRow(x,y);
		refresh();
		changeState();
		return true;
	}
	return false;
}
/**
 * shifts the tiles by adding the extra tile and taking out one the the end tiles in a column
 * swap, swaps the data between the remove tile and the newly added extra tile
 * @param x represents which column is being shifted
 * @param y represents the direction
 */
private void shiftColumn(int x, int y){
	if(y==-1)
	{	
//		eTiles.get(0).setX(x);
//		eTiles.get(0).setY(0);
		swap(board.get(x).get(6),eTiles.get(0));
		eTiles.add(board.get(x).remove(board.get(x).size()-1));
		board.get(x).add(0,eTiles.remove(0));
		refresh();
		for(int i=0;i<player.size();i++)
		{
			if(player.get(i).getX()==x)
			{	
				player.get(i).setY(player.get(i).getY()+1);
				player.get(i).setTile(board.get(x).get(player.get(i).getY()));
			}
		}
	}
	if(y==7)
	{	
//		eTiles.get(0).setX(x);
//		eTiles.get(0).setY(6);
		swap(board.get(x).get(0),eTiles.get(0));
		eTiles.add(board.get(x).remove(0));
		board.get(x).add(eTiles.remove(0));
		refresh();
		for(int i=0;i<player.size();i++)
		{
			if(player.get(i).getX()==x)
			{
				player.get(i).setY(player.get(i).getY()-1);
				player.get(i).setTile(board.get(x).get(player.get(i).getY()));
			}
		}
	}	
}
/**
 * similar to the shiftColumn however we had to use for loops because each row represents a different
 *array list so its necessary to go one by one to each array list at a specific position  
 * @param x represents which row is being shifted
 * @param y represents the direction
 */
private void shiftRow(int x, int y){
	if(x==-1)
	{			
		for(int i=0;i<board.size();i++)
		{
			eTiles.add(board.get(i).remove(y));
//			eTiles.get(0).setX(i);
//			eTiles.get(0).setY(y);
			board.get(i).add(y,eTiles.remove(0));
		}
		refresh();
		for(int j=0;j<player.size();j++)
		{
			if(player.get(j).getY()==y){
				player.get(j).setX(player.get(j).getX()+1);
				player.get(j).setTile(board.get(player.get(j).getX()).get(y));
				}
		}
		swap(eTiles.get(0),board.get(0).get(y));

	}
	if(x==7)
	{	
		for(int i=board.size()-1;i>=0;i--)
		{
			eTiles.add(board.get(i).remove(y));
//			eTiles.get(0).setX(i);
//			eTiles.get(0).setY(y);
			board.get(i).add(y,eTiles.remove(0));
		}
		refresh();
		for(int i=0;i<player.size();i++)
		{
			if(player.get(i).getY()==y)
				{
				player.get(i).setX(player.get(i).getX()-1);
				player.get(i).setTile(board.get(player.get(i).getX()).get(y));
				
				}
		}
		swap(eTiles.get(0),board.get(6).get(y));
	}
		
}
/**
 * switches the token and player data between two tiles
 * @param tile with the data you want to switch
 * @param tile2 the tile with empty data
 */
private void swap (Tile tile, Tile tile2){
//	while(tile.getPlayer(player) != null)
//	{
//		tile.getPlayer(player).setTile(tile2);
//		System.out.println(getPlayers(tile2));
//	}
	if(tile.hasToken())
	{
		tile2.setValueOfToken(tile.getToken());	
		tile.setValueOfToken(0);
	}
	refresh();
}

	public ArrayList<ArrayList<Tile>> getBoard()
	{
		return board;
	}
	
	public ArrayList<Player> getPlayerList()
	{
		return player;
	}
	public void setObserver(UI ui) {
		u=ui;
	}
	public void changeState(){
		if(u!=null)
			u.update();
	}
	public Tile getExtra()
	{
		return eTiles.get(0);
	}
	public void playerPickup()
	{
		if(currentPlayer.getPtile().hasToken() && currentPlayer.getPtile().getToken()==currentToken)
		{
			currentPlayer.addToken(currentToken);
			currentPlayer.getPtile().setValueOfToken(0);
			currentToken++;
			if(currentToken>20 && currentToken<25)
				currentToken=25;
		}
			
	}
	public String getPlayers(Tile t)
	{
		String s ="";
		int count = 0;
		while(count<max)
		{
			if(t.hasPlayer(player) && player.get(count).getPtile()==t)
		{
			s += "" + player.get(count).getName();
		}
			count++;
		}
		return s;
	}
	public void rotatePlayerTurn()
	{
		player.get(cpindex).toggleTurn();
		cpindex++;
		if(cpindex==max)
			cpindex=0;
		player.get(cpindex).toggleTurn();
		currentPlayer = player.get(cpindex);

		System.out.println(currentPlayer.getName());
		
	}
	public Player getCP()
	{
		return currentPlayer;
	}

	public void refresh(){
		for(int x=0;x<board.size();x++)
		{
			for(int y=0;y<board.get(x).size();y++)
			{
				board.get(x).get(y).setX(x);
				board.get(x).get(y).setY(y);
			}
		}
//		eTiles.get(0).setX(7);
//		eTiles.get(0).setY(7);
	}
	public String gameEnd()
	{
		Player winner = player.get(0);
		for(int i = 1 ; i <player.size();i++)
		{
			if(player.get(i).score()>winner.score())
			{
				winner = player.get(i);
			}
		}
		String name = winner.getName();
		System.out.println(name + " Wins!");
		return name + " Wins!";
	}
	public String checkGameState()
	{
		if(currentToken>25)
			return gameEnd();
		else
			return currentPlayer.getName() + "'s Score:" + currentPlayer.score();
	}
}

