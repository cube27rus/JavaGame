package npro27;

/**
 * Created by Cube27 on 05.05.2017.
 */
import java.awt.*;
public class DesktopLauncher {
    public static void main(String[] args) {
        Game game = DesktopGameBuilder.build(new Dimension(640, 480));
        game.setScene(new MainScene(game));
        game.start();
    }
}
