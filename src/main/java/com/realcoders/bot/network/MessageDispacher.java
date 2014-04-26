package com.realcoders.bot.network;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by tomek on 4/26/14.
 */
public class MessageDispacher implements MessageProvider {

    private Client client;
    private boolean isRunning;
    private ConcurrentLinkedQueue<String> messages = new ConcurrentLinkedQueue<String>();
    private Thread worker = new Thread() {
        @Override
        public void run() {
            while (isRunning) {
                try {
                    String msg = client.receiveMsg();
                    System.out.println(msg);
                    //if(msg!=null)
                        messages.add(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public MessageDispacher() {
        client = new Client("localhost", 1234);
    }

    public void start() {
        try {
            client.connect();
            System.out.println("connected");
            client.sendMsg("AUTH password");
            isRunning = true;
            worker.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        isRunning = false;

    }

    @Override
    public String retrieveMessage() {
        return messages.poll();
    }


}
