package perseguidor;

import java.awt.Color;
import java.awt.Graphics;

public class Enemigo extends ElementoBasico {

    public Enemigo(int posicionX, int posicionY, double velocidadX, double velocidadY, int ancho, int largo,
            Color color) {
        super(posicionX, posicionY, velocidadX, velocidadY, ancho, largo, color);
    }

    public void dibujarse(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.fillOval((int)getPosicionX(), (int)getPosicionY(), getAncho(), getLargo());
    }
    
    public void moverse() {
    	setPosicionX(getPosicionX() + getVelocidadX()*0.5);
    	setPosicionY(getPosicionY() + getVelocidadY()*0.5);
    }
    
    

}
