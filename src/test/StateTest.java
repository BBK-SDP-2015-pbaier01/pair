package test;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import connect4.Board;
import connect4.Game;
import connect4.Player;
import connect4.State;

public class StateTest {

	State tS;
	Board tB;
	
	@Before
	public void setUp() throws Exception {
		tB = new Board();
		Game.fillColumn(tB, Player.RED, 0, 6);
		Game.fillColumn(tB, Player.RED, 1, 6);
		Game.fillColumn(tB, Player.YELLOW, 2, 6);
		Game.fillColumn(tB, Player.YELLOW, 3, 6);
		Game.fillColumn(tB, Player.RED, 4, 4);
		Game.fillColumn(tB, Player.RED, 5, 4);
		Game.fillColumn(tB, Player.RED, 6, 6);
		tS = new State(Player.RED,tB,null);
	}

	@After
	public void tearDown() throws Exception {
		tS = null;
		tB = null;
	}

	@Test
	public void initializeChildrenTest() {
		System.out.println(tB.toString());
		tS.initializeChildren();
		assertNotNull(tS.getChildren());
		Board childrensBoard1 = tS.getChildren()[0].getBoard();
		Board childrensBoard2 = tS.getChildren()[1].getBoard();
		assertNull(tS.getChildren()[0].getBoard().getTile(0, 4));
		assertNull(tS.getChildren()[1].getBoard().getTile(0, 5));
		assertEquals("Expecting Player RED ",Player.RED, childrensBoard1.getTile(1, 4));
		assertEquals("Expecting no Player there ",null, childrensBoard1.getTile(1, 5));
		
		assertEquals("Expecting Player RED ",Player.RED, childrensBoard2.getTile(1, 5));
		assertEquals("Expecting no Player there ",null, childrensBoard2.getTile(1, 4));
		Stream.of(tS.getChildren()).forEach(System.out::println);
		
	}

}
