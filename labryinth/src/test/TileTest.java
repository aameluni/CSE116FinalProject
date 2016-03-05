package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import code.Board;
import code.Tile;

public class TileTest {

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
	

	
	
	
	
}