package com.restaurante.consola;

import java.awt.*;

public class ConsolaCanvas extends Canvas implements Runnable {

    public ConsolaCanvas() {

    }

    public ConsolaCanvas(Consola console, int i, int j, int k) {
        inXORMode = false;
        cursorRow = 1;
        cursorCol = 1;
        cursorVisible = false;
        parentConsole = console;
        numRows = i;
        numCols = j;
        String as[] = Toolkit.getDefaultToolkit().getFontList();
        for (int l = 0; l < as.length; l++) {
            if (!as[l].equalsIgnoreCase("monospaced")) {
                continue;
            }
            font = new Font(as[l], 0, k);
            break;
        }

        if (font == null) {
            for (int i1 = 0; i1 < as.length; i1++) {
                if (!as[i1].equalsIgnoreCase("Courier")) {
                    continue;
                }
                font = new Font(as[i1], 0, k);
                break;
            }

        }
        if (font == null) {
            font = new Font("Dialog", 0, k);
        }
        FontMetrics fontmetrics = Toolkit.getDefaultToolkit().getFontMetrics(font);
        fontHeight = fontmetrics.getHeight() + fontmetrics.getLeading();
        fontBase = fontmetrics.getDescent();
        fontWidth = 0;
        for (int j1 = 0; j1 < 256; j1++) {
            fontWidth = Math.max(fontWidth, fontmetrics.charWidth(j1));
        }

        numXPixels = numCols * fontWidth;
        numYPixels = numRows * fontHeight;
        canvasMaxWidth = numXPixels + 20;
        canvasMaxHeight = numYPixels + 20;
        resize(canvasMaxWidth, canvasMaxHeight);
        cursorThread = new Thread(this);
        cursorThread.setName("Console Cursor Thread");
        cursorThread.start();
        int k1 = size().width;
        int l1 = size().height;
        if (k1 > canvasMaxWidth) {
            originX = (k1 - canvasMaxWidth) / 2 + 2 + 3 + 5;
        } else {
            originX = 10;
        }
        if (l1 > canvasMaxHeight) {
            originY = (l1 - canvasMaxHeight) / 2 + 2 + 3 + 5;
            return;
        } else {
            originY = 10;
            return;
        }
    }

    public void addNotify() {
        super.addNotify();
        offscreenImage = createImage(numXPixels, numYPixels);
        Graphics g = offscreenImage.getGraphics();
        g.setFont(font);
        g.setColor(Color.white);
        g.fillRect(0, 0, numXPixels, numYPixels);
    }

    private synchronized void blinkCursor() {
        toggleCursor();
        cursorVisible = !cursorVisible;
    }

    synchronized void clearRect(int i, int j, int k, int l) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        g.clearRect(i, j, k, l);
        if (cursorVisible) {
            toggleCursor();
        }
        g1.translate(originX, originY);
        g1.clearRect(i, j, k, l);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void clearScreen(Color color) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        g.setColor(color);
        g.fillRect(0, 0, numXPixels, numYPixels);
        if (cursorVisible) {
            toggleCursor();
        }
        g1.translate(originX, originY);
        g1.setColor(color);
        g1.fillRect(0, 0, numXPixels, numYPixels);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void clearToEOL(int i, int j, Color color) {
        int k = (j - 1) * fontWidth;
        int l = (i - 1) * fontHeight;
        int i1 = numXPixels - k;
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        g.setColor(color);
        g.fillRect(k, l, i1, fontHeight);
        if (cursorVisible) {
            toggleCursor();
        }
        g1.translate(originX, originY);
        g1.setColor(color);
        g1.fillRect(k, l, i1, fontHeight);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void copyArea(int i, int j, int k, int l, int i1, int j1) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        g.copyArea(i, j, k, l, i1, j1);
        g1.translate(originX, originY);
        g1.drawImage(offscreenImage, 0, 0, this);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    private synchronized void doDraw(Graphics g) {
        byte byte0 = 10;
        if (cursorVisible) {
            toggleCursor();
        }
        int ai[] = {
            -byte0, size().width, size().width, -byte0, -byte0, -5, -5, numXPixels + 2 + 3, numXPixels + 2 + 3, -byte0
        };
        int ai1[] = {
            -byte0, -byte0, size().height, size().height, -5, -5, numYPixels + 2 + 3, numYPixels + 2 + 3, -5, -5
        };
        g.translate(originX, originY);
        g.setColor(Color.lightGray);
        g.fillPolygon(ai, ai1, 10);
        for (int i = 4; i <= 5; i++) {
            g.draw3DRect(-i, -i, (numXPixels + 2 * i) - 1, (numYPixels + 2 * i) - 1, false);
        }

        g.setColor(Color.black);
        g.drawLine(-3, -3, numXPixels + 2, -3);
        g.drawLine(-3, -3, -3, numYPixels + 2);
        g.setColor(Color.lightGray);
        g.drawLine(numXPixels + 2, -3, numXPixels + 2, numYPixels + 2);
        g.drawLine(-3, numYPixels + 2, numXPixels + 2, numYPixels + 2);
        g.setColor(Color.white);
        for (int j = 1; j <= 2; j++) {
            g.drawRect(-j, -j, (numXPixels + 2 * j) - 1, (numYPixels + 2 * j) - 1);
        }

        g.drawImage(offscreenImage, 0, 0, this);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void draw3DRect(int i, int j, int k, int l, boolean flag, Color color) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        if (inXORMode) {
            g.setXORMode(xorColor);
        }
        g.setColor(color);
        g.draw3DRect(i, j, k, l, flag);
        if (cursorVisible) {
            toggleCursor();
        }
        if (inXORMode) {
            g1.setXORMode(xorColor);
        }
        g1.translate(originX, originY);
        g1.setColor(color);
        g1.draw3DRect(i, j, k, l, flag);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void drawArc(int i, int j, int k, int l, int i1, int j1, Color color) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        if (inXORMode) {
            g.setXORMode(xorColor);
        }
        g.setColor(color);
        g.drawArc(i, j, k, l, i1, j1);
        if (cursorVisible) {
            toggleCursor();
        }
        if (inXORMode) {
            g1.setXORMode(xorColor);
        }
        g1.translate(originX, originY);
        g1.setColor(color);
        g1.drawArc(i, j, k, l, i1, j1);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void drawLine(int i, int j, int k, int l, Color color) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        if (inXORMode) {
            g.setXORMode(xorColor);
        }
        g.setColor(color);
        g.drawLine(i, j, k, l);
        if (cursorVisible) {
            toggleCursor();
        }
        if (inXORMode) {
            g1.setXORMode(xorColor);
        }
        g1.translate(originX, originY);
        g1.setColor(color);
        g1.drawLine(i, j, k, l);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void drawOval(int i, int j, int k, int l, Color color) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        if (inXORMode) {
            g.setXORMode(xorColor);
        }
        g.setColor(color);
        g.drawOval(i, j, k, l);
        if (cursorVisible) {
            toggleCursor();
        }
        if (inXORMode) {
            g1.setXORMode(xorColor);
        }
        g1.translate(originX, originY);
        g1.setColor(color);
        g1.drawOval(i, j, k, l);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void drawPolygon(int ai[], int ai1[], int i, Color color) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        if (inXORMode) {
            g.setXORMode(xorColor);
        }
        g.setColor(color);
        g.drawPolygon(ai, ai1, i);
        if (cursorVisible) {
            toggleCursor();
        }
        if (inXORMode) {
            g1.setXORMode(xorColor);
        }
        g1.translate(originX, originY);
        g1.setColor(color);
        g1.drawPolygon(ai, ai1, i);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void drawRect(int i, int j, int k, int l, Color color) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        if (inXORMode) {
            g.setXORMode(xorColor);
        }
        g.setColor(color);
        g.drawRect(i, j, k, l);
        if (cursorVisible) {
            toggleCursor();
        }
        if (inXORMode) {
            g1.setXORMode(xorColor);
        }
        g1.translate(originX, originY);
        g1.setColor(color);
        g1.drawRect(i, j, k, l);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void drawRoundRect(int i, int j, int k, int l, int i1, int j1, Color color) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        if (inXORMode) {
            g.setXORMode(xorColor);
        }
        g.setColor(color);
        g.drawRoundRect(i, j, k, l, i1, j1);
        if (cursorVisible) {
            toggleCursor();
        }
        if (inXORMode) {
            g1.setXORMode(xorColor);
        }
        g1.translate(originX, originY);
        g1.setColor(color);
        g1.drawRoundRect(i, j, k, l, i1, j1);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void drawString(String s, int i, int j, Font font1, Color color) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        if (inXORMode) {
            g.setXORMode(xorColor);
        }
        g.setColor(color);
        g.setFont(font1);
        g.drawString(s, i, j);
        if (cursorVisible) {
            toggleCursor();
        }
        if (inXORMode) {
            g1.setXORMode(xorColor);
        }
        g1.translate(originX, originY);
        g1.setColor(color);
        g1.setFont(font1);
        g1.drawString(s, i, j);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void drawText(int i, int j, String s, Color color, Color color1) {
        int k = (j - 1) * fontWidth;
        int l = (i - 1) * fontHeight;
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        g.setColor(color1);
        g.fillRect(k, l, fontWidth * s.length(), fontHeight);
        g.setColor(color);
        g.setFont(font);
        g.drawString(s, k, (l + fontHeight) - fontBase);
        if (cursorVisible) {
            toggleCursor();
        }
        g1.translate(originX, originY);
        g1.setColor(color1);
        g1.fillRect(k, l, fontWidth * s.length(), fontHeight);
        g1.setColor(color);
        g1.setFont(font);
        g1.drawString(s, k, (l + fontHeight) - fontBase);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void fill3DRect(int i, int j, int k, int l, boolean flag, Color color) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        if (inXORMode) {
            g.setXORMode(xorColor);
        }
        g.setColor(color);
        g.fill3DRect(i, j, k, l, flag);
        if (cursorVisible) {
            toggleCursor();
        }
        if (inXORMode) {
            g1.setXORMode(xorColor);
        }
        g1.translate(originX, originY);
        g1.setColor(color);
        g1.fill3DRect(i, j, k, l, flag);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void fillArc(int i, int j, int k, int l, int i1, int j1, Color color) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        if (inXORMode) {
            g.setXORMode(xorColor);
        }
        g.setColor(color);
        g.fillArc(i, j, k, l, i1, j1);
        if (cursorVisible) {
            toggleCursor();
        }
        if (inXORMode) {
            g1.setXORMode(xorColor);
        }
        g1.translate(originX, originY);
        g1.setColor(color);
        g1.fillArc(i, j, k, l, i1, j1);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void fillOval(int i, int j, int k, int l, Color color) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        if (inXORMode) {
            g.setXORMode(xorColor);
        }
        g.setColor(color);
        g.fillOval(i, j, k, l);
        if (cursorVisible) {
            toggleCursor();
        }
        if (inXORMode) {
            g1.setXORMode(xorColor);
        }
        g1.translate(originX, originY);
        g1.setColor(color);
        g1.fillOval(i, j, k, l);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void fillPolygon(int ai[], int ai1[], int i, Color color) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        if (inXORMode) {
            g.setXORMode(xorColor);
        }
        g.setColor(color);
        g.fillPolygon(ai, ai1, i);
        if (cursorVisible) {
            toggleCursor();
        }
        if (inXORMode) {
            g1.setXORMode(xorColor);
        }
        g1.translate(originX, originY);
        g1.setColor(color);
        g1.fillPolygon(ai, ai1, i);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void fillRect(int i, int j, int k, int l, Color color) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        if (inXORMode) {
            g.setXORMode(xorColor);
        }
        g.setColor(color);
        g.fillRect(i, j, k, l);
        if (cursorVisible) {
            toggleCursor();
        }
        if (inXORMode) {
            g1.setXORMode(xorColor);
        }
        g1.translate(originX, originY);
        g1.setColor(color);
        g1.fillRect(i, j, k, l);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void fillRoundRect(int i, int j, int k, int l, int i1, int j1, Color color) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        if (inXORMode) {
            g.setXORMode(xorColor);
        }
        g.setColor(color);
        g.fillRoundRect(i, j, k, l, i1, j1);
        if (cursorVisible) {
            toggleCursor();
        }
        if (inXORMode) {
            g1.setXORMode(xorColor);
        }
        g1.translate(originX, originY);
        g1.setColor(color);
        g1.fillRoundRect(i, j, k, l, i1, j1);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void invertScreen() {
        Graphics g = getGraphics();
        g.translate(originX, originY);
        g.setColor(Color.white);
        g.setXORMode(Color.black);
        g.fillRect(0, 0, numXPixels, numYPixels);
        try {
            Thread.sleep(50L);
        } catch (Exception _ex) {
        }
        g.fillRect(0, 0, numXPixels, numYPixels);
        g.setPaintMode();
    }

    boolean isMainRunning() {
        ThreadGroup threadgroup;
        for (threadgroup = Thread.currentThread().getThreadGroup(); threadgroup.getParent() != null; threadgroup = threadgroup.getParent());
        Thread athread[] = new Thread[threadgroup.activeCount()];
        int i = threadgroup.enumerate(athread, true);
        for (int j = 0; j < i; j++) {
            Thread thread = athread[j];
            if (thread.getPriority() == 5 && !thread.isDaemon() && thread.isAlive() && !thread.getName().startsWith("AWT") && !thread.getName().equals("Console Cursor Thread")) {
                return true;
            }
        }

        return false;
    }

    void killCursorThread() {
        cursorThread.stop();
    }

    int maxx() {
        return numXPixels - 1;
    }

    int maxy() {
        return numYPixels - 1;
    }

    public void paint(Graphics g) {
        doDraw(g);
    }

    public void run() {
        boolean flag = true;
        do {
            blinkCursor();
            if (flag && !isMainRunning()) {
                flag = false;
                parentConsole.mainStopped();
                cursorThread.stop();
            }
            try {
                Thread.sleep(300L);
            } catch (Exception _ex) {
            }
        } while (true);
    }

    synchronized void scrollUpALine(Color color) {
        Graphics g = offscreenImage.getGraphics();
        Graphics g1 = getGraphics();
        g.copyArea(0, fontHeight, numXPixels, numYPixels - fontHeight, 0, -fontHeight);
        g.setColor(color);
        g.fillRect(0, numYPixels - fontHeight, numXPixels, fontHeight);
        g1.translate(originX, originY);
        g1.drawImage(offscreenImage, 0, 0, this);
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void setCursorPos(int i, int j) {
        if (cursorVisible) {
            toggleCursor();
        }
        cursorRow = i;
        cursorCol = j;
        if (cursorVisible) {
            toggleCursor();
        }
    }

    synchronized void setCursorVisible(boolean flag) {
        if (flag) {
            cursorBlinking++;
            if (cursorBlinking == 1 && cursorVisible) {
                toggleCursor();
                return;
            }
        } else {
            if (cursorBlinking == 1 && cursorVisible) {
                toggleCursor();
            }
            cursorBlinking--;
        }
    }

    synchronized void setPaintMode() {
        inXORMode = false;
    }

    synchronized void setXORMode(Color color) {
        inXORMode = true;
        xorColor = color;
    }

    private synchronized void toggleCursor() {
        if (cursorBlinking > 0) {
            int i = (cursorCol - 1) * fontWidth;
            int j = (cursorRow - 1) * fontHeight;
            Graphics g = getGraphics();
            g.translate(originX, originY);
            g.setColor(Color.white);
            g.setXORMode(Color.black);
            g.fillRect(i, j, fontWidth, fontHeight);
            g.setPaintMode();
        }
    }

    public void update(Graphics g) {
        doDraw(g);
    }

    public Dimension getMinimumSize() {
        return new Dimension(canvasMaxWidth, canvasMaxHeight);
    }

    public Dimension getPreferredSize() {
        return getMinimumSize();
    }

    public Dimension getMaximumSize() {
        return getMinimumSize();
    }

    private static final int MARGIN = 2;
    private static final int DEPTH = 3;
    private static final int GREY_MARGIN = 5;
    private static final String CONSOLE_CURSOR_THREAD_NAME = "Console Cursor Thread";
    private Consola parentConsole;
    private int originX;
    private int originY;
    private int canvasMaxHeight;
    private int canvasMaxWidth;
    private Image offscreenImage;
    private boolean inXORMode;
    private Color xorColor;
    private int numRows;
    private int numCols;
    private int numXPixels;
    private int numYPixels;
    private Font font;
    private int fontWidth;
    private int fontHeight;
    private int fontBase;
    private Thread cursorThread;
    private int cursorRow;
    private int cursorCol;
    private boolean cursorVisible;
    private int cursorBlinking;
}
