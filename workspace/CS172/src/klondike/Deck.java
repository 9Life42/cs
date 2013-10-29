package klondike;

import static edu.princeton.cs.introcs.StdRandom.*;
import static klondike.Card.DIAMONDS;

/** A deck or pile of cards. */
public class Deck {

	/** The cards in this deck. */
	private Card[] cards;

	/** @see #size() */
	private int size;

	/** A new deck is initially empty. */
	public Deck() {
		cards = new Card[52];
	}

	/** Adds card to the top of this deck. */
	public void add(Card card) {
		cards[size] = card;
		size++;
	}

	/** Adds all cards in a standard deck. */
	public void fill() {
		size = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14; j++) {
				cards[size] = new Card(j, i);
				size++;
			}
		}
	}

	/**
	 * Returns the ith card in this deck, where card 0 is the one on the bottom.
	 * Assumes the deck is not empty.
	 */
	public Card get(int i) {
		return cards[i];
	}

	/** Moves one card from the top of this deck to the top of that deck. */
	public void move(Deck that) {
		that.add(cards[size - 1]);
		size -= 1;
	}

	/**
	 * Moves the top n cards from the top of this deck to the top of that deck.
	 * They maintain their order, so that the card that used to be on top of
	 * this becomes the top of that.
	 */
	public void move(Deck that, int n) {
		for (int i = size - n; i < size; i++) {
			that.add(cards[i]);
			cards[i] = null;
		}
		
		size -= n;
	}

	/**
	 * Randomly reorders the cards in this deck.
	 */
	public void shuffle() {
		for (int i = 0; i < cards.length; i++) {
			int rand = i + uniform(cards.length - i);
			Card c = cards[i];
			cards[i] = cards[rand];
			cards[rand] = c;
		}
	}

	/** Returns the number of cards in this deck. */
	public int size() {
		return size;
	}

	/**
	 * Returns the top card on this deck (but does not modify the deck).
	 * 
	 * @return null if this deck is empty.
	 */
	public Card top() {
		if (size == 0)
			return null;
		return cards[size - 1];
	}

}
