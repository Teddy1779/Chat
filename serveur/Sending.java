package chat;

import client.Client;
import main.Main;
import static function.Function.*;


public class Sending extends Thread {

    String Path;
    int nbActu = 0;
    String[][] allMessage;

    public Sending(Client client) {
        Path = Main.filename+client.getGroup()+".txt";

        start();
    }

    private void sendingMess(Client client) throws Exception{
        allMessage = getData(Path);
        client.getOutput().writeObject(allMessage);
        client.getOutput().flush();
    }

    @Override
    public void run() {
        while (true) {
            try {
                int nbtemp = countline(Path);
                if(nbtemp > nbActu) {
                    for (Client c: Main.tabclient) {
                        if (Path.contains(c.getGroup())) {
                            sendingMess(c);
                        }
                    }
                }
                nbActu = nbtemp;

            }catch (Exception j){
                throw new RuntimeException(j);
            }


        }
    }
}
