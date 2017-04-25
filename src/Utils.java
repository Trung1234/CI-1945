import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by My PC on 15/04/2017.
 */
public class Utils {// utilities : tien ich
    public static Image loadImage(String path) {
        Image image = null;
        try {
            image = ImageIO.read(new File(path));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
