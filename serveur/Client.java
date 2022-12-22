package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client {
    String nom;
    String group;
    DataInputStream input;
    ObjectOutputStream output;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public DataInputStream getInput() {
        return input;
    }

    public void setInput(DataInputStream input) {
        this.input = input;
    }

    public ObjectOutputStream getOutput() {
        return output;
    }

    public void setOutput(ObjectOutputStream output) {
        this.output = output;
    }
}