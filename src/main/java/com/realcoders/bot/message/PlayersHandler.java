package com.realcoders.bot.message;

import com.realcoders.bot.Game;
import com.realcoders.bot.Player;

/**
 * Created by tomek on 4/26/14.
 */
public class PlayersHandler extends MessageHandler {

    private String [] playerList;

    @Override
    public void handle(String message, Game game) {
        playerList = parseList(message);
        Player[] players = new Player[playerList.length];
        for (int i=0; i<playerList.length; ++i) {
            players[i] = new Player(null, playerList[i]);
        }
        game.setPlayers(players);
    }

    public String[] getPlayers() {
        return playerList;
    }
}
