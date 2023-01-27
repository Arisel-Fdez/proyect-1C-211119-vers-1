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
    private Enemigos C4;
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
    private ImageView idenemigo4;

    @FXML
    void AbajoOnMouse(MouseEvent event) {

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
        Thread hilo4 = new Thread(C3);
        hilo4.setDaemon(true);
        hilo4.start();

        C4 = new Enemigos(4);
        C4.addObserver(this);
        C4.setPosicion(420,4, 250);
        Thread hilo5 = new Thread(C3);
        hilo5.setDaemon(true);
        hilo5.start();


        P1 = new Personaje(5);
        P1.addObserver((this));
        P1.setPosicion(461 ,5);
        Thread hilo3 = new Thread(P1);
        hilo3.setDaemon(true);
        hilo3.start();


        System.out.println(idpersona.getLayoutY());


    }

    @FXML
    void ReiniciarOnMouse(MouseEvent event) {
        P1.setStatus(false);
        C1.setStatus(false);
        C2.setStatus(false);
        P1.setPosicion(554 ,3);

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
                Platform.runLater(() ->  idenemigo4.setLayoutX(pos1.getX()));
                break;
            case 5:
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
            C4.setStatus(false);
        }

        if (idpersona.getBoundsInParent().intersects(idenemigo1.getBoundsInParent())){
            P1.setStatus(false);
            C1.setStatus(false);
            C2.setStatus(false);
            C3.setStatus(false);
            C4.setStatus(false);
        }
        if (idpersona.getBoundsInParent().intersects(idenemigo3.getBoundsInParent())){
            P1.setStatus(false);
            C1.setStatus(false);
            C2.setStatus(false);
            C3.setStatus(false);
            C4.setStatus(false);
        }
        if (idpersona.getBoundsInParent().intersects(idenemigo4.getBoundsInParent())){
            P1.setStatus(false);
            C1.setStatus(false);
            C2.setStatus(false);
            C3.setStatus(false);
            C4.setStatus(false);
        }

      /*  if (idpersona.getLayoutY() <= 14){
            P1.setStatus(false);
            C1.setStatus(false);
            C2.setStatus(false);
        }*/



    }


}