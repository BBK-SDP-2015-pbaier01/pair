package test;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import connect4.AI;
import connect4.Board;
import connect4.Game;
import connect4.Player;
import connect4.Solver;
import connect4.State;

public class AITest {

	State tS;
	Board tB;
	AI p1;
	
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
		p1 = new AI(Player.RED, 5);
		
	}

	@After
	public void tearDown() throws Exception {
		tS = null;
		tB = null;
	}

	@Test
	public void createGameTreeTest() {
		AI.createGameTree(tS, 3);
		assertNotNull(tS.getChildren());
		tS.writeToFile();
	}
	
	@Test
	public void minimaxTest() {
		AI.createGameTree(tS, 3);
		AI.minimax(p1,tS);
		tS.writeToFile();
		Stream.of(tS.getChildren()).forEach(v -> System.out.println(v.getValue()));
	}

}
