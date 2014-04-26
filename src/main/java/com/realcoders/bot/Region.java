package com.realcoders.bot;

public enum Region {

	TORINO, MILANO, VENEZIA, GENOVA, MANTOVA, FERRARA, PARMA, MODENA, BOLOGNA, LUCCA, FIRENZE, SIENA, URBINO, SPOLETO, ANCONA, ROMA, NAPOLI;

	RegionMap convert() {
		for (RegionMap rm : RegionMap.values()) {
			if (rm.toString().equals(toString()))
				return rm;
		}
		throw new RuntimeException();
	}
}
