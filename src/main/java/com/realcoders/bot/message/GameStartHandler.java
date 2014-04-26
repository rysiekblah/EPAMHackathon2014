package com.realcoders.bot.message;

import com.realcoders.bot.Game;

/**
 * Created by tomek on 4/26/14.
 */
public class GameStartHandler extends MessageHandler {
    @Override
    public void handle(String message, Game game) {
        System.out.println("Game START");
    }
}
