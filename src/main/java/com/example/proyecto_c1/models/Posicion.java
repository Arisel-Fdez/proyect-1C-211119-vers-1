package com.example.proyecto_c1.models;

public class Posicion {
    private int x;
    private int y;
    private  int id;


    public  Posicion(){

    }

    public Posicion(int x, int id, int y) {
        this.x = x;
        this.id = id;
        this.y = y;
    }






    public int getX() {
        return x;
    }

    public int getId() {
        return id;
    }

    public void setX(int x) {
        this.x = x;
    }
    public  int getY(){return  y;}
    public  void setY(int y){this.y = y;}

    public void setId(int id) {
        this.id = id;
    }
}
