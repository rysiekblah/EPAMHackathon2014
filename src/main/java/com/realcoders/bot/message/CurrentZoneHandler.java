package com.realcoders.bot.message;

import com.realcoders.bot.Game;
import com.realcoders.bot.Region;
import com.realcoders.bot.network.MessageMapper;

import java.util.Map;

/**
 * Created by tomek on 4/26/14.
 */
public class CurrentZoneHandler extends MessageHandler {
    @Override
    public void handle(String message, Game game) {
        String zone = message.substring(message.indexOf(' ') + 1);
        System.out.println("Zone to remove: " + zone);
        for (Map.Entry<Region, String> entries : MessageMapper.regionMap.entrySet()) {
            if (entries.getValue().equals(zone)) {
                game.removeRegion(entries.getKey());
            }
        }

    }
}
