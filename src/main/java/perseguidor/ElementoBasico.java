package perseguidor;

import java.awt.Color;
import java.awt.Graphics;

public abstract class ElementoBasico implements Elemento {

    private double posicionX;
    private double posicionY;
    private double velocidadX;
    private double velocidadY;
    private int ancho;
    private int largo;
    private Color color;

    public ElementoBasico(int posicionX, int posicionY, double velocidadX, double velocidadY, int ancho, int largo, Color color) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.velocidadX = velocidadX;
        this.velocidadY = velocidadY;
        this.ancho = ancho;
        this.largo = largo;
        this.color = color;
    }

    public abstract void dibujarse(Graphics graphics);

    public void moverse() {
        posicionX = posicionX + velocidadX;
        posicionY = posicionY + velocidadY;
    }

    public void rebotarEnEjeX() {
        velocidadX = -velocidadX;
    }

    public void rebotarEnEjeY() {
        velocidadY = -velocidadY;
    }

    public double getVelocidadX() {
        return velocidadX;
    }

    public void setVelocidadX(double velocidadX) {
        this.velocidadX = velocidadX;
    }

    public double getVelocidadY() {
        return velocidadY;
    }

    public void setVelocidadY(double velocidadY) {
        this.velocidadY = velocidadY;
    }

    public double getPosicionX() {
        return posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }

    public void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
    }

    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }

    public int getAncho() {
        return ancho;
    }

    public int getLargo() {
        return largo;
    }

    public Color getColor() {
        return color;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
