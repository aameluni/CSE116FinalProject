package code;

import java.util.ArrayList;



/**

 * The player method 

 * <p>

 * The player class is containing all the elements that players have

 * and connected to Tile class

 * 

 * @author  Ryan Wong

 * @author  Ziyi Liu

 * @author  Yicheng Teng

 *  

 */
public class Player {
	private boolean _turn;
	private int _magicWands=3;
	private ArrayList<Integer> _token = new ArrayList<Integer>();
	private ArrayList<Integer> _magicCard = new ArrayList<Integer>();
	private int _x;
	private int _y;
	private Tile pTile;
	/**

	 * Player method, this method call another method, assign value to 

	 * two variables, and sent these value to a new class, this method

	 * has an array list and two integer variable

	 * <p>

	 * This method was created for showing the original situation

	 * and position of the pawn/players while the game has started  

	 * on board, because of the players were born with the

	 * magic cards, therefore, it calls the createMagicCard() method

	 * pTile  Associate with the playerTile method

	 * 

	 * @param a    Assign an integer a as the coordinate of the pwan

	 * @param b    Assign an integer b as the coordinate of the pawn

	 */
	public Player(ArrayList<ArrayList<Tile>> t, int a, int b){
		createMagicCard();
		_x=a;
		_y=b;
		pTile= playerTile(t,a,b);
	}
	/**

	 * A method that add integer to the array list, contain 3 variables,return a void type 

	 * <p>

	 * This method is for creating the magic card, at the beginning

	 * of the game, it has 21 cards, and will randomly assign 3 of them

	 * to each player, once the player grab two same cards, put one of 

	 * them back and grab a new one.  

	 * 

	 * @param card   The number on magic cards

	 * @param i      The cards on players' hand, the maximum cards to hold is 3

	 * @param j      Assigned number, if it is same to any one that player has already had, revome it

	 * @return void  Return void  

	 */
	private void createMagicCard() {
		int card=0;
		for(int i=0; i<3;i++)
		{
			card =(int)(Math.random()*21);
			if(card==0)
			{
				card=25;
			}
			for(int j=0; j<_magicCard.size();j++)
			{
				if(card==_magicCard.get(j))
				{	i--;
					_magicCard.remove(j);
				}
			}
			_magicCard.add(card);
		}	
	}
	  /**

     * A method to check a constant, contain one variable. Return a logic type

     * <p>

     * This method is aim for checking legit magic wands to use

     * once there are valid wands, the players will be allowed to use them.

     * 

     * @param _magicWands  The number of magicWands variable, check if it is greater than 0

     * @return <CODE>true</CODE> return true if the  variable match to the situation

     * @return <CODE>true</CODE> return false if the variable doesn't match it

     */
	public boolean usingMagicWands(){
		if(_magicWands > 0){
			_magicWands--;
			_turn = true;
			return true;
		}
		return false;
	}
	/**

	 * This method is about to add an integer to an array list  

	 * <p>

	 * The purpose of this method is to add the token

	 * 

	 * @param i       Add the tokens with integers 

	 * @return void   Return void

	 */
	public void addToken(int i)
	{
		_token.add(i);
	}
	/**

	 * Return an integer, contain integer variables and array list, this method

	 * is about computing an integer variable

	 * <p>

	 * This method is for computing the players' score, once the players move onto

	 * a tile, and their numbers on the magic cards match to the token's, they

	 * will get 20 points, and their total score will be their original score 

	 * plus the extra points from tokens and the magic wands, and then return

	 * this score after finish computing 

	 * 

	 * @param  i            Tokens' numbers for its own, an integer in array list

	 * @param  _magicWands  The number of magic wands, a constant 

	 * @return score        Return a parameter type

	 */
	public int score(){
		int score = 0;
		for(int i=0;i<_token.size();i++){
			if(_magicCard.contains(_token.get(i))){
				score = score +20;
			}
			score = score +_token.get(i);
		}
		score = score + _magicWands*3;
		return score;
	}
	/**

	 * A method return data to Tile class, contain an array list and two integers, this method

	 * is about getting variable data

	 * <p>

	 * This method is going to get the position of players on board, first it check 

	 * if it is still on tiles, then get the players' position

	 * 

	 * @param  x    X-axis coordinate

	 * @param  y    Y-axis coordinate

	 * @return null Return a null if the integers are over the limit of arraylist

	 */
	public Tile playerTile(ArrayList<ArrayList<Tile>> t, int x, int y){
		if(x<t.size() && y<t.get(0).size())
		{	
			return t.get(x).get(y);
		}
		else 
			return null;
	}
	/**

	 *A method return boolean type, which process a logic algorithm

	 *<p>

	 *This method is going to check if the paths/tiles are able to move.

	 *By checking its four direction, the true means the path to next tile 

	 *is legit, false means unable to move

	 *

	 *@return <CODE>true</CODE>   return true if the the container get true

	 *@return <CODE>false</CODE>  return false if the container get false

	 */
	public boolean legitMove(Tile t){
		if(t==null || pTile == null)
			return false;
		else
			if(t.getX()==(pTile.getX()+1) && t.getY()==pTile.getY()){
				if(t.getWest()==true && pTile.getEast()==true)
					return true;
			}
			else
			 if(t.getX()==(pTile.getX()-1)&& t.getY()==pTile.getY())			
				{

					if(t.getEast()==true && pTile.getWest()==true)
						return true;
				}
				else
					 if(t.getX()==pTile.getX() && t.getY()==(pTile.getY()+1))
					 {		
						 if(t.getNorth()==true && pTile.getSouth()==true)
								return true;
					 }
					else
						if(t.getX()==pTile.getX() && t.getY()==(pTile.getY()-1)){
								if(t.getSouth()==true && pTile.getNorth()==true)
									return true;
							}
							return false;
	}
	/**

	 * This method return a variable to all objects

	 * 

	 *  @return _x  An integer witch return to objects and associate with other methods

	 */
	public int getX()
	{
		return _x;
	}
	/**

	 * This method return a variable to all objects

	 * 

	 * @return _y  An integer witch return to objects and associate with other methods

	 */
	public int getY()
	{
		return _y;
	}
	/**

	 * This method is about to get a class for the container

	 */
	public Tile getPtile() {
		// TODO Auto-generated method stub
		return pTile;
	}
	 /**

     * This method is about setting a new pTile 

     * 

     * @param t   Associate with pTile

     */
	public void setTile(Tile t) {
		pTile = t;
	}
}
