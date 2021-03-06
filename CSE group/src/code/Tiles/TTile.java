package code.Tiles;


/**
 * Class creates a tile of the T type. It is a child class of the Tile class. T type is a tile laid out
 * similar to a T in structure.
 * @author Wiechec
 *
 */
public class TTile  extends Tiles{
	
	/**
	 * @author Wiechec
	 * @param orientation allows the tile to be constructed with a specific orientation layout
	 * at the time of creation.
	 */
	public TTile(String orientation){
		this.Rotate(orientation);
	}
	/**@author Wiechec
	 * Default constructor. Creates a copy of the tile, but the orientation of the tile is defaulted to 
	 * NORTH direction
	 */
	public TTile(){
		this.Rotate("North");
	}
	public TTile(int i)
	{
		Rotation("T"+i);
	}

	/**
	 * @author Wiechec
	 * Method rotates the tile into one of the indicated orientations. The indicated open values
	 * are the direction this tile will allow movements.
	 * NORTH: NORTH AND WEST AND EAST ARE OPEN
	 * EAST:NORTH AND SOUTH AND EAST ARE OPEN
	 * SOUTH:EAST AND WEST AND SOUTH ARE OPEN
	 * WEST:WEST AND NORTH AND SOUTH ARE OPEN
	 */
	
	public void Rotate(String direction){
		this._rotation = direction;
		switch (direction){
		case "North": 
			this._north = true;
			this._east = true;
			this._west = true;
			this._south = false;
			this.sName = "T2";
			break;
		case "South":
			this._north = false;
			this._east = true;
			this._west = true;
			this._south = true;
			this.sName = "T0";
			break;
		case "East":
			this._north = true;
			this._east = true;
			this._west = false;
			this._south = true;
			this.sName = "T3";
			break;
		case "West":
			this._north = true;
			this._east = false;
			this._west = true;
			this._south = true;
			this.sName = "T1";
			break;
		}
	}
	public void Rotation(String tx)
	{
		if(tx.equals("T0"))
		{
			Rotate("South");
		}
		if(tx.equals("T1"))
		{
			Rotate("West");
		}
		if(tx.equals("T2"))
		{
			Rotate("North");
		}
		if(tx.equals("T3"))
		{
			Rotate("East");
		}
	}
}
