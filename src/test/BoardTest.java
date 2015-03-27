/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import connect4.Board;
import connect4.Game;
import connect4.Move;
import connect4.Player;


/**
 * @author Lion
 *
 */
public class BoardTest {

	Board testboard;
    
	@Before
	public void setUp() throws Exception {
		testboard = new Board();
	}


	@After
	public void tearDown() throws Exception {
		testboard = null;
	}

	@Test
	public void makeMoveTest() {
		testboard.makeMove(new Move(Player.RED,3));
	//one move has been made on the empty board
		assertNotNull(testboard.getTile(5, 3));
		assertEquals("Expected the RED player on the bottom of 4th col",Player.RED,testboard.getPlayer(5, 3));
		assertNull(testboard.getTile(5, 2));
	//print the move on the board to console 
		System.out.println(testboard.toString());
	}
	
	@Test
	public void getPossibleMoveTest() {
	//fill one column up, it leaves 6 possible moves
		Game.fillColumn(testboard, Player.RED, 2, 6);
		System.out.println(testboard.toString());
		assertEquals("Expecting 6 possible Moves", 6 , testboard.getPossibleMoves(Player.YELLOW).length);
	//fill one more column till half should get the same number of moves: 6
		Game.fillColumn(testboard, Player.RED, 4, 3);
		System.out.println(testboard.toString());
		assertEquals("Expecting 6 possible Moves", 6 , testboard.getPossibleMoves(Player.YELLOW).length);
	}
	

}
