package object;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Key extends SuperObject {

	GamePanel gp;

	public OBJ_Key(GamePanel gp) {

		this.gp = gp;

		name = "Key";

		try (InputStream is = getClass().getResourceAsStream("/objects/key.png")) {
			if (is == null) {
				System.err.println("Resource not found: /objects/key.png");
			} else {
				image = ImageIO.read(is);
				uTool.scaleImage(image, gp.tileSize, gp.tileSize);
				if (image == null) {
					System.err.println("Failed to decode image: /objects/key.png");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
