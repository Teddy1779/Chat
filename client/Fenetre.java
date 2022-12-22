package client;

import javax.swing.*;
import java.awt.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import group.Threadtxt;

public class Fenetre extends JFrame {

    JTextArea allMes;
    JTextField inp = new JTextField();
    JButton btn = new JButton("Send");
    JScrollPane scroll = new JScrollPane();

    public Fenetre(String title, DataOutputStream out , ObjectInputStream in){
        initFrame(title);

        inp.setBounds(45,350,200,30);
        add(inp);

        btn.setBounds(250,350,100,30);
        add(btn);
        btn.addActionListener(new Listener(inp,out));

        allMes = new JTextArea();
        allMes.setEditable(false);

        scroll.setViewportView(allMes);
        scroll.setPreferredSize(new Dimension(400,300));
        scroll.setBounds(45,20,300,300);
        add(scroll);


        setVisible(true);
        new Threadtxt(in,allMes);
    }


    public void initFrame(String title) {
        setTitle(title);
        setSize(400,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
    }
}
