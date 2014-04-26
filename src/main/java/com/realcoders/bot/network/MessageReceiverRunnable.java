package com.realcoders.bot.network;

/**
 * Created by tomek on 4/26/14.
 */
public class MessageReceiverRunnable implements Runnable {

    private MessageProvider provider;
    private boolean isRunnign = true;
    private MessageMapper mapper = new MessageMapper();

    public MessageReceiverRunnable(MessageProvider provider) {
        this.provider = provider;
    }

    @Override
    public void run() {

        while (isRunnign) {
            String message = provider.retrieveMessage();
            mapper.getHandler(message).handle(message);
        }
    }

    public void kill() {
        isRunnign = false;
    }
}
