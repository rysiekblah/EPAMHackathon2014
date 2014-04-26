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

    public static String BOT_ALIAS = "";

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


    public static final String CONDOTIERE = "?Condottiere";
    public static final String MOVE = "?Move";
    public static final String BISHOP = "?Bishop";
    public static final String Q_RETRIEVE = "?Retrieve";

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
        msgMap.put(ORDER, new OrderHandler());
        msgMap.put(PLAYER, new DummyHandler());
        msgMap.put(CURRENT_ZONE, new CurrentZoneHandler());
        msgMap.put(PASS, new DummyHandler());
        msgMap.put(PLAY, new DummyHandler());
        msgMap.put(PROTECT, new DummyHandler());
        msgMap.put(RETRIEVE, new DummyHandler());
        msgMap.put(SCORE, new DummyHandler());

        msgMap.put(PLAY, new PlayHandler());
        msgMap.put(PLAYER, new PlayerHandler());

        msgMap.put(CONDOTIERE, new CondotiereHandler());
        msgMap.put(MOVE, new MoveHandler());
        msgMap.put(BISHOP, new BishopHandler());
        msgMap.put(Q_RETRIEVE, new QRetrieveHandler());

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
