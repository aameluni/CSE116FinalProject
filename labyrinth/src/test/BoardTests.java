package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import code.Board;
import code.Tile;

public class BoardTests {

	@Test
	public void test21(){
		Board b = new Board();
		boolean expected=true;
		boolean actual=b.getBoard().get(1).get(1).getToken()>=1&&b.getBoard().get(1).get(1).getToken()<=20||b.getBoard().get(1).get(1).getToken()==25;
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
		boolean expected=true;
		boolean actual=b.getBoard().get(1).get(1).hasToken();
		assertTrue(expected==actual);
	}
	@Test
	public void test25(){
		Board b=new Board();
		boolean expected=true;
		boolean actual=b.getBoard().get(1).get(2).hasToken();
		assertTrue(expected==actual);
	}
	@Test
	public void test26(){
		Board b=new Board();
		boolean expected=false;
		boolean actual=b.getBoard().get(0).get(0).hasToken();
		assertTrue(expected==actual);
	}
	@Test
	public void test27(){
		Board b=new Board();
		boolean expected=true;
		boolean actual=b.getBoard().get(4).get(5).hasToken();
		assertTrue(expected==actual);
	}
	@Test
	public void test28(){
		Board b=new Board();
		boolean expected=false;
		boolean actual=b.getBoard().get(2).get(2).hasToken();
		assertTrue(expected==actual);
	}
	@Test
	public void test29(){
		Board b=new Board();
		boolean expected=false;
		boolean actual=b.getBoard().get(2).get(4).hasToken();
		assertTrue(expected==actual);
	}
	@Test
	public void test30(){
		Board b=new Board();
		boolean expected=true;
		boolean actual=b.getBoard().get(2).get(3).hasToken();
		assertTrue(expected==actual);
	}
	@Test
	public void test31(){
		Board b=new Board();
		boolean expected=true;
		boolean actual=b.getBoard().get(2).get(2).hasPlayer(b.getPlayerList());
		assertTrue(expected==actual);
	}
	@Test
	public void test32(){
		Board b=new Board();
		boolean expected=true;
		boolean actual=b.getBoard().get(2).get(4).hasPlayer(b.getPlayerList());
		assertTrue(expected==actual);
	}
	@Test
	public void test33(){
		Board b=new Board();
		boolean expected=true;
		boolean actual=b.getBoard().get(4).get(2).hasPlayer(b.getPlayerList());
		assertTrue(expected==actual);
	}
	@Test
	public void test34(){
		Board b=new Board();
		boolean expected=true;
		boolean actual=b.getBoard().get(4).get(4).hasPlayer(b.getPlayerList());
		assertTrue(expected==actual);
	}
	@Test
	public void test35(){
		Board b=new Board();
		boolean expected=false;
		boolean actual=b.getBoard().get(1).get(4).hasPlayer(b.getPlayerList());
		assertTrue(expected==actual);
	}
	@Test
	public void test36(){
		Board b=new Board();
		boolean expected=false;
		boolean actual=b.getBoard().get(4).get(5).hasPlayer(b.getPlayerList());
		assertTrue(expected==actual);
	}
	@Test
	public void test37(){
		Board b=new Board();
		boolean expected=true;
		boolean actual=b.tileShifting(1, -1);
		assertTrue(expected==actual);
	}
	@Test
	public void test38(){
		Board b=new Board();
		boolean expected=true;
		boolean actual=b.tileShifting(1, 7);
		assertTrue(expected==actual);
	}
	@Test
	public void test39(){
		Board b=new Board();
		boolean expected=true;
		boolean actual=b.tileShifting(3, 7);
		assertTrue(expected==actual);
	}
	@Test
	public void test40(){
		Board b=new Board();
		boolean expected=false;
		boolean actual=b.tileShifting(0, 0);
		assertTrue(expected==actual);
	}
	@Test
	public void test41(){
		Board b=new Board();
		boolean expected=false;
		boolean actual=b.tileShifting(2, 2);
		assertTrue(expected==actual);
	}
	@Test
	public void test42(){
		Board b=new Board();
		boolean expected=false;
		boolean actual=b.tileShifting(2, 4);
		assertTrue(expected==actual);
	}
	@Test
	public void test43(){
		Board b=new Board();
		boolean expected=false;
		boolean actual=b.tileShifting(2, -1);
		assertTrue(expected==actual);
	}
	@Test
	public void test44(){
		Board b=new Board();
		boolean expected=false;
		boolean actual=b.tileShifting(2, 7);
		assertTrue(expected==actual);
	}
	@Test
	public void test45(){
		Board b=new Board();
		int expected = b.getBoard().get(1).get(5).getToken();
		b.tileShifting(1, -1);
		int actual=b.getBoard().get(1).get(6).getToken();
		assertTrue(expected==actual);
	}
	@Test
	public void test46(){
		Board b=new Board();
		int expected = b.getBoard().get(1).get(5).getToken();
		b.tileShifting(1, -1);
		b.tileShifting(1, -1);
		int actual=b.getBoard().get(1).get(0).getToken();
		assertTrue(expected==actual);
	}
	@Test
	public void test466(){
		Board b=new Board();
		int expected = b.getBoard().get(1).get(1).getToken();
		b.tileShifting(1, 7);
		b.tileShifting(1, 7);
		int actual=b.getBoard().get(1).get(6).getToken();
		assertTrue(expected==actual);
	}
	@Test
	public void test47(){
		Board b=new Board();
		int expected = b.getBoard().get(5).get(1).getToken();
		b.tileShifting(-1, 1);
		b.tileShifting(-1, 1);
		int actual=b.getBoard().get(0).get(1).getToken();
		assertTrue("" + expected + " " + actual,expected==actual);
	}
	@Test
	public void test48(){
		Board b=new Board();
		int expected = b.getBoard().get(1).get(1).getToken();
		b.tileShifting(7, 1);
		b.tileShifting(7, 1);
		int actual=b.getBoard().get(6).get(1).getToken();
		assertTrue("" + expected + " " + actual,expected==actual);
	}
}
