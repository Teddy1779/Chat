package group;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Threadtxt extends Thread{

    ObjectInputStream in;
    JTextArea mess;
    private int read=0;

    public Threadtxt(ObjectInputStream in, JTextArea mess) {
        this.in = in;
        this.mess = mess;
        start();
    }

    private void show_message(String[][] mess) {
        for (int i=read; i<mess.length; i++) {
            this.mess.setText(this.mess.getText()+"\n"+mess[i][0]+" > "+mess[i][1]);
        }
    }

    @Override
    public void run() {
        String[][] allMessage;
        Object mess;
        while (true) {
            try {
                mess = in.readObject();
                if(mess instanceof String[][]) {
                    allMessage = (String[][]) mess;
                    show_message(allMessage);
                    read = allMessage.length;
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
