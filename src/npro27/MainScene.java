package npro27;

/**
 * Created by Cube27 on 05.05.2017.
 */
import java.awt.*;
public class MainScene extends Scene {
    public MainScene(Game game) {
        super(game);
    }
    @Override
    public void update(long nanosPassed) {
        // Nothing to do here
    }
    @Override
    public void draw(Graphics2D g) {
        g.setFont(new Font("Default", Font.BOLD, 30));
        g.drawString("It Works!", 64, 64);
    }
}
