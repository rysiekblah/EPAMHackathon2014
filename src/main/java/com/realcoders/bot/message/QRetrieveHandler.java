package com.realcoders.bot.message;

import com.realcoders.bot.CardType;
import com.realcoders.bot.Game;
import com.realcoders.bot.network.MessageDispacher;

import java.util.Map;

/**
 * Created by tomek on 4/26/14.
 */
public class QRetrieveHandler extends MessageHandler {
    @Override
    public void handle(String message, Game game) {
        CardType retrieve = game.retrieve();
        for (Map.Entry<String, CardType> typeEntry : HandHandler.mapa.entrySet()) {
            if (typeEntry.getValue().equals(retrieve)) {
                MessageDispacher.send(typeEntry.getKey() + '\n');
            }
        }
    }
}
