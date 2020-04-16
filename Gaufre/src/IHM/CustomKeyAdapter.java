package IHM;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CustomKeyAdapter extends KeyAdapter {

    EventsCollector c;

    CustomKeyAdapter(EventsCollector c) {
        this.c = c;
    }

    @Override
    public void keyPressed(KeyEvent e) {}
}
