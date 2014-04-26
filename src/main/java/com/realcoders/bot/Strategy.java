package com.realcoders.bot;

import java.util.ArrayList;
import java.util.LinkedList;

public class Strategy {

	private final Game game;

	Strategy(Game game) {
		this.game = game;
	}

	byte getNeighboursCount(RegionMap rm) {
		ArrayList<RegionMap> regions = rm.getNeighbours();
		return (byte) regions.size();
	}

	/*
	 * null = regiony, obiekt RegionMap = cele dla zajmowania
	 */
	ArrayList<RegionMap> target(Player p) {
		LinkedList<RegionMap> regs = p.getRegions();
		byte numb = (byte) regs.size();
		byte record = 0;
		ArrayList<RegionMap> used = null;
		if (numb >= 5)
			return null;
		else {
			for (RegionMap reg : regs) {
				byte cnt = (byte) this.getOwnedNeighbours(reg.getNeighbours(),
						p).size();
				if (cnt > record) {
					record = cnt;
					used = new ArrayList<RegionMap>();
					used.add(reg);
				} else if (cnt == record) {
					used.add(reg);
				}
			}
			if (record >= 3)
				return used;
			else {
				if (record > numb * 3 / 2) {
					return used;
				} else
					return null;
			}
		}
	}

	public ArrayList<RegionMap> getOwnedNeighbours(
			ArrayList<RegionMap> neighbours, Player p) {
		ArrayList<RegionMap> retour = new ArrayList<RegionMap>();
		for (RegionMap nb : neighbours) {
			if (p.getRegions().contains(nb))
				retour.add(nb);
		}
		return retour;
	}

	/*
	 * 127 = region prowadzi bezpośrednio do wygranej 0 = region nie prowadzi
	 * bezpośrednio do wygranej lub nie prowadzi
	 */
	public byte getRegionUsage(RegionMap r, Player p) {
		ArrayList<RegionMap> target = target(p);
		LinkedList<RegionMap> owned = p.getRegions();
		if (target != null) {
			for (RegionMap t : target) {
				if (t.getNeighboursOwnedBy(p).size() == 3
						&& t.getFreeRegionNeighbours(game).size() > 0)
					return 127;
			}
		} else {
			if (p.getRegions().size() == 5)
				return 127;
		}
		return 0;
	}

	public CardType getOptimalMove(Player p, RegionMap r) {
		if (p.getCards().size() == 0)
			return null;
		boolean use = getRegionUsage(r, p) > 0;
		LinkedList<CardType> cards = p.getCards();
		Player[] pl = game.getPlayers();
		for (CardType card : cards) {
			if (card.equals(CardType.BOHATERKA)
					|| card.equals(CardType.CARD_10)
					|| card.equals(CardType.WIOSNA)
					|| card.equals(CardType.KURTYZANA)) {
				return card;
			}
		}
		for (CardType card : cards) {
			if (!card.equals(CardType.KAPITULACJA)) {
				return card;
			}
		}
		for (CardType card : cards) {
			if (card.equals(CardType.KAPITULACJA)) {
				return card;
			}
		}
		return null;
	}
}