package main;

import client.Fenetre;

import java.io.*;
import java.net.Socket;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket;

        String ip = JOptionPane.showInputDialog("IP ADRESS");
        socket = new Socket(ip,5000);

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String st = JOptionPane.showInputDialog("NAME");
        out.writeUTF(st);

        String group = JOptionPane.showInputDialog("GROUP");
        out.writeUTF(group);


        DataOutputStream out1 = new DataOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        new Fenetre(st,out1,in);

    }
}