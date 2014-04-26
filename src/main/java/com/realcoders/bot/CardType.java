package com.realcoders.bot;

public enum CardType {

	CARD_1(1,true), CARD_2(2,true), CARD_3(3,true), CARD_4(4,true), CARD_5(5,true), CARD_6(6,true), CARD_10(
			10,true), KURTYZANA(1,false), WIOSNA(0,false), ZIMA(0,false), KUKLA(0,false), BISKUP(0,false), DOBOSZ(
			0,false), BOHATERKA(10,false), KAPITULACJA(0,false);

	private final int power;
    private final boolean mercenary;
	CardType(int power,boolean mercenary) {

        this.power = power;
        this.mercenary = mercenary;
	}

	int getPower() {
		return power;
	}

    public boolean isMercenary() {
        return mercenary;
    }
}
