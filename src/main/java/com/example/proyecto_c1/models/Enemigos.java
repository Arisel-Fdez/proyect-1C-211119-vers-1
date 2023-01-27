package com.example.proyecto_c1.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Observable;
import java.util.Random;

public class Enemigos extends Observable implements Runnable {
    private int id ;
    private Posicion pos;

    private boolean status = true;
    private int distanciax = 10;
    private int distanciaY = 10;

    public Enemigos(int id) {
        this.id = id;
        pos = new Posicion();
    }
    public void setPosicion(int x, int id, int y){
        pos.setX(x);
        pos.setId(id);
        pos.setY(y);
    }
    @Override
    public void run() {
        while (status) {
            this.setChanged();
            this.notifyObservers(this.pos);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {}
            pos.setX(pos.getX() + distanciax);
            pos.setY(pos.getY() + distanciaY);
            if (pos.getX() >= 1011)
                distanciax *= -1;
            if (pos.getX() <= 0)
                distanciax *= -1;
            if (pos.getY() >= 1000)
                distanciaY *= -1;
            if (pos.getY() <= 0);
                distanciaY *= -1;
        }
    }
    public void setStatus (boolean status){
        this.status = status;
    }
}
