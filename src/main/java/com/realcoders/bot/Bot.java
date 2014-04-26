package com.realcoders.bot;

import com.realcoders.bot.network.MessageDispacher;
import com.realcoders.bot.network.MessageMapper;
import com.realcoders.bot.network.MessageReceiverRunnable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by tomek on 4/26/14.
 */
public class Bot {



	public static void main(String args[]) throws IOException {
        String name = args[0];
        String pass = args[1];

        String host = "localhost";
        int port =1234;
        BufferedReader br = new BufferedReader(new FileReader("startup-info"));
        try {
            String hostAndPort=br.readLine();
            if(hostAndPort.split(":").length==2){
                String [] tab=hostAndPort.split(":");
                host=tab[0];
                port=Integer.parseInt(tab[1]);
            }
            pass = br.readLine();
        } finally {
            br.close();
        }
        System.out.println(host+":"+port);
        Bot bot = new Bot();
        MessageMapper.BOT_ALIAS = name;
        MessageDispacher dispacher = new MessageDispacher(name, pass,host,port);
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
