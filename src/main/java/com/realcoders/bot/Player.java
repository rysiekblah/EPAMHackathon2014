package com.realcoders.bot;

import java.util.LinkedList;

public class Player {

	private  LinkedList<CardType> cards;
	private  LinkedList<CardType> used = new LinkedList<CardType>();
	private  LinkedList<RegionMap> owned = new LinkedList<RegionMap>();
	// private final Game game;
	private int currentScore = 0;
    private String name;

	public Player(LinkedList<CardType> cards, String name) {
		this.cards = cards;
        this.name = name;
		// this.game = game;
	}


    public String getName() {
        return name;
    }

    public void removeCard(CardType card){
        if (used.contains(card)) {
            used.remove(card);
        } else {
            //throw new RuntimeException();
        }
    }

	public void playCard(CardType card) {
		// if (cards.contains(card)) {
		cards.removeFirstOccurrence(card);
		used.push(card);
		// } else {
		// throw new RuntimeException();
		// }
	}

	public void addRegion(RegionMap r) {
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

    @Override
    public String toString() {
        return "PlayerName: " + name + ", cards: " + cards;
    }

    public void setCards(LinkedList<CardType> cards) {
        this.cards = cards;
    }
}
