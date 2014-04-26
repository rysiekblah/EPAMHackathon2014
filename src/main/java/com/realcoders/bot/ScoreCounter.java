package com.realcoders.bot;

/**
 * Created by Arek on 2014-04-26.
 */
public class ScoreCounter {


    public static void updateScores(Game game){
        boolean isWinterInGame=isWinterInGame(game);
        boolean isSummerInGame=isSummerInGame(game);
        int strongestCard=0;
        if(isSummerInGame){
            strongestCard=getStrongestCard(game);
        }
        for(Player player : game.getPlayers()){
            int playerScore=0;
            int multiplier=1;
            if(playerUsedDrummer(player))
                multiplier=2;
            if(isWinterInGame){
                for(CardType card : player.getUsed()){
                    if(card.isMercenary())
                        playerScore+=1*multiplier;
                    else
                        playerScore+=card.getPower();
                }
            }
            else if(isSummerInGame){
                for(CardType card : player.getUsed()){
                    if(card.getPower()==strongestCard) {
                        if (card.isMercenary())
                            playerScore += card.getPower() * multiplier + 3;
                        else
                            playerScore += card.getPower()  + 3;

                    }else{
                        if (card.isMercenary())
                            playerScore += card.getPower() * multiplier;
                        else
                            playerScore += card.getPower();

                    }
                }
            } else{
                for(CardType card : player.getUsed())
                     playerScore+=card.getPower();
            }
            player.setCurrentScore(playerScore);
        }
    }

    private static boolean playerUsedDrummer(Player player) {
        return false;
    }

    private static int getStrongestCard(Game game) {
        int strongest=0;
        for (Player player : game.getPlayers())
            for (CardType card : player.getUsed())
                if (card.getPower()>strongest)
                    strongest=card.getPower();

        return strongest;
    }

    private static boolean isWinterInGame(Game game){
        for (Player player : game.getPlayers())
            for (CardType card : player.getUsed())
                if (card.equals(CardType.ZIMA))
                    return true;

        return false;
    }

    private static boolean isSummerInGame(Game game) {
        for (Player player : game.getPlayers())
            for (CardType card : player.getUsed())
                if (card.equals(CardType.WIOSNA))
                    return true;

        return false;
    }
}
