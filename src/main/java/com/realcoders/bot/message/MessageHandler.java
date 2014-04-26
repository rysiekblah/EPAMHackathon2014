package com.realcoders.bot.message;

import com.realcoders.bot.Game;

import java.util.Map;

/**
 * Created by tomek on 4/26/14.
 */
public abstract class MessageHandler {

    public abstract void handle(String message, Game game);

    public String[] parseList(String message) {
        String players = message.substring(message.indexOf('[') + 2, message.indexOf(']'));
        return players.split("\n");
    }

    public Map<String, String> parseMap(String message) {
        return null;
    }



}
