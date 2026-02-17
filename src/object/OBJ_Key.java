package object;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class OBJ_Key extends SuperObject {

	public OBJ_Key() {
		name = "Key";

		try (InputStream is = getClass().getResourceAsStream("/objects/key.png")) {
			if (is == null) {
				System.err.println("Resource not found: /objects/key.png");
			} else {
				image = ImageIO.read(is);
				if (image == null) {
					System.err.println("Failed to decode image: /objects/key.png");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
