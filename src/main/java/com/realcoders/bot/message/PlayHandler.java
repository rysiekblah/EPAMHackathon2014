package com.realcoders.bot.message;

import com.realcoders.bot.Game;

/**
 * Created by tomek on 4/26/14.
 */
public class PlayHandler extends MessageHandler {
    @Override
    public void handle(String message, Game game) {
        String card = message.substring(message.indexOf(' ') + 1);
        System.out.println("Player card: " + card);
        String player = game.getCurrentPlayer().getName();
        if(!player.equals(game.getOurPlayer().getName())) {
            game.currentPlayerPlay(HandHandler.mapa.get(card));
        }
    }
}
