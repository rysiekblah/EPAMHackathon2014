package com.realcoders.bot;

import java.util.ArrayList;
import java.util.Arrays;

public enum RegionMap {
	TORINO(Region.MILANO, Region.GENOVA), MILANO(Region.TORINO, Region.GENOVA,
			Region.PARMA, Region.MODENA, Region.MANTOVA, Region.VENEZIA), VENEZIA(
			Region.MILANO, Region.MANTOVA, Region.FERRARA), GENOVA(
			Region.TORINO, Region.MILANO, Region.PARMA), MANTOVA(Region.MILANO,
			Region.VENEZIA, Region.FERRARA, Region.MODENA), FERRARA(
			Region.VENEZIA, Region.MANTOVA, Region.MODENA, Region.BOLOGNA), PARMA(
			Region.GENOVA, Region.MILANO, Region.MODENA, Region.LUCCA), MODENA(
			Region.PARMA, Region.MILANO, Region.MANTOVA, Region.FERRARA,
			Region.BOLOGNA, Region.FIRENZE, Region.LUCCA), BOLOGNA(
			Region.FERRARA, Region.MODENA, Region.FIRENZE), LUCCA(Region.PARMA,
			Region.MODENA, Region.FIRENZE), FIRENZE(Region.LUCCA,
			Region.MODENA, Region.BOLOGNA, Region.URBINO, Region.SPOLETO,
			Region.ROMA, Region.SIENA), SIENA(Region.FIRENZE, Region.ROMA), URBINO(
			Region.BOLOGNA, Region.FIRENZE, Region.SPOLETO, Region.ANCONA), SPOLETO(
			Region.FIRENZE, Region.URBINO, Region.ANCONA, Region.NAPOLI,
			Region.ROMA), ANCONA(Region.URBINO, Region.SPOLETO, Region.NAPOLI), ROMA(
			Region.SIENA, Region.FIRENZE, Region.SPOLETO, Region.NAPOLI), NAPOLI(
			Region.ROMA, Region.SPOLETO, Region.ANCONA);
	private final ArrayList<Region> neighbours;

	RegionMap(Region... list) {
		this.neighbours = (ArrayList<Region>) Arrays.asList(list);
	}

	public ArrayList<RegionMap> getNeighbours() {
		ArrayList<RegionMap> retour = new ArrayList<RegionMap>();
		for (Region n : neighbours) {
			retour.add(n.convert());
		}
		return retour;
	}
}