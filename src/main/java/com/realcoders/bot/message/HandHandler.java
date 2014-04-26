package com.realcoders.bot.message;

/**
 * Created by tomek on 4/26/14.
 */
public class HandHandler extends MessageHandler {
    private String [] cards;
    @Override
    public void handle(String message) {
        cards = parseList(message);
    }
}
