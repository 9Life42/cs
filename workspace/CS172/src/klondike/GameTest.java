package klondike;

import static klondike.Card.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;
	
	@Before
	public void setUp() throws Exception {
		game = new Game();
	}

	@Test
	public void testSuccessor() {
		Card c = new Card(QUEEN, CLUBS);
		Card d = new Card(KING, HEARTS);
		assertTrue(game.successor(c, d));
		assertFalse(game.successor(d, c));
		assertFalse(game.successor(c, null));
		assertTrue(game.successor(d, null));
	}

	@Test
	public void testKlondikeMove() {
		Deck deck = new Deck();
		// Deck is the source pile
		Card c = new Card(10, SPADES);
		c.setFaceUp(false);
		deck.add(c);
		c = new Card(JACK, HEARTS);
		c.setFaceUp(false);
		deck.add(c);
		deck.add(new Card(6, HEARTS));
		deck.add(new Card(5, SPADES));
		deck.add(new Card(4, DIAMONDS));
		deck.add(new Card(3, CLUBS));
		// Destination is the other pile
		Deck destination = new Deck();
		c = new Card(KING, HEARTS);
		c.setFaceUp(false);
		destination.add(c);
		destination.add(new Card(8, DIAMONDS));
		destination.add(new Card(7, SPADES));
		destination.add(new Card(6, DIAMONDS));
		// It is illegal to move from destination to deck
		game.klondikeMove(destination, deck);
		assertEquals(6, deck.size());
		assertEquals(4, destination.size());
		// Moving from deck to destination should have the desired effect
		game.klondikeMove(deck, destination);
		assertEquals(3, deck.size());
		assertEquals(7, destination.size());
		for (int i = 0; i < 6; i++) {
			assertEquals(3 + i, destination.get(destination.size() - 1 - i).getRank());
		}
	}
	
	@Test
	public void testMoveKingToEmptyDeck() {
		Deck deck = new Deck();
		// A 7 can't be moved to an empty pile
		deck.add(new Card(7, DIAMONDS));
		Deck destination = new Deck();
		game.klondikeMove(deck, destination);
		assertEquals(1, deck.size());
		// ...but a king can
		deck.get(0).setFaceUp(false);
		deck.add(new Card(KING, HEARTS));
		game.klondikeMove(deck, destination);
		assertEquals(1, deck.size());
		assertEquals(1, destination.size());
	}

	@Test
	public void testDrawNextCard() {
		// There are 23 cards left in the deck after the initial deal
		for (int i = 1; i <= 23; i++) {
			game.drawNextCard();
			assertEquals(23 - i, game.getDeck().size());
			assertEquals(1 + i, game.getDrawPile().size());
		}
		// Trying to draw another card should have no effect
		game.drawNextCard();
		assertEquals(0, game.getDeck().size());
		assertEquals(24, game.getDrawPile().size());
	}
	
	@Test
	public void testMoveToFoundation() {
		Deck source = new Deck();
		source.add(new Card(7, SPADES));
		source.top().setFaceUp(false);
		source.add(new Card(2, HEARTS));
		source.add(new Card(ACE, HEARTS));
		// This illegal move should have no effect
		game.moveToFoundation(source, CLUBS);
		// These should work
		game.moveToFoundation(source, HEARTS);
		game.moveToFoundation(source, HEARTS);
		// This should not
		game.moveToFoundation(source, SPADES);
		assertEquals(1, source.size());
		assertTrue(source.top().isFaceUp());
	}

	@Test
	public void testMoveToTableau() {
		// Arrange the tableau to make some moves possible
		Deck garbage = new Deck();
		game.getTableau(6).move(garbage);
		game.getTableau(6).add(new Card(6, SPADES));
		game.getTableau(5).move(garbage);
		game.getTableau(5).add(new Card(QUEEN, CLUBS));
		game.getTableau(5).add(new Card(4, CLUBS));
		game.getTableau(5).add(new Card(3, HEARTS));
		game.getDrawPile().add(new Card(5, DIAMONDS));
		// Moving from the draw pile to tableau pile 5 should have no effect
		game.moveToTableau(game.getDrawPile(), 5);
		assertEquals(2, game.getDrawPile().size());
		// Moving to pile 6 should work
		game.moveToTableau(game.getDrawPile(), 6);
		assertEquals(1, game.getDrawPile().size());
		// Now a move from tableau pile 5 to 6 should move two cards
		game.moveToTableau(game.getTableau(5), 6);
		assertEquals(10, game.getTableau(6).size());
		assertEquals(6, game.getTableau(5).size());
	}
	

}
