package com.realcoders.bot.message;

import com.realcoders.bot.Game;
import com.realcoders.bot.network.MessageMapper;

/**
 * Created by tomek on 4/26/14.
 */
public class GameEndHandler extends MessageHandler {
	@Override
	public void handle(String message, Game game) {
		if (message.contains(MessageMapper.BOT_ALIAS)) {
			System.out.println("WYGRALISMY!");
			Runtime.getRuntime().exit(0);
		} else {
			System.out.println("PREZGRALISMY?");
			Runtime.getRuntime().exit(0);
		}
	}
}
