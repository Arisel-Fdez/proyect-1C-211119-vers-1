package com.example.proyecto_c1.controller;

import com.example.proyecto_c1.HelloApplication;
import com.example.proyecto_c1.models.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.Observable;
import java.util.Observer;

public class HelloController implements Observer {


    private Enemigos C1;
    private Enemigos C2;
    private Enemigos C3;
    private Personaje P1;


    @FXML
    private Button idAbajo;

    @FXML
    private Button idArriba;

    @FXML
    private Button idIniciar;


    @FXML
    private ImageView idpersona;
    @FXML
    private Button idReiniciar;

    @FXML
    private AnchorPane rootScene;

    @FXML
    private ImageView idenemigo1;

    @FXML
    private ImageView idenemigo2;

    @FXML
    private ImageView idenemigo3;


    @FXML
    void AbajoOnMouse(MouseEvent event) {
        P1.setAbajo();
        P1.setAbajo(false);
    }

    @FXML
    void ArribaOnMouse(MouseEvent event) {
        P1.setArriba();
        P1.setArriba(true);
    }

    @FXML
    void IniciarOnMouse(MouseEvent event) {
        C1 = new Enemigos(1);
        C1.addObserver(this);
        C1.setPosicion(150,1, 14);
        Thread hilo1 = new Thread(C1);
        hilo1.setDaemon(true);
        hilo1.start();


        C2 = new Enemigos(2);
        C2.addObserver(this);
        C2.setPosicion(250,2, 514);
        Thread hilo2 = new Thread(C2);
        hilo2.setDaemon(true);
        hilo2.start();

        C3 = new Enemigos(3);
        C3.addObserver(this);
        C3.setPosicion(420,3, 250);
        Thread hilo3 = new Thread(C3);
        hilo3.setDaemon(true);
        hilo3.start();


        P1 = new Personaje(4);
        P1.addObserver((this));
        P1.setPosicion(461 ,4);
        Thread hilo5 = new Thread(P1);
        hilo5.setDaemon(true);
        hilo5.start();


        System.out.println(idpersona.getLayoutY());


    }

    @FXML
    void SaliOnMouse(MouseEvent event) {
        System.exit(1);
    }

    @Override
    public void update(Observable o, Object arg) {
        Posicion pos1 = (Posicion)arg;

        switch (pos1.getId()){
            case 1:
                Platform.runLater(() ->  idenemigo1.setLayoutX(pos1.getX()));
                break;
            case 2:
                Platform.runLater(() ->  idenemigo2.setLayoutX(pos1.getX()));
                break;
            case 3:
                Platform.runLater(() ->  idenemigo3.setLayoutX(pos1.getX()));
                break;
            case 4:
                Platform.runLater(() ->  {
                            idpersona.setLayoutY(pos1.getX());
                            HelloApplication.stage.sizeToScene();
                        }
                );
                break;
        }

        if (idpersona.getBoundsInParent().intersects(idenemigo2.getBoundsInParent())){
            P1.setStatus(false);
            C1.setStatus(false);
            C2.setStatus(false);
            C3.setStatus(false);
        }

        if (idpersona.getBoundsInParent().intersects(idenemigo1.getBoundsInParent())){
            P1.setStatus(false);
            C1.setStatus(false);
            C2.setStatus(false);
            C3.setStatus(false);
        }
        if (idpersona.getBoundsInParent().intersects(idenemigo3.getBoundsInParent())){
            P1.setStatus(false);
            C1.setStatus(false);
            C2.setStatus(false);
            C3.setStatus(false);
        }

        if (idpersona.getLayoutY() <= 14){
            P1.setStatus(false);
            C1.setStatus(false);
            C2.setStatus(false);
            C3.setStatus(false);
        }



    }


}