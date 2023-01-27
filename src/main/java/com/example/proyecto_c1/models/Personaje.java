package com.example.proyecto_c1.models;

import java.util.Observable;

public class Personaje extends Observable implements Runnable{
    private Posicion pos;
    private int id;
    private boolean status = true;

    private boolean arriba = false;
    private boolean abajo = false;


    public void setArriba() {
        pos.setX(pos.getX() - 1) ;
    }

    public void setArriba(boolean arriba) {
        this.arriba = arriba;
    }

    public Personaje() {
    }


    public void setAbajo() {
        pos.setX(pos.getX() -1) ;
    }

    public void setAbajo(boolean abajo) {
        this.abajo = abajo;
    }




    public Personaje(int id) {
        this.id = id;
        pos = new Posicion();
    }
    public void setPosicion(int y,int id){
        pos.setId(id);
        pos.setX(y);
    }

    @Override
    public void run() {
        while (status) {
            this.setChanged();
            this.notifyObservers(this.pos);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
            if (arriba  == true){
                pos.setX(pos.getX() -20);
                arriba = false;
            }
        }

        while (status) {
            this.setChanged();
            this.notifyObservers(this.pos);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
            if (abajo  == true){
                pos.setX(pos.getX() -20);
                abajo = false;
            }
        }
    }

    public void setStatus (boolean status){
        this.status = status;
    }

}
