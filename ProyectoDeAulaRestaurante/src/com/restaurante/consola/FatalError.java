/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.consola;

import java.awt.*;

/**
 *
 * @author cyber
 *
 */
public class FatalError extends Frame {

    public FatalError() {

    }

    public FatalError(String s) {
        this(s, null);
    }

    public FatalError(String s, Frame frame) {
        super("Fatal Error");
        setBackground(Color.lightGray);
        add("Center", new Label("  " + s + "  ", 1));
        quitButton = new Button("Quit");
        Panel panel = new Panel();
        panel.setLayout(new FlowLayout(1, 0, 0));
        panel.add(quitButton);
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
        System.exit(0);
    }

    public synchronized boolean action(Event event, Object obj) {
        if (event.target == quitButton) {
            hide();
            notifyAll();
            return true;
        } else {
            return false;
        }
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
        Mensaje.beep();
        try {
            wait();
        } catch (InterruptedException _ex) {
        }
        dispose();
    }

    private Button quitButton;
}
