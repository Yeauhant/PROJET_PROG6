package IHM;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomMouseAdapter extends MouseAdapter {
    EventsCollector c;

    CustomMouseAdapter(EventsCollector c) {
        this.c = c;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
}