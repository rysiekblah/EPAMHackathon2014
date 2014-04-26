package com.realcoders.bot.message;

import com.realcoders.bot.Game;
import com.realcoders.bot.network.MessageMapper;

/**
 * Created by tomek on 4/26/14.
 */
public class PlayerHandler extends MessageHandler {
    @Override
    public void handle(String message, Game game) {
        String player = message.substring(message.indexOf(' ') + 1);
        if (!player.equals(MessageMapper.BOT_ALIAS)) {
            // set to game
        }
    }
}
