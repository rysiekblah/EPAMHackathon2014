package com.realcoders.bot;

public class Game {

	private final Player[] players;
    private Player ourPlayer;

	public Game(Player[] players) {
		this.players = players;
	}

    public Player[] getPlayers() {
        return players;
    }

    public Player getOurPlayer() {
        return ourPlayer;
    }

    public void setOurPlayer(Player ourPlayer) {
        this.ourPlayer = ourPlayer;
    }
    public void chooseCard(){
        CardType card = ourPlayer.getCards().get((int) (Math.random()*ourPlayer.getCards().size()));
        ourPlayer.getCards().remove(card);

    }

}
