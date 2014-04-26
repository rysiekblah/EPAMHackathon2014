package com.realcoders.bot.network;

import com.google.common.collect.Maps;
import com.realcoders.bot.message.GameEndHandler;
import com.realcoders.bot.message.GameStartHandler;
import com.realcoders.bot.message.MessageHandler;

import java.util.Map;

/**
 * Created by tomek on 4/26/14.
 */
public class MessageMapper {

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


    static {

        msgMap = Maps.newHashMap();
        msgMap.put(GAME_START, new GameStartHandler());
        msgMap.put(GAME_END, new GameEndHandler());

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
