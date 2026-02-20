package object;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Boots extends SuperObject {

	GamePanel gp;

	public OBJ_Boots(GamePanel gp) {

		this.gp = gp;

		name = "Boots";

		try (InputStream is = getClass().getResourceAsStream("/objects/boots.png")) {
			if (is == null) {
				System.err.println("Resource not found: /objects/boots.png");
			} else {
				image = ImageIO.read(is);
				uTool.scaleImage(image, gp.tileSize, gp.tileSize);
				if (image == null) {
					System.err.println("Failed to decode image: /objects/boots.png");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
