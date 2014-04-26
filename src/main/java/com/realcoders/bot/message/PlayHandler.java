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
        game.currentPlayerPlay(HandHandler.mapa.get(card));
    }
}
