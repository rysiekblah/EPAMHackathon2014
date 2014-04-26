package com.realcoders.bot.message;

import com.realcoders.bot.Game;
import com.realcoders.bot.Region;
import com.realcoders.bot.network.MessageDispacher;
import com.realcoders.bot.network.MessageMapper;

/**
 * Created by tomek on 4/26/14.
 */
public class CondotiereHandler extends MessageHandler {
    @Override
    public void handle(String message, Game game) {

        Region condotiere = game.condotiere();
        MessageDispacher.send(MessageMapper.regionMap.get(condotiere)+'\n');

    }
}
