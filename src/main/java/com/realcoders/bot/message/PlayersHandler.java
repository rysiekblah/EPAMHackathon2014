package com.realcoders.bot.message;

/**
 * Created by tomek on 4/26/14.
 */
public class PlayersHandler extends MessageHandler {

    private String [] players;

    @Override
    public void handle(String message) {
        players = parseList(message);
    }

    public String[] getPlayers() {
        return players;
    }
}
