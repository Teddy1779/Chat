package chat;

import client.*;
import main.*;

import java.io.IOException;


public class Chat extends Thread {

    String path;
    Client client;

    public Chat(Client client) {
        this.client = client;
        this.path = Main.filename+client.getGroup();

        start();
    }

    @Override
    public void run() {
        String newMessage;
        String value;
        while (true) {
            try {
                newMessage = client.getInput().readUTF();
                value = client.getNom()+"--> "+newMessage;
                function.Function.save(value,path);

            } catch (IOException e) {
                Main.tabclient.remove(client);
            }
        }
    }
}
