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
    private DataOutputStream dataToArena;
    private BufferedReader dataFromArena;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() throws IOException {
        socket = new Socket(host, port);
        dataToArena = new DataOutputStream(socket.getOutputStream());
        dataFromArena = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void disconnect() throws IOException {
        socket.close();
    }

    public String send(String msg) throws IOException {
        dataToArena.writeBytes(msg);
        return dataFromArena.readLine();
    }

    public void sendMsg(String msg) throws IOException {
        dataToArena.writeBytes(msg);
    }

    public String receiveMsg() throws IOException {
        String msg;
        while((msg = dataFromArena.readLine()) == null);
        return msg;
    }
}
