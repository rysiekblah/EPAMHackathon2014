package com.realcoders.bot;

import com.realcoders.bot.network.MessageDispacher;
import com.realcoders.bot.network.MessageReceiverRunnable;

/**
 * Created by tomek on 4/26/14.
 */
public class Bot {

	private final MessageDispacher dispacher = new MessageDispacher();

	public static void main(String args[]) {
		Bot bot = new Bot();
		bot.dispacher.start();
		Thread messageHandlerWorker = new Thread(new MessageReceiverRunnable(
				bot.dispacher));
		messageHandlerWorker.start();
	}
}
