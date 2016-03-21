package code;

import java.util.ArrayList;

public class Tile {
	
	private boolean north;
	private boolean south;
	private boolean east;
	private boolean west;
	private int token;
	private static ArrayList<Integer> tokens=new ArrayList<Integer>();
	private int path;
	private int random;
	private int x=0;
	private int y=0;
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
	
	public boolean createSpath(int random){
		if (random==0){
			north=true;
			south=true;	
			return true;
		}
		if (random==1){
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
	
	public void setToken()
	{
		if(!tokens.isEmpty())
			token=tokens.remove((int)(Math.random()*tokens.size()));
	}
	public boolean hasToken(){
		return token!=0;
	}
	public void setValueOfToken(int t)
	{
		token=t;
	}

	public Player hasPlayer(ArrayList <Player> p)
	{
		for(int i=0;i<p.size();i++)
		{
			if(p.get(i).getX()==x && p.get(i).getY()==y)
				return p.get(i);
		}
		return null;
	}
}
	
//h

	

