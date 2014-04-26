package com.realcoders.bot;

import java.util.LinkedList;

public class Player {

	private final LinkedList<CardType> cards;
	private LinkedList<CardType> used;

	Player(LinkedList<CardType> cards) {
		this.cards = cards;
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
