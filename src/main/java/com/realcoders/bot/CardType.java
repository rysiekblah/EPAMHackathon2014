package com.realcoders.bot;

public enum CardType {

	CARD_1(1), CARD_2(2), CARD_3(3), CARD_4(4), CARD_5(5), CARD_6(6), CARD_10(
			10), KURTYZANA(1), WIOSNA(0), ZIMA(0), KUKLA(0), BISKUP(0), DOBOSZ(
			0), BOHATERKA(10), KAPITULACJA(0);

	private final int power;

	CardType(int power) {
		this.power = power;
	}

	int getPower() {
		return power;
	}

}
