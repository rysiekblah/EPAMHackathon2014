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
    private static Player createPlayerWithUsedCards(CardType ... cards){
        LinkedList<CardType> cardList=new LinkedList<>();
        for(CardType card : cards){
            cardList.add(card);
        }
        Player player=new Player(cardList);
        for(CardType card : cards){
            player.playCard(card);
        }
        return player;
    }
    @Test
    public void test1(){
        Player red=createPlayerWithUsedCards(CardType.CARD_1, CardType.CARD_10);
        Player blue=createPlayerWithUsedCards(CardType.CARD_3, CardType.CARD_6);
        Player green=createPlayerWithUsedCards(CardType.CARD_2,CardType.CARD_2);
        Player [] playerArray = {green,red,blue};
        Game game = new Game(playerArray);
        ScoreCounter.updateScores(game);
        System.out.println("test1:"+red.getCurrentScore() +":"+blue.getCurrentScore()+":"+green.getCurrentScore());
    }

    @Test
    public void testWinter(){
        Player red=createPlayerWithUsedCards(CardType.CARD_1, CardType.CARD_10);
        Player blue=createPlayerWithUsedCards(CardType.CARD_3, CardType.CARD_6);
        Player green=createPlayerWithUsedCards(CardType.CARD_2,CardType.ZIMA);
        Player [] playerArray = {green,red,blue};
        Game game = new Game(playerArray);
        ScoreCounter.updateScores(game);
        System.out.println("zima:"+red.getCurrentScore() +":"+blue.getCurrentScore()+":"+green.getCurrentScore());
    }

    @Test
    public void testSpring(){
        Player red=createPlayerWithUsedCards(CardType.CARD_1, CardType.CARD_10);
        Player blue=createPlayerWithUsedCards(CardType.CARD_3, CardType.CARD_6);
        Player green=createPlayerWithUsedCards(CardType.CARD_2,CardType.WIOSNA);
        Player [] playerArray = {green,red,blue};
        Game game = new Game(playerArray);
        ScoreCounter.updateScores(game);
        System.out.println("wiosna:"+red.getCurrentScore() +":"+blue.getCurrentScore()+":"+green.getCurrentScore());
    }

    @Test
    public void testDrummer(){
        Player red=createPlayerWithUsedCards(CardType.CARD_1, CardType.CARD_10);
        Player blue=createPlayerWithUsedCards(CardType.CARD_3, CardType.CARD_6);
        Player green=createPlayerWithUsedCards(CardType.CARD_2,CardType.DOBOSZ,CardType.CARD_3);
        Player [] playerArray = {green,red,blue};
        Game game = new Game(playerArray);
        ScoreCounter.updateScores(game);
        System.out.println("dobosz:"+red.getCurrentScore() +":"+blue.getCurrentScore()+":"+green.getCurrentScore());
    }

}
