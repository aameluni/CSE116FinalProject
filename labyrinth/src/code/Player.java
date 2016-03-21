package code;

import java.util.ArrayList;

public class Player {
	private boolean _turn;
	private int _magicWands=3;
	private ArrayList<Integer> _token = new ArrayList<Integer>();
	private ArrayList<Integer> _magicCard = new ArrayList<Integer>();
	private int _x;
	private int _y;
	private Tile pTile;
	
	public Player(ArrayList<ArrayList<Tile>> t, int a, int b){
		createMagicCard();
		_x=a;
		_y=b;
		pTile= playerTile(t,a,b);
	}

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
	public boolean usingMagicWands(){
		if(_magicWands > 0){
			_magicWands--;
			_turn = true;
			return true;
		}
		return false;
	}
	public void addToken(int i)
	{
		_token.add(i);
	}
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
	public Tile playerTile(ArrayList<ArrayList<Tile>> t, int x, int y){
		if(x<t.size() && y<t.get(0).size())
		{	
			return t.get(x).get(y);
		}
		else 
			return null;
	}
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
	
	public int getX()
	{
		return _x;
	}
	public int getY()
	{
		return _y;
	}

	public Tile getPtile() {
		// TODO Auto-generated method stub
		return pTile;
	}
	public void setTile(Tile t) {
		pTile = t;
	}
}
