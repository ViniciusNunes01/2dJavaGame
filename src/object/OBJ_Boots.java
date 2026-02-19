package object;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class OBJ_Boots extends SuperObject {

	public OBJ_Boots() {

		name = "Boots";

		try (InputStream is = getClass().getResourceAsStream("/objects/boots.png")) {
			if (is == null) {
				System.err.println("Resource not found: /objects/boots.png");
			} else {
				image = ImageIO.read(is);
				if (image == null) {
					System.err.println("Failed to decode image: /objects/boots.png");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
