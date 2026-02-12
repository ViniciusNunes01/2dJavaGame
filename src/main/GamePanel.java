package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	// Screen Settings
	final int originalTitleSize = 16; // 16x16 tile
	final int scale = 3;

	final int sizeTile = originalTitleSize * scale; // 48x48 tile

	final int maxScreenCol = 16; // 16 tiles horizontalmente e 12 tiles verticalmente.
	final int maxScreenRow = 12; // basicamente 16 por 12

	final int screenWidth = sizeTile * maxScreenCol; // 768 pixels
	final int screenHeight = sizeTile * maxScreenRow; // 576 pixels

	Thread gameThread; // ao iniciar, automaticamente chama o método run()

	public GamePanel() {

		this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // tamanho da tela
		this.setBackground(Color.black); // fundo preto
		this.setDoubleBuffered(true); // melhora o render do game
	}

	public void startGameThread() {
		gameThread = new Thread(this); // this significa a classe toda
		gameThread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
