package npro27;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Cube27 on 04.05.2017.
 */
public class Input implements KeyListener {
    private final Collection<KeyEvent> keyPressedEvents;
    private final Collection<KeyEvent> keyReleasedEvents;

    public Input(){
        keyPressedEvents = new ArrayList<KeyEvent>();
        keyReleasedEvents = new ArrayList<KeyEvent>();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        keyPressedEvents.add(e);
    }

    public synchronized Collection<KeyEvent> getKeyPressedEvents() {
        Collection<KeyEvent> events = new ArrayList<KeyEvent>(keyPressedEvents);
        keyPressedEvents.clear();
        return events;
    }
    @Override
    public void keyReleased(KeyEvent e) {
        keyReleasedEvents.add(e);
    }

    public synchronized Collection<KeyEvent> getKeyReleasedEvents() {
        Collection<KeyEvent> events = new ArrayList<KeyEvent>(keyReleasedEvents);
        keyReleasedEvents.clear();
        return events;
    }


}
