package npro27;
import java.awt.*;

/**
 * Created by Cube27 on 04.05.2017.
 */
public abstract class Scene {
    protected final Game game;

    public Scene(Game game){
        this.game=game;
    }
    public abstract void update(long nanosPassed);
    public abstract void draw(Graphics2D g);

}
