package com.realcoders.bot;

import java.util.LinkedList;

public class Player {

	private final LinkedList<CardType> cards;
	private final LinkedList<CardType> used = new LinkedList<CardType>();
	private final LinkedList<RegionMap> owned = new LinkedList<RegionMap>();
	// private final Game game;
	private int currentScore = 0;

	public Player(LinkedList<CardType> cards) {
		this.cards = cards;
		// this.game = game;
	}

	public void playCard(CardType card) {
		if (cards.contains(card)) {
			cards.removeFirstOccurrence(card);
			used.push(card);
		} else {
			throw new RuntimeException();
		}
	}

	public LinkedList<RegionMap> addRegion(RegionMap r) {
		owned.push(r);
	}

	public LinkedList<RegionMap> getRegions() {
		return owned;
	}

	public LinkedList<CardType> getUsed() {
		return used;
	}

	public LinkedList<CardType> getCards() {
		return cards;
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
}
