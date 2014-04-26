package com.realcoders.bot.network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by tomek on 4/26/14.
 */
public class Client {

    private String host;
    private int port;
    private Socket socket;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() throws IOException {
        try {
            socket = new Socket(host, port);
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + host + ":" + port);
        }
    }

    public void disconnect() throws IOException {
        socket.close();
    }

    public String send(String msg) throws IOException {
        DataOutputStream dataToArena = new DataOutputStream(socket.getOutputStream());
        BufferedReader dataFromArena = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        dataToArena.writeBytes(msg);
        return dataFromArena.readLine();
    }
}
