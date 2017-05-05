package npro27;
import java.awt.*;

/**
 * Created by Cube27 on 04.05.2017.
 */
public interface Game {
    void start();
    void pause();
    Dimension getScreenSize();
    Input getInput();
    void setScene(Scene scene);
}
