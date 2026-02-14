package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

public class GamePanel extends JPanel implements Runnable {

	// Screen Settings
	final int originalTitleSize = 16; // 16x16 tile
	final int scale = 3;

	public final int tileSize = originalTitleSize * scale; // 48x48 tile

	final int maxScreenCol = 16; // 16 tiles horizontalmente e 12 tiles verticalmente.
	final int maxScreenRow = 12; // basicamente 16 por 12

	final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	final int screenHeight = tileSize * maxScreenRow; // 576 pixels

	// FPS
	int FPS = 60;

	KeyHandler keyH = new KeyHandler();
	Thread gameThread; // ao iniciar, automaticamente chama o método run()
	Player player = new Player(this, keyH);

	// Setar a posição default do personagem
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;

	public GamePanel() {

		this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // tamanho da tela
		this.setBackground(Color.black); // fundo preto
		this.setDoubleBuffered(true); // melhora o render do game
		this.addKeyListener(keyH); // reconhecer os inputs do teclado
		this.setFocusable(true); // GamePanel fica "focado" para receber os inputs
	}

	public void startGameThread() {
		gameThread = new Thread(this); // this significa a classe toda
		gameThread.start();
	}

//	@Override
//	public void run() {
//
//		// 1000000000 nanoseconds = 1 second
//		// tela será desenhada de acordo com essa divisão
//
//		double drawInterval = 1000000000 / FPS;
//		double nextDrawTime = System.nanoTime() + drawInterval;
//
//		while (gameThread != null) {
//
//			// UPDATE: atualizar informações. ex: posição do personagem
//			update();
//
//			// DRAW: desenhar a tela com a informação atualizada
//			repaint(); // chamada do método paintComponent
//
//			try {
//				double remainingTime = nextDrawTime - System.nanoTime();
//				remainingTime = remainingTime / 1000000; // conversão para milliseconds
//
//				if (remainingTime < 0) {
//					remainingTime = 0;
//				}
//
//				Thread.sleep((long) remainingTime);
//
//				nextDrawTime += drawInterval;
//
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	public void run() {

		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;

		while (gameThread != null) {

			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			if (delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}

			if (timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
	}

	public void update() {

		player.update();

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		player.draw(g2);

		g2.dispose();
	}
}
