package com.realcoders.bot.test;

import java.util.LinkedList;

import org.junit.Test;

import com.realcoders.bot.CardType;
import com.realcoders.bot.Game;
import com.realcoders.bot.Player;
import com.realcoders.bot.Strategy;

public class StrTest {

	@Test
	public void test() {
		LinkedList<CardType> cards = new LinkedList<CardType>();
		cards.add(CardType.CARD_10);
		cards.add(CardType.CARD_6);
		cards.add(CardType.KURTYZANA);
		cards.add(CardType.KUKLA);
		cards.add(CardType.BISKUP);
		cards.add(CardType.KAPITULACJA);
		cards.add(CardType.CARD_1);
		cards.add(CardType.CARD_2);
		Player[] players = { new Player(cards) };
		Game g = new Game(players);
		g.setOurPlayer(players[0]);
		while (g.getOurPlayer().getCards().size() > 0) {
			CardType cardToRemove = new Strategy(g).getOptimalMove(g
					.getOurPlayer());
			System.out.println(cardToRemove.toString());
			g.getOurPlayer().playCard(cardToRemove);
		}
	}

}
