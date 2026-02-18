package object;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject {

	public OBJ_Door() {

		name = "Door";

		try (InputStream is = getClass().getResourceAsStream("/objects/door.png")) {
			if (is == null) {
				System.err.println("Resource not found: /objects/door.png");
			} else {
				image = ImageIO.read(is);
				if (image == null) {
					System.err.println("Failed to decode image: /objects/door.png");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}

}
