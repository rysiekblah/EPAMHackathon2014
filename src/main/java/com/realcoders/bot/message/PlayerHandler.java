package com.realcoders.bot.message;

import com.realcoders.bot.CardType;
import com.realcoders.bot.Game;
import com.realcoders.bot.Player;
import com.realcoders.bot.network.MessageMapper;

import java.util.LinkedList;

/**
 * Created by tomek on 4/26/14.
 */
public class PlayerHandler extends MessageHandler {
    @Override
    public void handle(String message, Game game) {
        String player = message.substring(message.indexOf(' ') + 1);
        System.out.println("Player start play: " + player);

        game.setCurrentPlayer(new Player(new LinkedList<CardType>(), player));

    }
}
