package com.realcoders.bot;

import java.util.LinkedList;

public class Player {

	private final LinkedList<CardType> cards;
	private LinkedList<CardType> used;
	private final Game game;

	Player(LinkedList<CardType> cards, Game game) {
		this.cards = cards;
		this.game = game;
	}

	void playCard(CardType card) {
		if (cards.contains(card)) {
			cards.removeFirstOccurrence(card);
			used.push(card);
		} else {
			throw new RuntimeException();
		}
	}

}
