package com.realcoders.bot;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {

	private Player[] players;
	private Player ourPlayer;
	private final ArrayList<Region> availableRegions = new ArrayList<Region>(
			Arrays.asList(Region.values()));

	private Region protectedRegion = null;

	public Game() {

	}

	public Game(Player[] players) {
		this.players = players;
	}

    public Player[] getPlayers() {
        return players;
    }

    public Player getOurPlayer() {
        return ourPlayer;
    }

    public void removeRegion(Region region){
        availableRegions.remove(region);
    }

    public void setOurPlayer(Player ourPlayer) {
        this.ourPlayer = ourPlayer;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
    public boolean playerUseAnyMercenary(){
        for(CardType cardType: ourPlayer.getUsed())
            if(cardType.isMercenary())
                return true;
        return false;
    }
    public CardType move(){

        System.out.println("cards: "+ourPlayer.getCards());
        System.out.println("usedcards"+ourPlayer.getUsed());
        if(ourPlayer.getCards().size()==0)
            return null;
        CardType card=null;
        do {
           card = ourPlayer.getCards().get((int) (Math.random() * ourPlayer.getCards().size()));
        }while(CardType.KUKLA.equals(card) && (ourPlayer.getUsed().size()==0 || !playerUseAnyMercenary()));
        ourPlayer.playCard(card);
            //ourPlayer.getCards().remove(card);
        return card;

    }

    public CardType retrieve(){

        CardType card =null;
        do {
            card = ourPlayer.getUsed().get((int) (Math.random() * ourPlayer.getUsed().size()));
        } while(!card.isMercenary());
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
    public void regionTaken(Region region){
        availableRegions.remove(region);

    }
    public Region getProtectedRegion() {
        return protectedRegion;
    }

    public void setProtectedRegion(Region protectedRegion) {
        this.protectedRegion = protectedRegion;
    }
}
