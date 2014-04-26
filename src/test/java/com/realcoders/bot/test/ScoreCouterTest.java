package com.realcoders.bot.test;

import com.realcoders.bot.CardType;
import com.realcoders.bot.Game;
import com.realcoders.bot.Player;
import com.realcoders.bot.ScoreCounter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Arek on 2014-04-26.
 */
public class ScoreCouterTest {
    @Test
    public void test1(){
        LinkedList<CardType> redList=new LinkedList<>();
        redList.add(CardType.CARD_1);
        Player red=new Player(redList);
        red.playCard(CardType.CARD_1);
        LinkedList<CardType> blueList=new LinkedList<>();
        blueList.add(CardType.CARD_2);
        Player blue=new Player(blueList);
        blue.playCard(CardType.CARD_2);
        LinkedList<CardType> greenList=new LinkedList<>();
        greenList.add(CardType.CARD_3);
        greenList.add(CardType.CARD_4);
        Player green=new Player(greenList);
        green.playCard(CardType.CARD_3);
        green.playCard(CardType.CARD_4);
        Player [] playerArray = {green,red,blue};
        Game game = new Game(playerArray);
        ScoreCounter.updateScores(game);
        System.out.println(red.getCurrentScore() +":"+blue.getCurrentScore()+":"+green.getCurrentScore());
    }
}
