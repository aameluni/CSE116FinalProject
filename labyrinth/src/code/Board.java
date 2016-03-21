package code;

import java.util.ArrayList;

public class Board {
	private ArrayList <ArrayList<Tile>> board = new ArrayList <ArrayList<Tile>> ();
	private ArrayList <Player> player = new ArrayList <Player> ();
	private ArrayList<Tile> eTiles = new ArrayList<Tile>();
	public Board(){
	Tile t=new Tile();
	t.createToken();
	populateBoard();
	eTiles.add(t);
}

public void populateBoard(){
	for (int x=0; x<7; x++){
		board.add(new ArrayList<Tile>());
		for (int y=0;y<7;y++){
			Tile tile =new Tile ();
			if( ( (x>0 && x<6) && (y>0 && y<6) ) && (!checker(x,y)) ){
				tile.setToken();
				tile.setX(x);
				tile.setY(y);
			}
			if (checker(x,y)){
				player.add(new Player(board,x,y));
			}	
		board.get(x).add(tile);
		System.out.println(tile.getToken());
		}
	}
}

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



private boolean tileShifting(int x, int y){
	if(x%2==1){
		shiftColumn(x,y);
		return true;
	}
	if(y%2==1){
		shiftRow(x,y);	
		return true;
	}
	
	
	return false;
}

private void shiftColumn(int x, int y){
	if(y==-1)
	{	
		swap(board.get(x).get(y+1),eTiles.get(0));
		eTiles.add(board.get(x).remove(board.get(x).size()-1));
		board.get(x).add(0,eTiles.get(0));
	}
	if(y==7)
	{	
		swap(board.get(x).get(y-1),eTiles.get(0));
		eTiles.add(board.get(x).remove(0));
		board.get(x).add(eTiles.get(0));
	}	
}

private void shiftRow(int x, int y){
	if(x==-1)
	{	
		swap(board.get(0).get(y),eTiles.get(0));
		for(int i=0;i<board.size();i++)
		{
			eTiles.add(board.get(i).remove(y));
			board.get(i).add(y,eTiles.get(0));
		}
//		eTiles.add(board.get(y).remove(board.get(y).size()-1));
//		board.get(y).add(0,eTiles.get(0));
	}
	if(x==7)
	{	
		swap(board.get(x-1).get(y),eTiles.get(0));
		for(int i=board.size()-1;i>=0;i--)
		{
			eTiles.add(board.get(i).remove(y));
			board.get(i).add(y,eTiles.get(0));
		}
//		eTiles.add(board.get(y).remove(0));
//		board.get(y).add(eTiles.get(0));
	}	
}

private void swap (Tile tile, Tile tile2){
	while(tile.hasPlayer(player) != null)
	{
		tile.hasPlayer(player).setTile(tile2);
	}
	if(tile.hasToken())
	{
		tile2.setValueOfToken(tile.getToken());
	}
}
}

