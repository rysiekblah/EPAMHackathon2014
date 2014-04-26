package com.realcoders.bot;

public class Game {

	private final Player[] players;

	public Game(Player[] players) {
		this.players = players;
	}

    public Player[] getPlayers() {
        return players;
    }
}
