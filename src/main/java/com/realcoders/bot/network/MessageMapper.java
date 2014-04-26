package com.realcoders.bot.network;

import com.google.common.collect.Maps;
import com.realcoders.bot.CardType;
import com.realcoders.bot.Region;
import com.realcoders.bot.message.*;

import java.util.Map;

/**
 * Created by tomek on 4/26/14.
 */
public class MessageMapper {

    public static final String BOT_ALIAS = "RealCoders";

    private static Map<String, MessageHandler> msgMap;
    public static final String GAME_START = "GameStart";
    public static final String GAME_END = "GameEnd";
    public static final String ROUND_START = "RoundStart";
    public static final String BATTLE_START = "BattleStart";
    public static final String BATTLE_END = "BattleEnd";
    public static final String ROUND_END = "RoundEnd";

    public static final String PLAYERS = "Players";
    public static final String ORDER = "Order";
    public static final String HAND = "Hand";

    public static final String PLAYER = "Player";
    public static final String CURRENT_ZONE = "CurrentZone";
    public static final String PASS = "Pass";
    public static final String PLAY = "Play";
    public static final String PROTECT = "Protect";
    public static final String RETRIEVE = "Retrieve";
    public static final String SCORE = "Score";

    public static Map<Region,String > regionMap = Maps.newHashMap();

    static {

        regionMap.put(Region.TORINO,"Torino");
        regionMap.put(Region.MILANO,"Milano");
        regionMap.put(Region.VENEZIA,"Venezia");
        regionMap.put(Region.GENOVA, "Genova");
        regionMap.put(Region.MANTOVA, "Mantova");
        regionMap.put(Region.PARMA, "Parma");
        regionMap.put(Region.MODENA, "Modena");
        regionMap.put(Region.FERRARA, "Ferrara");
        regionMap.put(Region.BOLOGNA, "Bologna");
        regionMap.put(Region.LUCCA, "Lucca");
        regionMap.put(Region.FIRENZE, "Firenze");
        regionMap.put(Region.SIENA, "Siena");
        regionMap.put(Region.SPOLETO, "Spoleto");
        regionMap.put(Region.URBINO, "Urbino");
        regionMap.put(Region.ANCONA, "Ancona");
        regionMap.put(Region.ROMA, "Roma");
        regionMap.put(Region.NAPOLI, "Napoli");
    }


    static {

        msgMap = Maps.newHashMap();
        msgMap.put(GAME_START, new GameStartHandler());
        msgMap.put(GAME_END, new GameEndHandler());
        msgMap.put(ROUND_START, new RoundStartHandler());
        msgMap.put(ROUND_END, new RoundEndHandler());
        msgMap.put(BATTLE_START, new BattleStartHanlder());
        msgMap.put(BATTLE_END, new BattleEndHander());
        msgMap.put(PLAYERS, new PlayersHandler());
        msgMap.put(HAND, new HandHandler());
    }

    public MessageHandler getHandler(String message) {
        return msgMap.get(obtainOpCode(message));
    }

    public String obtainOpCode(String input) {
        int i = input.indexOf(' ');
        if (i == -1) {
            return input;
        }
        return input.substring(0, i);
    }

}
