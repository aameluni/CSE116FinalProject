package code.Tiles;

/**
 * Child class of the Tiles class. ElbowTile has overloaded constructors to create either a base version of
 * tile with directional fields set to NORTH. Also has a constructor with a direction parameter.
 * or a version of the tile
 * @author Wiechec
 *
 */
public class ElbowTile extends Tiles {
	
	/**
	 * @author Wiechec
	 * Constructor uses a direction parameter to call Rotate on the tile. The parameter is passed into
	 * the rotate method, setting the tile's directional values for the orientation indicated.
	 * @param orientation is the orientation the tile will be set to. parameter is passed to Rotate 
	 * method call.
	 */
	public ElbowTile(String orientation){
		this.Rotate(orientation);
	}
	public ElbowTile(int i)
	{
		Rotation("L"+i);
	}
	/**
	 * @author Wiechec
	 * Constructor creates a tile, but returns a tile defaulted into the NORTH orientation.
	 */
	public ElbowTile(){
		this.Rotate("North");
	}
	/**
	 * @author Wiechec
	 * Method rotates the tile into one of the indicated orientations. The indicated open values
	 * are the direction this tile will allow movements.
	 * NORTH: NORTH AND EAST ARE OPEN
	 * EAST: EAST AND SOUTH ARE OPEN
	 * SOUTH:WEST AND SOUTH ARE OPEN
	 * WEST:NORTH AND WEST ARE OPEN
	 */
	
	public void Rotate(String direction){
		_rotation = direction;
		switch (direction){
		case "North": 
			this._north = true;
			this._east = true;
			this._west = false;
			this._south = false;
			this.sName = "L3";
			break;
		case "South":
			this._north = false;
			this._east = false;
			this._west = true;
			this._south = true;
			this.sName = "L1";
			break;
		case "East":
			this._north = false;
			this._east = true;
			this._west = false;
			this._south = true;
			this.sName = "L0";
			break;
		case "West":
			this._north = true;
			this._east = false;
			this._west = true;
			this._south = false;
			this.sName = "L2";
			break;
		}
	}
	public void Rotation(String tx)
	{
		if(tx.equals("L0"))
		{
			Rotate("East");
		}
		if(tx.equals("L1"))
		{
			Rotate("South");
		}
		if(tx.equals("L2"))
		{
			Rotate("West");
		}
		if(tx.equals("L3"))
		{
			Rotate("North");
		}
	}
}
