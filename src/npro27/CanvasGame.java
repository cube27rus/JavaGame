package npro27;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Cube27 on 04.05.2017.
 */
public class CanvasGame extends Canvas implements Game,Runnable {
    private Thread gameThread;
    private AtomicBoolean running;
    private Input input;
    private Scene scene;

    public CanvasGame(Dimension screenSize){
        running = new AtomicBoolean(false);
        setSize(screenSize);
        initInput();
        initFocusListener();
    }

    private void initInput() {
        input = new Input();
        addKeyListener(input);
    }

    private void initFocusListener() {
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                start();
            }
            @Override
            public void focusLost(FocusEvent event) {
                pause();
            }
        });
    }


    @Override
    public void start() {
        if (running.compareAndSet(false, true)) {
            gameThread = new Thread(this);
            gameThread.start();
        }

    }

    @Override
    public void pause() {
        if (running.compareAndSet(true, false)) {
            try {
                gameThread.join();
            } catch (InterruptedException exception) {
                throw new RuntimeException(exception);
            }
        }

    }

    @Override
    public Dimension getScreenSize() {

        return getSize();
    }

    @Override
    public Input getInput() {

        return input;
    }

    @Override
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void run() {
        long previousIterationTime = System.nanoTime();
        while (running.get()) {
            if (scene == null) {
                continue;
            }
            long now = System.nanoTime();
            long nanosPassed = now - previousIterationTime;
            previousIterationTime = now;
            Graphics2D g = (Graphics2D)getBufferStrategy().getDrawGraphics();
            scene.update(nanosPassed);
            scene.draw(g);
            getBufferStrategy().show();
        }
    }


}
