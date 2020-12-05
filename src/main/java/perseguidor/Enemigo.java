package perseguidor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class Enemigo extends ElementoBasico {

	private BufferedImage img;

	public Enemigo(int posicionX, int posicionY, double velocidadX, double velocidadY, int ancho, int largo,
			Color color) {
		super(posicionX, posicionY, velocidadX, velocidadY, ancho, largo, color);
		String path = Paths.get(Enemigo.class.getClassLoader().getResource("imagenes/android.png").getPath())
				.toString();
		try {
			this.img = ImageIO.read(new File(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void dibujarse(Graphics graphics) {
		try {
			graphics.drawImage(img, (int) getPosicionX(), (int) getPosicionY(), this.getAncho(), this.getLargo(), null);
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
	}

	public void moverse() {
		setPosicionX(getPosicionX() + getVelocidadX() * 0.25);
		setPosicionY(getPosicionY() + getVelocidadY() * 0.25);
	}

}
