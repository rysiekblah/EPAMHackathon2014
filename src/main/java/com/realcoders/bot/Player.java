package com.realcoders.bot;

import java.util.LinkedList;
import java.util.List;

public class Player {

	private LinkedList<CardType> cards;
    private LinkedList<CardType> used = new LinkedList<>();
	//private final Game game;
    private int currentScore=0;
	public Player(LinkedList<CardType> cards) {
		this.cards = cards;
		//this.game = game;
	}



    public void playCard(CardType card) {
		if (cards.contains(card)) {
			cards.removeFirstOccurrence(card);
			used.push(card);
		} else {
			throw new RuntimeException();
		}
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
