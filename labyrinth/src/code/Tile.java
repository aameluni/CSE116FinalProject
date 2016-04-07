package code;

import java.util.ArrayList;

import javax.swing.JButton;

/**
 * This tile class was created with several methods to create the individual/specific tiles 
 * which will populate the game board needed to play the Master Labyrinth game. Each specific
 * tile in the Master Labyrinth game contains one of 3 paths: an L path, a T path or a simple 
 * straight path. This  class was created to facilitate the creation of the tiles with their 
 * specific and respective paths/directions which when put together in the Board class will 
 * form a large maze containing various paths. As a result there are methods that facilitate the 
 * creation of the specific paths for the tiles as well as other smaller methods such as accessors
 * and mutators.
 * @author Aamel Unia
 * @author Brandon Ventry

 *
 */

public class Tile {
	/** north is used as a boolean to represent the north direction. */
	private boolean north;
	/** south is used as a boolean to represent the south direction. */
	private boolean south;
	/** east is used as a boolean to represent the east direction. */
	private boolean east;
	/** west is used as a boolean to represent the west direction. */
	private boolean west;
	/** token is used simply to hold an int value for a specific tile  . */
	private int token;
	/** tokens is created as a static ArrayList to hold the values of all 21 tokens . */
	private static ArrayList<Integer> tokens=new ArrayList<Integer>();
	/** path is used as an int to determine which type of path will be created for the tile  . */
	private int path;
	/** random is used as an int to randomly determine the direction of the path which will be created for the tile  . */
	private int random;
	/** x is used simply to be the x coordinate of the tile on the board. */
	private int x=0;
	/** y is used simply to be the y coordinate of the tile on the board. */
	private int y=0;
	
	/**
	 * The constructor of this method initializes the path integer variable to be a random 
	 * number between 0 and 2 which will then be used to create the specific type of path.
	 * For each random number occurrence between 0 and 2, a different specific type of path
	 * will be created. The random integer variable in each specific conditional statement 
	 * is initialized based on how many ways that specific path can be created. The method to 
	 * create the specific type of path is called in each respective conditional statement.
	 */
	public Tile (){
		path =(int)(Math.random()*3);
		if (path==0){
			random =(int)(Math.random()*4);
			createLpath(random);
		}
		if (path==1){
			random =(int)(Math.random()*4);
			createTpath(random);
		}
		if (path==2){
			random =(int)(Math.random()*2);
			createSpath(random);
		}
		
	}
	/**
	 * All four boolean values representing the four directions are set to false as default
	 * to ensure that unless they are changed(set to true), they will be false so as to
	 * avoid the creation of unwanted/illegal paths. Three seperate conditional statements
	 * are created to handle the creation of the three seperate types of paths.
	 * @param i   represents the number of the specific path being created on the tile.
	 */
	public void setPath(int i)
	{
		path = i;
		north =false;
		south =false;
		west =false;
		east =false;
		if (path==0){
			createLpath(random);
		}
		if (path==1){
			createTpath(random);
		}
		if (path==2){
			createSpath(random);
		}
	}
	public void setPath()
	{
		north =false;
		south =false;
		west =false;
		east =false;
		if (path==0){
			createLpath(random);
		}
		if (path==1){
			createTpath(random);
		}
		if (path==2){
			createSpath(random);
		}
	}

	public void setRandom(int i)
	{
		random = i;
	}
	public void setX(int i)
	{
		x=i;
	}
	public void setY(int i)
	{
		y=i;
	}
	
	/**
	 * The four ways in which the LPath tile can be created are set up in this method;
	 * North and West being true, North and East being true, South and West being true, as well as South and East.
	 * @param random   Allows the specific direction of the path to be chosen.
	 * @return Simply returns true if an appropriate path is created successfully.
	 */
	public boolean createLpath(int random){
			if (random==0){
				north=true;
				west=true;
				return true;
				
			}
			if (random==1){
				north=true;
				east=true;	
				return true;
			}
			if (random==2){
				south=true;
				west=true;	
				return true;
			}
			if (random==3){
				south=true;
				east=true;
				return true;
			}
			return false;
		}

	/**
	 * The four ways in which the TPath tile can be created are set up in this method;
	 * North, East and West being true, South West and East being true, 
	 * North South and East being true, as well as North, South and West.
	 * @param random  Allows the specific direction of the path to be chosen.
	 * @return Simply returns true if an appropriate path is created successfully.
	 */
	public boolean createTpath(int random){
		if (random==0){
			north=true;
			east=true;	
			west=true;	
			return true;
		}
		if (random==1){
			south=true;
			west=true;
			east=true;
			return true;
		}
		if (random==2){
			north=true;
			south=true;
			east=true;
			return true;
		}
		if (random==3){
			north=true;
			south=true;
			west=true;
			return true;
		}
		return false;
			
		}
	
	/**
	 * The four ways in which the Straight Path tile can be created are set up in this method;
	 * North and South being true, as well as East and West being true. 
	 * @param random  Allows the specific direction of the path to be chosen.
	 * @return Simply returns true if an appropriate path is created successfully.
	 */
	public boolean createSpath(int random){
		if (random==0 || random==2){
			north=true;
			south=true;	
			return true;
		}
		if (random==1 || random==3){
			west=true;
			east=true;
			return true;
		}
		return false;
	}
	
	public boolean getNorth(){
		return north;
	}
	public boolean getSouth(){
		return south;
	}public boolean getWest(){
		return west;
	}public boolean getEast(){
		return east;
	}
	public int getX()
	{
		return x;
	}
	public int getY(){
		return y;
	}
	
	/**
	 * A for loop is used to generate the integer values for the tokens which are then
	 * added to the Integer ArrayList which will hold all the token values. Because the
	 * tokens have values ranging from 1-20 as well as 25, 25 is added seperately to the
	 * ArrayList outside of the for loop.
	 */
	public void createToken(){
		for (int i=1; i<21; i++){
			tokens.add(i);
		}
		tokens.add(25);
	}
	public int getToken()
	{
		return token;
	}
	
	/**
	 * The value of the token of the tile is set in this method by choosing
	 * a random number from the Integer ArrayList storing all of the token
	 * values. Furthermore, that value is removed from the ArrayList after 
	 * being set to the integer token since no tile can have the same token
	 * value.
	 */
	public void setToken()
	{
		if(!tokens.isEmpty())
			token=tokens.remove((int)(Math.random()*tokens.size()));
	}
	
	/**
	 * 
	 * @return  Returns true as long as the value of the token is not 0.
	 */
	public boolean hasToken(){
		return token!=0;
	}
	
	public void setValueOfToken(int t)
	{
		token=t;
	}

	
	/**
	 * This method is a fairly simply accessor which allows the four players to be accessed
	 * if they are on the specified/desired position.
	 * @param p  Allows for all the players stored in the ArrayList of players to be checked.
	 * @return  Returns true if the player if the player is on the specified/desired position.
	 */
	public Player getPlayer(ArrayList <Player> p)
	{
		for(int i=0;i<p.size();i++)
		{
			if(p.get(i).getX()==x && p.get(i).getY()==y)
				return p.get(i);
		}
		return null;
	}
	
	/**
	 * This is a fairly simply boolean method which will let us know if each of the four 
	 * players on the board is on the specified/desired position.
	 * @param p  Allows for all the players stored in the ArrayList of players to be checked.
	 * @return   Returns true if the player is on the specified/desired position.
	 */
	
	public boolean hasPlayer(ArrayList <Player> p)
	{
		for(int i=0;i<p.size();i++)
		{
			if(p.get(i).getX()==x && p.get(i).getY()==y)
				return true;
		}
		return false;
	}
	public String toString()
	{
		String s ="";
		if(north)
			s+="North \n";
		if(south)
			s+="South \n";
		if(east)
			s+="East \n";
		if(west)
			s+="West \n";
		if(hasToken())
		s+="" +token;
		return s;
	}
	public int getRandom()
	{
		return random;
	}
	
}
	


	

