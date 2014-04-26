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
	 * true = sąsiedzi, false = regiony.
	 */
	boolean target(Player p) {
		LinkedList<RegionMap> regs = p.getRegions();
		byte numb = (byte) regs.size();
		byte record = 0;
		if (numb >= 5)
			return false;
		else {
			for (RegionMap reg : regs) {
				byte cnt = (byte) this.getOwnedNeighbours(reg.getNeighbours(),
						p).size();
				if (cnt > record)
					record = cnt;
			}
			if (record >= 3)
				return true;
			else {
				return (record > numb * 3 / 2);
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

}