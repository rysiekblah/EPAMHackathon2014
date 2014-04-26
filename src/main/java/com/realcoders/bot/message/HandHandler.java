package com.realcoders.bot.message;

import com.google.common.collect.Maps;
import com.realcoders.bot.CardType;
import com.realcoders.bot.Game;
import com.realcoders.bot.Player;
import com.realcoders.bot.network.MessageMapper;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by tomek on 4/26/14.
 */
public class HandHandler extends MessageHandler {
    private String[] cards;

    public static Map<String, CardType> mapa = Maps.newHashMap();

    static {
        mapa.put("1", CardType.CARD_1);
        mapa.put("2", CardType.CARD_2);
        mapa.put("3", CardType.CARD_3);
        mapa.put("4", CardType.CARD_4);
        mapa.put("5", CardType.CARD_5);
        mapa.put("6", CardType.CARD_6);
        mapa.put("10", CardType.CARD_10);
        mapa.put("Courtesan", CardType.KURTYZANA);
        mapa.put("Heroine", CardType.BOHATERKA);
        mapa.put("Winter", CardType.ZIMA);
        mapa.put("Spring", CardType.WIOSNA);
        mapa.put("Bishop", CardType.BISKUP);
        mapa.put("Drummer", CardType.DOBOSZ);
        mapa.put("Scarecrow", CardType.KUKLA);
        mapa.put("Key", CardType.KAPITULACJA);
    }


    @Override
    public void handle(String message, Game game) {
        cards = parseList(message);

        LinkedList<CardType> cardList = new LinkedList<>();

        for (String card : cards) {
            cardList.add(mapa.get(card));
        }
        Player player =  null;
        //System.out.println("plaersSize:"+game.getPlayers().length);
        for(Player plr: game.getPlayers()){
            //System.out.println("plaersSize:"+plr.getName());
            if(plr.getName().equals( MessageMapper.BOT_ALIAS)) {
                player = plr;
                break;
            }
        }
        player.setCards(cardList);
        System.out.println(player.toString());
        game.setOurPlayer(player);
    }
}
