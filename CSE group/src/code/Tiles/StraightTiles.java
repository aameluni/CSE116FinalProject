package code.Tiles;

/**
 * Child class of the Tiles class. Tile has overloaded constructors to create either a base version of
 * tile with directional fields set to NORTH. Also has a constructor with a direction parameter.
 * or a version of the tile
 * @author Wiechec
 *
 */
public class StraightTiles extends Tiles{
	
	/**
	 * @author Wiechec
	 * Constructor uses a direction parameter to call Rotate on the tile. The parameter is passed into
	 * the rotate method, setting the tile's directional values for the orientation indicated.
	 * @param orientation is the orientation the tile will be set to. parameter is passed to Rotate 
	 * method call.
	 */
	public StraightTiles(String orientation){
		this.Rotate(orientation);
	}
	/**
	 * @author Wiechec
	 * Constructor creates a tile, but returns a tile defaulted into the NORTH orientation.
	 */
	public StraightTiles(){
		this.Rotate("North");
		
	}
	/**
	 * @author Wiechec
	 * Method rotates the tile into one of the indicated orientations. The indicated open values
	 * are the direction this tile will allow movements.
	 * NORTH: UP AND DOWN ARE OPEN
	 * EAST:LEFT AND RIGHT ARE OPEN
	 * SOUTH:UP AND DOWN ARE OPEN
	 * WEST:LEFT AND RIGHT ARE OPEN
	 */
	public void Rotate(String orientation){
		this._rotation = orientation;
		switch (orientation){
		case "North": 
			this._north = true;
			this._east = false;
			this._west = false;
			this._south = true;
			this.sName = "I0";
			break;
		case "South":
			this._north = true;
			this._east = false;
			this._west = false;
			this._south = true;
			this.sName = "I2";
			break;
		case "East":
			this._north = false;
			this._east = true;
			this._west = true;
			this._south = false;
			this.sName = "I3";
			break;
		case "West":
			this._north = false;
			this._east = true;
			this._west = true;
			this._south = false;
			this.sName = "I1";
			break;
		}
	}
	public void Rotation(String tx)
	{
		if(tx.equals("I0")||tx.equals("I2"))
		{
			Rotate("North");
		}
		if(tx.equals("I1")||tx.equals("I3"))
		{
			Rotate("East");
		}
	}
}
