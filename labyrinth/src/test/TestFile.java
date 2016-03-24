package test;

import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.Test;

import code.Board;
import code.Player;
import code.Tile;

public class TestFile {

	@Test
	public void test1() {
	Tile tile=new Tile();
	tile.setRandom(0);
	tile.setPath(0);
	boolean expected=true;
	boolean actual=tile.getNorth()&&tile.getWest() && !tile.getEast() && !tile.getSouth();
	assertTrue(expected==actual);
	}
	@Test
	public void test2() {
	Tile tile=new Tile();
	tile.setRandom(1);
	tile.setPath(0);
	boolean expected=true;
	boolean actual=tile.getNorth()&&tile.getEast() && !tile.getWest() && !tile.getSouth();
	assertTrue(expected==actual);
	}
	@Test
	public void test3() {
	Tile tile=new Tile();
	tile.setRandom(2);
	tile.setPath(0);
	boolean expected=true;
	boolean actual=tile.getSouth()&&tile.getWest() && !tile.getNorth() && !tile.getEast();
	assertTrue(expected==actual);
	}
	@Test
	public void test4() {
	Tile tile=new Tile();
	tile.setRandom(3);
	tile.setPath(0);
	boolean expected=true;
	boolean actual=tile.getSouth()&&tile.getEast() && !tile.getNorth() && !tile.getWest();
	assertTrue(expected==actual);
	}
	@Test
	public void test5() {
	Tile tile=new Tile();
	tile.setRandom(4);
	tile.setPath(0);
	boolean expected=false;
	boolean actual=tile.getSouth()&&tile.getEast() && !tile.getNorth() && !tile.getWest();
	assertTrue(expected==actual);
	}
	@Test
	public void test6() {
	Tile tile=new Tile();
	tile.setRandom(0);
	tile.setPath(0);
	boolean expected=false;
	boolean actual=tile.getNorth()&&tile.getSouth() && !tile.getEast() && !tile.getSouth();
	assertTrue(expected==actual);
	}
	@Test
	public void test7() {
	Tile tile=new Tile();
	tile.setRandom(1);
	tile.setPath(0);
	boolean expected=false;
	boolean actual=tile.getNorth()&&tile.getWest() && !tile.getEast() && !tile.getSouth();
	assertTrue(expected==actual);
	}
	@Test
	public void test8() {
	Tile tile=new Tile();
	tile.setRandom(2);
	tile.setPath(0);
	boolean expected=false;
	boolean actual=tile.getSouth()&&tile.getEast() && !tile.getNorth() && !tile.getWest();
	assertTrue(expected==actual);
	}
	@Test
	public void test9() {
	Tile tile=new Tile();
	tile.setRandom(3);
	tile.setPath(0);
	boolean expected=false;
	boolean actual=tile.getSouth()&&tile.getWest() && !tile.getNorth() && !tile.getEast();
	assertTrue(expected==actual);
	}
	@Test
	public void test10() {
	Tile tile=new Tile();
	tile.setRandom(3);
	tile.setPath(4);
	boolean expected=false;
	boolean actual=tile.getSouth()&&tile.getWest() && !tile.getNorth() && !tile.getEast();
	assertTrue(expected==actual);
	}
	@Test
	public void test11() {
	Tile tile=new Tile();
	tile.setRandom(0);
	tile.setPath(1);
	boolean expected=true;
	boolean actual=tile.getNorth()&&tile.getWest() && tile.getEast() && !tile.getSouth();
	assertTrue(expected==actual);
	}
	@Test
	public void test12() {
	Tile tile=new Tile();
	tile.setRandom(1);
	tile.setPath(1);
	boolean expected=true;
	boolean actual=!tile.getNorth()&&tile.getEast() && tile.getWest() && tile.getSouth();
	assertTrue(expected==actual);
	}
	@Test
	public void test13() {
	Tile tile=new Tile();
	tile.setRandom(2);
	tile.setPath(1);
	boolean expected=true;
	boolean actual=tile.getSouth()&&!tile.getWest() && tile.getNorth() && tile.getEast();
	assertTrue(expected==actual);
	}
	@Test
	public void test14() {
	Tile tile=new Tile();
	tile.setRandom(3);
	tile.setPath(1);
	boolean expected=true;
	boolean actual=tile.getSouth()&&!tile.getEast() && tile.getNorth() && tile.getWest();
	assertTrue(expected==actual);
	}
	@Test
	public void test15() {
	Tile tile=new Tile();
	tile.setRandom(0);
	tile.setPath(1);
	boolean expected=false;
	boolean actual=!tile.getNorth()&&tile.getWest() && tile.getEast() && !tile.getSouth();
	assertTrue(expected==actual);
	}
	@Test
	public void test16() {
	Tile tile=new Tile();
	tile.setRandom(1);
	tile.setPath(1);
	boolean expected=false;
	boolean actual=!tile.getNorth()&&!tile.getEast() && tile.getWest() && tile.getSouth();
	assertTrue(expected==actual);
	}
	@Test
	public void test17() {
	Tile tile=new Tile();
	tile.setRandom(2);
	tile.setPath(1);
	boolean expected=false;
	boolean actual=!tile.getSouth()&&!tile.getWest() && tile.getNorth() && tile.getEast();
	assertTrue(expected==actual);
	}
	@Test
	public void test18() {
	Tile tile=new Tile();
	tile.setRandom(3);
	tile.setPath(1);
	boolean expected=false;
	boolean actual=!tile.getSouth()&&!tile.getEast() && tile.getNorth() && tile.getWest();
	assertTrue(expected==actual);
	}
	@Test
	public void test19() {
	Tile tile=new Tile();
	tile.setRandom(0);
	tile.setPath(2);
	boolean expected=true;
	boolean actual=tile.getSouth()&&!tile.getWest() && tile.getNorth() && !tile.getEast();
	assertTrue(expected==actual);
	}
	@Test
	public void test20() {
	Tile tile=new Tile();
	tile.setRandom(1);
	tile.setPath(2);
	boolean expected=true;
	boolean actual=!tile.getSouth()&&tile.getEast() && !tile.getNorth() && tile.getWest();
	assertTrue(expected==actual);
	}
	
	@Test
	public void test21(){
		Board b = new Board();
		Tile tile =new Tile();
		boolean expected=true;
		boolean actual=tile.getToken()>=1&&tile.getToken()<=20||tile.getToken()==25;
		assertTrue(expected==actual);
}
	
	@Test
	public void test22(){
		ArrayList<Tile> t = new ArrayList<Tile>();
		for(int i=0 ; i<22; i++){
		Tile tile =new Tile();
		t.add(tile);
		}
		boolean expected=true;
		boolean actual=t.get(21).getToken()==0;
		assertTrue(expected==actual);
}
	
	@Test
	public void test23(){
		Tile tile=new Tile();
		boolean expected=false;
		boolean actual=tile.hasToken();
		assertTrue(expected==actual);
	}
	
	@Test
	public void test24(){
		Board b=new Board();
		Tile tile=new Tile();
		boolean expected=true;
		boolean actual=tile.hasToken();
		assertTrue(expected==actual);
	}
	
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