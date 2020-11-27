package perseguidor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Juego extends JPanel implements KeyListener, Runnable {

	private static final long serialVersionUID = 1L;
	private int anchoJuego;
	private int largoJuego;
	private int tiempoDeEsperaEntreActualizaciones;
	private ElementoBasico jugador;
	private ElementoBasico enemigo;

	public Juego(int anchoJuego, int largoJuego, int tiempoDeEsperaEntreActualizaciones, int enemigosPorLinea,
			int filasDeEnemigos, int vidas) {
		this.anchoJuego = anchoJuego;
		this.largoJuego = largoJuego;
		this.jugador = new Jugador(30, largoJuego - 20, 0, 0, 40, 40, Color.red);
		this.enemigo = new Enemigo(30, largoJuego - 20, 0, 0, 40, 40, Color.blue);
		this.tiempoDeEsperaEntreActualizaciones = tiempoDeEsperaEntreActualizaciones;
		inicializarJuego();
	}

	private void inicializarJuego() {
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(anchoJuego, largoJuego);
	}

	/*
	 * Actualizar la actualizacion y el dibujado del juego de esta forma no es
	 * recomendable dado que tendra distintas velocidades en distinto hardware. Se
	 * hizo asi por simplicidad para facilitar el aprendizaje dado que lo
	 * recomendado es separar la parte de dibujado de la de actualizacion y usar
	 * interpolation
	 */
	@Override
	public void run() {
		while (true) {
			actualizarJuego();
			dibujarJuego();
			esperar(tiempoDeEsperaEntreActualizaciones);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			jugador.setVelocidadX(1);
		}

		if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			jugador.setVelocidadX(-1);
		}
		
		if (arg0.getKeyCode() == KeyEvent.VK_UP) {
			jugador.setVelocidadY(-1);
		}
		
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			jugador.setVelocidadY(1);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT || arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			jugador.setVelocidadX(0);
		}
		if (arg0.getKeyCode() == KeyEvent.VK_UP || arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			jugador.setVelocidadY(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	// Este metodo se llama cuando se hace un this.repaint() automaticamente
	// Aca se dibujan a todos los elementos, para ello cada elemento implementa el
	// metodo dibujarse
	protected void paintComponent(Graphics g) {
		this.limpiarPantalla(g);
		jugador.dibujarse(g);
		enemigo.dibujarse(g);
	}

	private void actualizarJuego() {
		verificarEstadoAmbiente();
		jugador.moverse();
		enemigo.moverse();
	}

	private void dibujarJuego() {
		this.repaint();
	}

	private void verificarEstadoAmbiente() {
		if (enemigo.getPosicionX() < jugador.getPosicionX()) {
			enemigo.setVelocidadX(1);
		} else {
			enemigo.setVelocidadX(-1);
		}
		
		if (enemigo.getPosicionY() < jugador.getPosicionY()) {
			enemigo.setVelocidadY(1);
		} else {
			enemigo.setVelocidadY(-1);
		}
	}

	private void limpiarPantalla(Graphics graphics) {
		graphics.setColor(Color.cyan);
		graphics.fillRect(0, 0, anchoJuego, largoJuego);
	}

	private void esperar(int milisegundos) {
		try {
			Thread.sleep(milisegundos);
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}
	}
}
