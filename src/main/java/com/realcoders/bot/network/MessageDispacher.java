package com.realcoders.bot.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by tomek on 4/26/14.
 */
public class MessageDispacher implements MessageProvider {

    private static Client client;
    private boolean isRunning;
    private ConcurrentLinkedQueue<String> messages = new ConcurrentLinkedQueue<String>();
    private ArrayList<String> temporary = new ArrayList<String>();
    private Thread worker = new Thread() {
        @Override
        public void run() {
            while (isRunning) {
                try {
                    String msg = client.receiveMsg();
                    System.out.println(msg);
                    if(!msg.startsWith("?"))
                        temporary.add(msg);
                    else {

                        String tmpMsg=null;
                        for(String line:temporary){
                            if(tmpMsg!=null){
                                tmpMsg+=line+'\n';
                                if(line.contains("]")){
                                    messages.add(tmpMsg);
                                    tmpMsg=null;
                                }

                            }else if(line.contains("[")){
                                tmpMsg=line+'\n';
                            }else{
                                messages.add(line);
                            }
                        }
                        messages.add(msg);

                        temporary = new ArrayList<String>();
                    }
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
            client.sendMsg("AUTH password\n");
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

    public static void send(String msg) {
        try {
            client.sendMsg(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
