package com.realcoders.bot;

import com.google.common.collect.Lists;
import com.realcoders.bot.network.MessageDispacher;
import com.realcoders.bot.network.MessageReceiverRunnable;

import java.util.List;

/**
 * Created by tomek on 4/26/14.
 */
public class Bot {

    private MessageDispacher dispacher = new MessageDispacher();

    public static void main(String args[]) {
        Bot bot = new Bot();
        bot.dispacher.start();
        Thread messageHandlerWorker = new Thread(new MessageReceiverRunnable(bot.dispacher));
        messageHandlerWorker.start();
    }
}
