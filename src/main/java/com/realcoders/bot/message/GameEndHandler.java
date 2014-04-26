package com.realcoders.bot.message;

import com.realcoders.bot.network.MessageMapper;

/**
 * Created by tomek on 4/26/14.
 */
public class GameEndHandler implements MessageHandler {
    @Override
    public void handle(String message) {
        if (message.contains(MessageMapper.BOT_ALIAS)) {
            // notify that we have won
        } else {
            // tie
        }
    }
}
