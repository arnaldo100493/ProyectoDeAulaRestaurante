package consola;

import java.awt.*;

public class Mensaje extends Frame {

    public Mensaje() {

    }

    public Mensaje(String s) {
        this(s, "", null);
    }

    public Mensaje(String s, Frame frame) {
        this(s, "", frame);
    }

    public Mensaje(String s, String s1) {
        this(s, s1, null);
    }

    public Mensaje(String s, String s1, Frame frame) {
        super(s1);
        setBackground(Color.lightGray);
        add("Center", new Label("  " + s + "  ", 1));
        okButton = new Button("OK");
        Panel panel = new Panel();
        panel.setLayout(new FlowLayout(1, 0, 0));
        panel.add(okButton);
        add("South", panel);
        pack();
        Dimension dimension = getSize();
        Point point;
        if (frame == null) {
            Dimension dimension1 = getToolkit().getScreenSize();
            point = new Point((dimension1.width - dimension.width) / 2, (dimension1.height - dimension.height) / 3);
        } else {
            Dimension dimension2 = frame.getSize();
            Point point1 = frame.getLocation();
            point = new Point(point1.x + (dimension2.width - dimension.width) / 2, point1.y + (dimension2.height - dimension.height) / 3);
        }
        setLocation(point);
        show();
        toFront();
        waitUntilDone();
        hide();
    }

    public synchronized boolean action(Event event, Object obj) {
        if (event.target == okButton) {
            hide();
            notifyAll();
            return true;
        } else {
            return false;
        }
    }

    public static void beep() {
        Toolkit.getDefaultToolkit().beep();
    }

    public synchronized boolean handleEvent(Event event) {
        switch (event.id) {
            case 201: // Event.WINDOW_DESTROY
                hide();
                notifyAll();
                return true;
        }
        return super.handleEvent(event);
    }

    private synchronized void waitUntilDone() {
        beep();
        try {
            wait();
        } catch (InterruptedException _ex) {
        }
        dispose();
    }

    private Button okButton;
}
