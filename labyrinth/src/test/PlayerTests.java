package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import code.Player;
import code.Tile;

public class PlayerTests {

	@Test
	public void test25()
	{
		ArrayList<ArrayList<Tile>> t = new ArrayList<ArrayList<Tile>>();
		ArrayList<Tile> ti = new ArrayList<Tile>();
		ti.add(new Tile());
		ti.add(new Tile());
		Player p = new Player(t,0,1);
		p.usingMagicWands();
		p.usingMagicWands();
		p.usingMagicWands();
		boolean actual = p.usingMagicWands();
		boolean expected = false;
		assertTrue(expected==actual);
		
	}
	
	@Test
	public void test26()
	{
		ArrayList<ArrayList<Tile>> t = new ArrayList<ArrayList<Tile>>();
		ArrayList<Tile> ti = new ArrayList<Tile>();
		ti.add(new Tile());
		ti.add(new Tile());
		Player p = new Player(t,0,1);
		boolean actual = p.usingMagicWands();
		boolean expected = true;
		assertTrue(expected==actual);	
	}
	@Test
	public void test27()
	{
		ArrayList<ArrayList<Tile>> t = new ArrayList<ArrayList<Tile>>();
		ArrayList<Tile> ti = new ArrayList<Tile>();
		ti.add(new Tile());
		ti.add(new Tile());
		Player p = new Player(t,0,1);
		p.addToken(1);
		p.addToken(25);
		p.addToken(4);
		p.usingMagicWands();
		int actual = p.score();
		int expected = 36;
		assertTrue(expected==actual || actual == expected +20 || actual == expected +40|| actual == expected +60);
	}
	
	@Test
	public void test28()
	{
		ArrayList<ArrayList<Tile>> t = new ArrayList<ArrayList<Tile>>();
		ArrayList<Tile> ti = new ArrayList<Tile>();
		ti.add(new Tile());
		ti.get(0).setRandom(0);
		ti.get(0).setPath(2);
		ti.add(new Tile());
		ti.get(1).setRandom(0);
		ti.get(1).setPath(2);
		t.add(ti);
		Player p = new Player(t,0,1);
		p.getPtile().setX(0);
		p.getPtile().setY(1);
		boolean actual = p.legitMove(ti.get(0));
		boolean expected = true;
		assertTrue("pTile:"+ p.getPtile() + "tile:" +ti.get(0),expected==actual);
	}

}
