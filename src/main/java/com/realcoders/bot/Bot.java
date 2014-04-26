package com.realcoders.bot;

import com.realcoders.bot.network.MessageDispacher;
import com.realcoders.bot.network.MessageMapper;
import com.realcoders.bot.network.MessageReceiverRunnable;

/**
 * Created by tomek on 4/26/14.
 */
public class Bot {



	public static void main(String args[]) {
        String name = args[0];
        String pass = args[1];
        Bot bot = new Bot();
        MessageMapper.BOT_ALIAS = name;
        MessageDispacher dispacher = new MessageDispacher(name, pass);
		dispacher.start();
		Thread messageHandlerWorker = new Thread(new MessageReceiverRunnable(
				dispacher));
		messageHandlerWorker.start();
        while(dispacher.isRunning())
            try {
                //System.out.println("---"+dispacher.isRunning());
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.exit(1);
	}
}
