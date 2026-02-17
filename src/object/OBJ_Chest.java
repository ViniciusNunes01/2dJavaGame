package object;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class OBJ_Chest extends SuperObject {

	public OBJ_Chest() {

		name = "Chest";

		try (InputStream is = getClass().getResourceAsStream("/objects/chest.png")) {
			if (is == null) {
				System.err.println("Resource not found: /objects/chest.png");
			} else {
				image = ImageIO.read(is);
				if (image == null) {
					System.err.println("Failed to decode image: /objects/chest.png");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
