package com.realcoders.bot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Game {

	private final Player[] players;
    private Player ourPlayer;
    private ArrayList<Region> availableRegions= new ArrayList<Region>(Arrays.asList(Region.values()));


    private Region protectedRegion =null;

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
    public CardType move(){
        CardType card = ourPlayer.getCards().get((int) (Math.random()*ourPlayer.getCards().size()));
        ourPlayer.playCard(card);
        //ourPlayer.getCards().remove(card);
        return card;
    }

    public CardType retrieve(){
        CardType card = ourPlayer.getUsed().get((int) (Math.random()*ourPlayer.getUsed().size()));
        ourPlayer.getCards().add(card);
        return card;
    }
    public Region condotiere(){
        Region region=null;
        do {
            region = availableRegions.get((int) (Math.random() * availableRegions.size()));
        }while (region == protectedRegion);
        availableRegions.remove(region);
        return region;

    }

    public Region bishop(){
        Region region=null;

        region = availableRegions.get((int) (Math.random() * availableRegions.size()));
        protectedRegion=region;
        return region;

    }
}
