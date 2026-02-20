package object;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Chest extends SuperObject {

	GamePanel gp;

	public OBJ_Chest(GamePanel gp) {

		this.gp = gp;

		name = "Chest";

		try (InputStream is = getClass().getResourceAsStream("/objects/chest.png")) {
			if (is == null) {
				System.err.println("Resource not found: /objects/chest.png");
			} else {
				image = ImageIO.read(is);
				uTool.scaleImage(image, gp.tileSize, gp.tileSize);
				if (image == null) {
					System.err.println("Failed to decode image: /objects/chest.png");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
