package com.restaurante.consola;
import java.awt.*;
import java.io.*;
import java.nio.CharBuffer;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Consola extends Frame {
    
    public static Consola getFirstConsole()
    {
        return firstConsole;
    }

    public Consola()
    {
      this(25, 80, 14, "Consola");
      this.setLocationRelativeTo(null);
      this.setExtendedState(3);
    }

    public Consola(int i)
    {
        this(25, 80, i, "Consola");
        this.setLocationRelativeTo(null);
        this.setExtendedState(3);
    }

    public Consola(int i, int j)
    {
        this(i, j, 14, "Consola");
        this.setLocationRelativeTo(null);
        this.setExtendedState(3);
    }

    public Consola(int i, int j, int k)
    {
        this(i, j, k, "Consola");
        this.setLocationRelativeTo(null);
        this.setExtendedState(3);
    }

    public Consola(int i, int j, int k, String s)
    {
        super(s);
        this.setLocationRelativeTo(null);
        this.setExtendedState(3);
        quitButton = new Button("Quitar");
        currentRow = 1;
        currentCol = 1;
        actualRow = 1;
        actualCol = 1;
        textColor = Color.black;
        textBGColor = Color.white;
        echoOn = true;
        clearToEOL = true;
        kbdBuffer = new char[2048];
        lineBuffer = new char[2048];
        ungotChar = -1;
        graphicsColor = Color.black;
        font = new Font("Serif", 0, 12);
        eofReached = false;
        if(firstConsole == null)
            firstConsole = this;
        numConsoles++;
        if(s.equals("Consola") && numConsoles > 1)
        {
            s = s + " " + numConsoles;
            setTitle(s);
        }
        consoleCanvas = new ConsolaCanvas(this, i, j, k);
        maxRow = i;
        maxCol = j;
        Panel panel = new Panel();
        panel.setBackground(Color.lightGray);
        panel.setLayout(new FlowLayout(1, 0, 0));
        panel.add(quitButton);
        add("North", panel);
        add("Center", consoleCanvas);
        setBackground(Color.lightGray);
        pack();
        if(!useStandardIO)
            show();
        repaint();
    }

    public Consola(int i, int j, String s)
    {
        this(i, j, 14, s);
        this.setLocationRelativeTo(null);
        this.setExtendedState(3);
    }

    public Consola(int i, String s)
    {
        this(25, 80, i, s);
        this.setLocationRelativeTo(null);
        this.setExtendedState(3);
    }

    public Consola(String s)
    {
        this(25, 80, 14, s);
        this.setLocationRelativeTo(null);
        this.setExtendedState(3);
    }
    
    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);


    public void clear()
    {
        consoleCanvas.clearScreen(textBGColor);
        currentRow = 1;
        currentCol = 1;
        actualRow = 1;
        actualCol = 1;
        consoleCanvas.setCursorPos(currentRow, currentCol);
    }

    public void clearRect(int i, int j, int k, int l)
    {
        consoleCanvas.clearRect(i, j, k, l);
    }

    public void close()
    {
        consoleCanvas.killCursorThread();
        dispose();
    }

    public void copyArea(int i, int j, int k, int l, int i1, int j1)
    {
        consoleCanvas.copyArea(i, j, k, l, i1, j1);
    }

    public void draw3DRect(int i, int j, int k, int l, boolean flag)
    {
        consoleCanvas.draw3DRect(i, j, k, l, flag, graphicsColor);
    }

    public void drawArc(int i, int j, int k, int l, int i1, int j1)
    {
        consoleCanvas.drawArc(i, j, k, l, i1, j1, graphicsColor);
    }

    public void drawLine(int i, int j, int k, int l)
    {
        consoleCanvas.drawLine(i, j, k, l, graphicsColor);
    }

    public void drawMapleLeaf(int i, int j, int k, int l)
    {
        float f = k;
        float f1 = l;
        float f2 = (float)i + f / 2.0F;
        float f3 = j + l;
        int ai[] = new int[26];
        int ai1[] = new int[26];
        ai[0] = (int)((double)f2 + (double)f * 0.021423000000000001D);
        ai1[0] = (int)((double)f3 - (double)f1 * 0.21568599999999999D);
        ai[1] = (int)((double)f2 + (double)f * 0.27078000000000002D);
        ai1[1] = (int)((double)f3 - (double)f1 * 0.20380400000000001D);
        ai[2] = (int)((double)f2 + (double)f * 0.27182000000000001D);
        ai1[2] = (int)((double)f3 - (double)f1 * 0.29575200000000001D);
        ai[3] = (int)((double)f2 + (double)f * 0.48201500000000003D);
        ai1[3] = (int)((double)f3 - (double)f1 * 0.41176499999999999D);
        ai[4] = (int)((double)f2 + (double)f * 0.443046D);
        ai1[4] = (int)((double)f3 - (double)f1 * 0.483267D);
        ai[5] = (int)((double)f2 + (double)f * 0.5D);
        ai1[5] = (int)((double)f3 - (double)f1 * 0.58743500000000004D);
        ai[6] = (int)((double)f2 + (double)f * 0.36335299999999998D);
        ai1[6] = (int)((double)f3 - (double)f1 * 0.61957600000000002D);
        ai[7] = (int)((double)f2 + (double)f * 0.34228700000000001D);
        ai1[7] = (int)((double)f3 - (double)f1 * 0.69384900000000005D);
        ai[8] = (int)((double)f2 + (double)f * 0.15359600000000001D);
        ai1[8] = (int)((double)f3 - (double)f1 * 0.612537D);
        ai[9] = (int)((double)f2 + (double)f * 0.201601D);
        ai1[9] = (int)((double)f3 - (double)f1 * 0.918462D);
        ai[10] = (int)((double)f2 + (double)f * 0.093001D);
        ai1[10] = (int)((double)f3 - (double)f1 * 0.89451400000000003D);
        ai[11] = (int)f2;
        ai1[11] = (int)(f3 - f1);
        ai[12] = (int)((double)f2 - (double)f * 0.093001D);
        ai1[12] = ai1[10];
        ai[13] = (int)((double)f2 - (double)f * 0.201601D);
        ai1[13] = ai1[9];
        ai[14] = (int)((double)f2 - (double)f * 0.15359600000000001D);
        ai1[14] = ai1[8];
        ai[15] = (int)((double)f2 - (double)f * 0.34228700000000001D);
        ai1[15] = ai1[7];
        ai[16] = (int)((double)f2 - (double)f * 0.36335299999999998D);
        ai1[16] = ai1[6];
        ai[17] = (int)((double)f2 - (double)f * 0.5D);
        ai1[17] = ai1[5];
        ai[18] = (int)((double)f2 - (double)f * 0.443046D);
        ai1[18] = ai1[4];
        ai[19] = (int)((double)f2 - (double)f * 0.48201500000000003D);
        ai1[19] = ai1[3];
        ai[20] = (int)((double)f2 - (double)f * 0.27182000000000001D);
        ai1[20] = ai1[2];
        ai[21] = (int)((double)f2 - (double)f * 0.27077960000000001D);
        ai1[21] = ai1[1];
        ai[22] = (int)((double)f2 - (double)f * 0.021423000000000001D);
        ai1[22] = ai1[0];
        ai[23] = ai[22];
        ai1[23] = (int)f3;
        ai[24] = ai[0];
        ai1[24] = ai1[23];
        ai[25] = ai[0];
        ai1[25] = ai1[0];
        consoleCanvas.drawPolygon(ai, ai1, 26, graphicsColor);
    }

    public void drawOval(int i, int j, int k, int l)
    {
        consoleCanvas.drawOval(i, j, k, l, graphicsColor);
    }

    public void drawPolygon(int ai[], int ai1[], int i)
    {
        consoleCanvas.drawPolygon(ai, ai1, i, graphicsColor);
    }

    public void drawRect(int i, int j, int k, int l)
    {
        consoleCanvas.drawRect(i, j, k, l, graphicsColor);
    }

    public void drawRoundRect(int i, int j, int k, int l, int i1, int j1)
    {
        consoleCanvas.drawRoundRect(i, j, k, l, i1, j1, graphicsColor);
    }

    public void drawStar(int i, int j, int k, int l)
    {
        float f = k;
        float f1 = l;
        float f2 = (float)i + f / 2.0F;
        float f3 = j + l;
        int ai[] = new int[11];
        int ai1[] = new int[11];
        ai[0] = (int)f2;
        ai1[0] = (int)(f3 - f1);
        ai[1] = (int)((double)f2 + (double)f * 0.118034D);
        ai1[1] = (int)((double)f3 - (double)f1 * 0.61856D);
        ai[2] = (int)((double)f2 + (double)f * 0.5D);
        ai1[2] = ai1[1];
        ai[3] = (int)((double)f2 + (double)f * 0.19098300000000001D);
        ai1[3] = (int)((double)f3 - (double)f1 * 0.38175900000000001D);
        ai[4] = (int)((double)f2 + (double)f * 0.30901699999999999D);
        ai1[4] = (int)f3;
        ai[5] = (int)f2;
        ai1[5] = (int)((double)f3 - (double)f1 * 0.236068D);
        ai[6] = (int)((double)f2 - (double)f * 0.30901699999999999D);
        ai1[6] = ai1[4];
        ai[7] = (int)((double)f2 - (double)f * 0.19098300000000001D);
        ai1[7] = ai1[3];
        ai[8] = (int)((double)f2 - (double)f * 0.5D);
        ai1[8] = ai1[2];
        ai[9] = (int)((double)f2 - (double)f * 0.118034D);
        ai1[9] = ai1[1];
        ai[10] = ai[0];
        ai1[10] = ai1[0];
        consoleCanvas.drawPolygon(ai, ai1, 11, graphicsColor);
    }

    public void drawString(String s, int i, int j)
    {
        consoleCanvas.drawString(s, i, j, font, graphicsColor);
    }

    private void eraseLineOfInput()
    {
        int i = (actualCol - startCol) + maxCol * (actualRow - startRow);
        currentRow = startRow;
        currentCol = startCol;
        actualRow = startRow;
        actualCol = startCol;
        for(int j = 0; j < i; j++)
            print(" ");

        currentRow = startRow;
        currentCol = startCol;
        actualRow = startRow;
        actualCol = startCol;
        consoleCanvas.setCursorPos(currentRow, currentCol);
    }

    private void erasePreviousChar()
    {
        if(currentCol > 1)
            currentCol--;
        else
        if(currentRow > 1)
        {
            currentRow--;
            currentCol = maxCol;
        }
        actualRow = currentRow;
        actualCol = currentCol;
        consoleCanvas.drawText(currentRow, currentCol, " ", textColor, textBGColor);
        consoleCanvas.setCursorPos(currentRow, currentCol);
        if(currentCol == 1 && currentRow != startRow)
        {
            currentCol = maxCol + 1;
            currentRow--;
        }
    }

    public void fill3DRect(int i, int j, int k, int l, boolean flag)
    {
        consoleCanvas.fill3DRect(i, j, k, l, flag, graphicsColor);
    }

    public void fillArc(int i, int j, int k, int l, int i1, int j1)
    {
        consoleCanvas.fillArc(i, j, k, l, i1, j1, graphicsColor);
    }

    public void fillMapleLeaf(int i, int j, int k, int l)
    {
        float f = k;
        float f1 = l;
        float f2 = (float)i + f / 2.0F;
        float f3 = j + l;
        int ai[] = new int[26];
        int ai1[] = new int[26];
        ai[0] = (int)((double)f2 + (double)f * 0.021423000000000001D);
        ai1[0] = (int)((double)f3 - (double)f1 * 0.21568599999999999D);
        ai[1] = (int)((double)f2 + (double)f * 0.27078000000000002D);
        ai1[1] = (int)((double)f3 - (double)f1 * 0.20380400000000001D);
        ai[2] = (int)((double)f2 + (double)f * 0.27182000000000001D);
        ai1[2] = (int)((double)f3 - (double)f1 * 0.29575200000000001D);
        ai[3] = (int)((double)f2 + (double)f * 0.48201500000000003D);
        ai1[3] = (int)((double)f3 - (double)f1 * 0.41176499999999999D);
        ai[4] = (int)((double)f2 + (double)f * 0.443046D);
        ai1[4] = (int)((double)f3 - (double)f1 * 0.483267D);
        ai[5] = (int)((double)f2 + (double)f * 0.5D);
        ai1[5] = (int)((double)f3 - (double)f1 * 0.58743500000000004D);
        ai[6] = (int)((double)f2 + (double)f * 0.36335299999999998D);
        ai1[6] = (int)((double)f3 - (double)f1 * 0.61957600000000002D);
        ai[7] = (int)((double)f2 + (double)f * 0.34228700000000001D);
        ai1[7] = (int)((double)f3 - (double)f1 * 0.69384900000000005D);
        ai[8] = (int)((double)f2 + (double)f * 0.15359600000000001D);
        ai1[8] = (int)((double)f3 - (double)f1 * 0.612537D);
        ai[9] = (int)((double)f2 + (double)f * 0.201601D);
        ai1[9] = (int)((double)f3 - (double)f1 * 0.918462D);
        ai[10] = (int)((double)f2 + (double)f * 0.093001D);
        ai1[10] = (int)((double)f3 - (double)f1 * 0.89451400000000003D);
        ai[11] = (int)f2;
        ai1[11] = (int)(f3 - f1);
        ai[12] = (int)((double)f2 - (double)f * 0.093001D);
        ai1[12] = ai1[10];
        ai[13] = (int)((double)f2 - (double)f * 0.201601D);
        ai1[13] = ai1[9];
        ai[14] = (int)((double)f2 - (double)f * 0.15359600000000001D);
        ai1[14] = ai1[8];
        ai[15] = (int)((double)f2 - (double)f * 0.34228700000000001D);
        ai1[15] = ai1[7];
        ai[16] = (int)((double)f2 - (double)f * 0.36335299999999998D);
        ai1[16] = ai1[6];
        ai[17] = (int)((double)f2 - (double)f * 0.5D);
        ai1[17] = ai1[5];
        ai[18] = (int)((double)f2 - (double)f * 0.443046D);
        ai1[18] = ai1[4];
        ai[19] = (int)((double)f2 - (double)f * 0.48201500000000003D);
        ai1[19] = ai1[3];
        ai[20] = (int)((double)f2 - (double)f * 0.27182000000000001D);
        ai1[20] = ai1[2];
        ai[21] = (int)((double)f2 - (double)f * 0.27077960000000001D);
        ai1[21] = ai1[1];
        ai[22] = (int)((double)f2 - (double)f * 0.021423000000000001D);
        ai1[22] = ai1[0];
        ai[23] = ai[22];
        ai1[23] = (int)f3;
        ai[24] = ai[0];
        ai1[24] = ai1[23];
        ai[25] = ai[0];
        ai1[25] = ai1[0];
        consoleCanvas.fillPolygon(ai, ai1, 26, graphicsColor);
    }

    public void fillOval(int i, int j, int k, int l)
    {
        consoleCanvas.fillOval(i, j, k, l, graphicsColor);
    }

    public void fillPolygon(int ai[], int ai1[], int i)
    {
        consoleCanvas.fillPolygon(ai, ai1, i, graphicsColor);
    }

    public void fillRect(int i, int j, int k, int l)
    {
        consoleCanvas.fillRect(i, j, k, l, graphicsColor);
    }

    public void fillRoundRect(int i, int j, int k, int l, int i1, int j1)
    {
        consoleCanvas.fillRoundRect(i, j, k, l, i1, j1, graphicsColor);
    }

    public void fillStar(int i, int j, int k, int l)
    {
        float f = k;
        float f1 = l;
        float f2 = (float)i + f / 2.0F;
        float f3 = j + l;
        int ai[] = new int[11];
        int ai1[] = new int[11];
        ai[0] = (int)f2;
        ai1[0] = (int)(f3 - f1);
        ai[1] = (int)((double)f2 + (double)f * 0.118034D);
        ai1[1] = (int)((double)f3 - (double)f1 * 0.61856D);
        ai[2] = (int)((double)f2 + (double)f * 0.5D);
        ai1[2] = ai1[1];
        ai[3] = (int)((double)f2 + (double)f * 0.19098300000000001D);
        ai1[3] = (int)((double)f3 - (double)f1 * 0.38175900000000001D);
        ai[4] = (int)((double)f2 + (double)f * 0.30901699999999999D);
        ai1[4] = (int)f3;
        ai[5] = (int)f2;
        ai1[5] = (int)((double)f3 - (double)f1 * 0.236068D);
        ai[6] = (int)((double)f2 - (double)f * 0.30901699999999999D);
        ai1[6] = ai1[4];
        ai[7] = (int)((double)f2 - (double)f * 0.19098300000000001D);
        ai1[7] = ai1[3];
        ai[8] = (int)((double)f2 - (double)f * 0.5D);
        ai1[8] = ai1[2];
        ai[9] = (int)((double)f2 - (double)f * 0.118034D);
        ai1[9] = ai1[1];
        ai[10] = ai[0];
        ai1[10] = ai1[0];
        consoleCanvas.fillPolygon(ai, ai1, 11, graphicsColor);
    }

    public boolean handleEvent(Event event)
    {
        switch(event.id)
        {
        default:
            break;

        case 401: // Event.KEY_PRESS
            handleKeystroke((char)event.key);
            return true;

        case 1001: // Event.ACTION_EVENT
            if(event.target == quitButton)
                System.exit(0);
            break;

        case 201: // Event.WINDOW_DESTROY
            System.exit(0);
            break;
        }
        return super.handleEvent(event);
    }

    private synchronized void handleKeystroke(char c)
    {
        kbdBuffer[kbdBufferHead] = c;
        kbdBufferHead = (kbdBufferHead + 1) % 2048;
        notify();
    }

    public void hideCursor()
    {
        consoleCanvas.setCursorVisible(false);
    }

    void mainStopped()
    {
        quitButton.setLabel("Close");
        quitButton.getParent().invalidate();
        quitButton.getParent().validate();
    }

    public int maxcol()
    {
        return maxCol;
    }

    public int maxrow()
    {
        return maxRow;
    }

    public int maxx()
    {
        return consoleCanvas.maxx();
    }

    public int maxy()
    {
        return consoleCanvas.maxy();
    }

    static void prepareForSubmit()
    {
        useStandardIO = true;
    }

    public void print(byte byte0)
    {
        print(byte0);
    }

    public void print(byte byte0, int i)
    {
        print(byte0, i);
    }

    public void print(char c)
    {
        print(String.valueOf(c));
    }

    public void print(char c, int i)
    {
        String s = String.valueOf(c);
        StringBuffer stringbuffer = new StringBuffer();
        for(int j = 0; j < i - s.length(); j++)
            stringbuffer.append(' ');

        print(s + stringbuffer);
    }

    public void print(double d)
    {
        print(String.valueOf(d));
    }

    public void print(double d, int i)
    {
        double d1 = Math.abs(d);
        int j = i;
        String s = null;
        StringBuffer stringbuffer = new StringBuffer();
        if(d < 0.0D)
            j--;
        if(d1 < 10D)
            s = "0";
        else
        if(d1 < 100D)
            s = "00";
        else
        if(d1 < 1000D)
            s = "000";
        else
        if(d1 < 10000D)
            s = "0000";
        else
        if(d1 < 100000D)
            s = "00000";
        else
        if(d1 < 1000000D)
            s = "000000";
        else
        if(d1 < 10000000D)
            s = "0000000";
        else
        if(d1 < 100000000D)
            s = "00000000";
        String s1;
        if(s == null)
        {
            s1 = String.valueOf(d);
        } else
        {
            j -= s.length();
            if(j > 0)
            {
                s = s + ".";
                j--;
            }
            for(int k = 0; k < j; k++)
                s = s + "#";

            DecimalFormat decimalformat = new DecimalFormat(s);
            s1 = decimalformat.format(d);
        }
        for(int l = 0; l < i - s1.length(); l++)
            stringbuffer.append(' ');

        print(stringbuffer + s1);
    }

    public void print(double d, int i, int j)
    {
        double d1 = Math.abs(d);
        int k = i;
        String s = null;
        StringBuffer stringbuffer = new StringBuffer();
        if(d < 0.0D)
            k--;
        if(d1 < 10D)
            s = "0";
        else
        if(d1 < 100D)
            s = "00";
        else
        if(d1 < 1000D)
            s = "000";
        else
        if(d1 < 10000D)
            s = "0000";
        else
        if(d1 < 100000D)
            s = "00000";
        else
        if(d1 < 1000000D)
            s = "000000";
        else
        if(d1 < 10000000D)
            s = "0000000";
        else
        if(d1 < 100000000D)
            s = "00000000";
        String s2;
        if(Math.abs(d) >= 100000000D)
        {
            s2 = String.valueOf(d);
        } else
        {
            String s1 = "0.";
            for(int l = 0; l < j; l++)
                s1 = s1 + "0";

            DecimalFormat decimalformat = new DecimalFormat(s1);
            s2 = decimalformat.format(d);
        }
        for(int i1 = 0; i1 < i - s2.length(); i1++)
            stringbuffer.append(' ');

        print(stringbuffer + s2);
    }

    public void print(float f)
    {
        print(String.valueOf(f));
    }

    public void print(float f, int i)
    {
        print(f, i);
    }

    public void print(float f, int i, int j)
    {
        print(f, i, j);
    }

    public void print(int i)
    {
        print(String.valueOf(i));
    }

    public void print(int i, int j)
    {
        String s = String.valueOf(i);
        StringBuffer stringbuffer = new StringBuffer();
        for(int k = 0; k < j - s.length(); k++)
            stringbuffer.append(' ');

        print(stringbuffer + s);
    }

    public void print(long l)
    {
        print(String.valueOf(l));
    }

    public void print(long l, int i)
    {
        String s = String.valueOf(l);
        StringBuffer stringbuffer = new StringBuffer();
        for(int j = 0; j < i - s.length(); j++)
            stringbuffer.append(' ');

        print(stringbuffer + s);
    }
    
    public void print(Object o)
    {
    print(String.valueOf(o));    
        
    }

    public void print(String s)
    {
        boolean flag = false;
        int j = s.length();
        int k = 0;
        if(useStandardIO)
        {
            System.out.print(s);
            return;
        }
        do
        {
            int i = k;
            if(i == j)
            {
                consoleCanvas.setCursorPos(actualRow, actualCol);
                return;
            }
            char c = s.charAt(i);
            for(; i < j && s.charAt(i) != '\n' && i - k < maxCol - currentCol; i++);
            if(k != i)
            {
                consoleCanvas.drawText(currentRow, currentCol, s.substring(k, i), textColor, textBGColor);
                currentCol += i - k;
                actualCol = currentCol;
            }
            if(i == j)
            {
                consoleCanvas.setCursorPos(actualRow, actualCol);
                return;
            }
            if(s.charAt(i) == '\n')
            {
                if(currentRow <= maxRow && currentCol <= maxCol)
                    consoleCanvas.clearToEOL(currentRow, currentCol, textBGColor);
                if(currentRow < maxRow)
                {
                    currentCol = 1;
                    currentRow++;
                    actualCol = currentCol;
                    actualRow = currentRow;
                } else
                {
                    consoleCanvas.scrollUpALine(textBGColor);
                    startRow--;
                    currentCol = 1;
                    actualCol = currentCol;
                }
            } else
            if(currentCol <= maxCol)
            {
                consoleCanvas.drawText(currentRow, currentCol, s.substring(i, i + 1), textColor, textBGColor);
                if(currentCol < maxCol)
                {
                    currentCol++;
                    actualCol = currentCol;
                } else
                if(currentRow < maxRow)
                {
                    currentCol++;
                    actualCol = 1;
                    actualRow++;
                } else
                {
                    currentCol++;
                }
            } else
            {
                if(currentRow < maxRow)
                {
                    currentRow++;
                } else
                {
                    consoleCanvas.scrollUpALine(textBGColor);
                    startRow--;
                }
                consoleCanvas.drawText(currentRow, 1, s.substring(i, i + 1), textColor, textBGColor);
                currentCol = 2;
                actualCol = currentCol;
                actualRow = currentRow;
            }
            k = i + 1;
        } while(true);
    }

    public void print(String s, int i)
    {
        StringBuffer stringbuffer = new StringBuffer();
        for(int j = 0; j < i - s.length(); j++)
            stringbuffer.append(' ');

        print(s + stringbuffer);
    }

    public void print(short word0)
    {
        print(word0);
    }

    public void print(short word0, int i)
    {
        print(word0, i);
    }

    public void print(boolean flag)
    {
        print(String.valueOf(flag));
    }

    public void print(boolean flag, int i)
    {
        String s = String.valueOf(flag);
        StringBuffer stringbuffer = new StringBuffer();
        for(int j = 0; j < i - s.length(); j++)
            stringbuffer.append(' ');

        print(s + stringbuffer);
    }

    public void println()
    {
        print("\n");
    }

    public void println(byte byte0)
    {
        print(byte0);
        print("\n");
    }

    public void println(byte byte0, int i)
    {
        print(byte0, i);
        print("\n");
    }

    public void println(char c)
    {
        print(c);
        print("\n");
    }

    public void println(char c, int i)
    {
        print(c, i);
        print("\n");
    }

    public void println(double d)
    {
        print(d);
        print("\n");
    }

    public void println(double d, int i)
    {
        print(d, i);
        print("\n");
    }

    public void println(double d, int i, int j)
    {
        print(d, i, j);
        print("\n");
    }

    public void println(float f)
    {
        print(f);
        print("\n");
    }

    public void println(float f, int i)
    {
        print(f, i);
        print("\n");
    }

    public void println(float f, int i, int j)
    {
        print(f, i, j);
        print("\n");
    }

    public void println(int i)
    {
        print(i);
        print("\n");
    }

    public void println(int i, int j)
    {
        print(i, j);
        print("\n");
    }

    public void println(long l)
    {
        print(l);
        print("\n");
    }

    public void println(long l, int i)
    {
        print(l, i);
        print("\n");
    }
    
    public void println(Object o)
    {
      print(o);
      print("\n");  
    }

    public void println(String s)
    {
        print(s);
        print("\n");
    }

    public void println(String s, int i)
    {
        print(s, i);
        print("\n");
    }

    public void println(short word0)
    {
        print(word0);
        print("\n");
    }

    public void println(short word0, int i)
    {
        print(word0, i);
        print("\n");
    }

    public void println(boolean flag)
    {
        print(flag);
        print("\n");
    }

    public void println(boolean flag, int i)
    {
        print(flag, i);
        print("\n");
    }
    
    public Object readObject()
    {
     return readToken();
    }    
        
    public boolean readBoolean()
    {
        String s = readToken().toLowerCase();
        if(s.equals("true"))
            return true;
        if(s.equals("false"))
        {
            return false;
        } else
        {
            new FatalError("Unable to convert \"" + s + "\" to a boolean", this);
            return false;
        }
    }

    public byte readByte()
    {
        String s = readToken();
        try
        {
            return Byte.parseByte(s);
        }
        catch(NumberFormatException _ex)
        {
            new FatalError("Unable to convert \"" + s + "\" to a byte", this);
        }
        return 0;
    }

    public synchronized char readChar()
    {
        if(ungotChar != -1)
        {
            char c = (char)ungotChar;
            ungotChar = -1;
            return c;
        }
        if(useStandardIO)
            try
            {
                char c3;
                do
                {
                    int i = System.in.read();
                    if(i != -1)
                    {
                        c3 = (char)i;
                    } else
                    {
                        if(eofReached)
                            throw new RuntimeException("Attempt to read past end of input file");
                        eofReached = true;
                        c3 = '\n';
                    }
                } while(c3 == '\r');
                return c3;
            }
            catch(IOException _ex)
            {
                throw new RuntimeException("I/O Error while reading input file");
            }
        if(lineBufferHead != lineBufferTail)
        {
            char c1 = lineBuffer[lineBufferTail];
            lineBufferTail = (lineBufferTail + 1) % 2048;
            return c1;
        }
        startRow = currentRow;
        startCol = currentCol;
        if(currentRow > maxRow)
        {
            startRow++;
            currentCol = 1;
        }
        consoleCanvas.setCursorVisible(true);
        do
        {
            while(kbdBufferHead == kbdBufferTail) 
                try
                {
                    wait();
                }
                catch(InterruptedException _ex) { }
            char c4 = kbdBuffer[kbdBufferTail];
            kbdBufferTail = (kbdBufferTail + 1) % 2048;
            if(c4 == '\n')
            {
                clearToEOL = false;
                if(echoOn)
                    print("\n");
                clearToEOL = true;
                lineBuffer[lineBufferHead] = '\n';
                lineBufferHead = (lineBufferHead + 1) % 2048;
                break;
            }
            if(c4 == '\b')
            {
                if(lineBufferHead == lineBufferTail)
                {
                    consoleCanvas.invertScreen();
                } else
                {
                    lineBufferHead = ((lineBufferHead + 2048) - 1) % 2048;
                    char c5 = lineBuffer[lineBufferHead];
                    if(echoOn)
                        if(c5 != '\t')
                        {
                            erasePreviousChar();
                        } else
                        {
                            eraseLineOfInput();
                            for(int j = lineBufferTail; lineBufferHead != j; j = (j + 1) % lineBufferHead)
                                print(lineBuffer[j]);

                        }
                }
            } else
            if(c4 == '\025')
            {
                if(echoOn)
                    eraseLineOfInput();
                lineBufferHead = lineBufferTail;
            } else
            {
                if(echoOn)
                    print(c4);
                lineBuffer[lineBufferHead] = c4;
                lineBufferHead = (lineBufferHead + 1) % 2048;
            }
        } while(true);
        char c2 = lineBuffer[lineBufferTail];
        lineBufferTail = (lineBufferTail + 1) % 2048;
        consoleCanvas.setCursorVisible(false);
        return c2;
    }

    public double readDouble()
    {
        String s = readToken();
        try
        {
            Double double1 = Double.valueOf(s);
            return double1.doubleValue();
        }
        catch(NumberFormatException _ex)
        {
            new FatalError("Unable to convert \"" + s + "\" to a double", this);
        }
        return 0.0D;
    }

    public float readFloat()
    {
        String s = readToken();
        try
        {
            Float float1 = Float.valueOf(s);
            return float1.floatValue();
        }
        catch(NumberFormatException _ex)
        {
            new FatalError("Unable to convert \"" + s + "\" to a float", this);
        }
        return 0.0F;
    }

    public int readInt()
    {
        String s = readToken();
        try
        {
            return Integer.parseInt(s);
        }
        catch(NumberFormatException _ex)
        {
            new FatalError("Unable to convert \"" + s + "\" to a int", this);
        }
        return 0;
    }

    public String readLine()
    {
        char c = readChar();
        String s = "";
        for(; c != '\n'; c = readChar())
            s = s + c;

        return s;
    }

    public long readLong()
    {
        String s = readToken();
        try
        {
            return Long.parseLong(s);
        }
        catch(NumberFormatException _ex)
        {
            new FatalError("Unable to convert \"" + s + "\" to a long", this);
        }
        return 0L;
    }

    public short readShort()
    {
        String s = readToken();
        try
        {
            return Short.parseShort(s);
        }
        catch(NumberFormatException _ex)
        {
            new FatalError("Unable to convert \"" + s + "\" to a short", this);
        }
        return 0;
    }

    public String readString()
    {
        return readToken();
    }

    private String readToken()
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i;
        do
            i = readChar();
        while(i == 32 || i == 10 || i == 9);
        if(i == 34)
        {
            for(i = readChar(); i != 34;)
            {
                stringbuffer.append(i);
                i = readChar();
                if(i == 10)
                    new FatalError("No terminating quote for quoted string");
            }

            i = readChar();
        } else
        {
            do
            {
                stringbuffer.append(i);
                i = readChar();
            } while(i != 32 && i != 10 && i != 9);
        }
        for(; i == 32 || i == 9; i = readChar());
        if(i != 10)
            ungotChar = i;
        return new String(stringbuffer);
    }

    public void setColor(Color color)
    {
        graphicsColor = color;
    }

    public void setColour(Color color)
    {
        setColor(color);
    }

    public void setCursor(int i, int j)
    {
        if(useStandardIO)
        {
            System.out.println("");
            return;
        } else
        {
            currentRow = i;
            currentCol = j;
            actualRow = i;
            actualCol = j;
            consoleCanvas.setCursorPos(currentRow, currentCol);
            return;
        }
    }

    public void setFont(Font font1)
    {
        font = font1;
        super.setFont(font1);
    }

    public void setPaintMode()
    {
        consoleCanvas.setPaintMode();
    }

    public void setTextBackgroundColor(Color color)
    {
        textBGColor = color;
    }

    public void setTextBackgroundColour(Color color)
    {
        setTextBackgroundColor(color);
    }

    public void setTextColor(Color color)
    {
        textColor = color;
    }

    public void setTextColour(Color color)
    {
        setTextColor(color);
    }

    public void setXORMode(Color color)
    {
        consoleCanvas.setXORMode(color);
    }

    public void showCursor()
    {
        consoleCanvas.setCursorVisible(true);
    }
    
    ////////////// MÉTODOS PRIVADOS SCANNER //////////
    
      private void clearCaches() {
        hasNextPattern = null;
        typeCache = null;
    }
      
      private void ensureOpen() {
        if (closed)
            throw new IllegalStateException("Scanner closed");
    }
      
       private String findPatternInBuffer(Pattern pattern, int horizon) {
        matchValid = false;
        matcher.usePattern(pattern);
        int bufferLimit = buf.limit();
        int horizonLimit = -1;
        int searchLimit = bufferLimit;
        if (horizon > 0) {
            horizonLimit = position + horizon;
            if (horizonLimit < bufferLimit)
                searchLimit = horizonLimit;
        }
        matcher.region(position, searchLimit);
        if (matcher.find()) {
            if (matcher.hitEnd() && (!sourceClosed)) {
                // The match may be longer if didn't hit horizon or real end
                if (searchLimit != horizonLimit) {
                     // Hit an artificial end; try to extend the match
                    needInput = true;
                    return null;
                }
                // The match could go away depending on what is next
                if ((searchLimit == horizonLimit) && matcher.requireEnd()) {
                    // Rare case: we hit the end of input and it happens
                    // that it is at the horizon and the end of input is
                    // required for the match.
                    needInput = true;
                    return null;
                }
            }
            // Did not hit end, or hit real end, or hit horizon
            position = matcher.end();
            return matcher.group();
        }

        if (sourceClosed)
            return null;

        // If there is no specified horizon, or if we have not searched
        // to the specified horizon yet, get more input
        if ((horizon == 0) || (searchLimit != horizonLimit))
            needInput = true;
        return null;
    }

    // Returns a match for the specified input pattern anchored at
    // the current position
    private String matchPatternInBuffer(Pattern pattern) {
        matchValid = false;
        matcher.usePattern(pattern);
        matcher.region(position, buf.limit());
        if (matcher.lookingAt()) {
            if (matcher.hitEnd() && (!sourceClosed)) {
                // Get more input and try again
                needInput = true;
                return null;
            }
            position = matcher.end();
            return matcher.group();
        }

        if (sourceClosed)
            return null;

        // Read more to find pattern
        needInput = true;
        return null;
    }
    
     private String getCachedResult() {
        position = hasNextPosition;
        hasNextPattern = null;
        typeCache = null;
        return hasNextResult;
    }
     
     private static Pattern linePattern() {
        Pattern lp = linePattern;
        if (lp == null)
            linePattern = lp = Pattern.compile(LINE_PATTERN);
        return lp;
    }
     
     private boolean makeSpace() {
        clearCaches();
        int offset = savedScannerPosition == -1 ?
            position : savedScannerPosition;
        buf.position(offset);
        // Gain space by compacting buffer
        if (offset > 0) {
            buf.compact();
            translateSavedIndexes(offset);
            position -= offset;
            buf.flip();
            return true;
        }
        // Gain space by growing buffer
        int newSize = buf.capacity() * 2;
        CharBuffer newBuf = CharBuffer.allocate(newSize);
        newBuf.put(buf);
        newBuf.flip();
        translateSavedIndexes(offset);
        position -= offset;
        buf = newBuf;
        matcher.reset(buf);
        return true;
    }

     
     private void readInput() {
        if (buf.limit() == buf.capacity())
            makeSpace();

        // Prepare to receive data
        int p = buf.position();
        buf.position(buf.limit());
        buf.limit(buf.capacity());

        int n = 0;
        try {
            n = source.read(buf);
        } catch (IOException ioe) {
            lastException = ioe;
            n = -1;
        }

        if (n == -1) {
            sourceClosed = true;
            needInput = false;
        }

        if (n > 0)
            needInput = false;

        // Restore current position and limit for reading
        buf.limit(buf.position());
        buf.position(p);
    }

     
      private static Pattern separatorPattern() {
        Pattern sp = separatorPattern;
        if (sp == null)
            separatorPattern = sp = Pattern.compile(LINE_SEPARATOR_PATTERN);
        return sp;
    }
      
      private void translateSavedIndexes(int offset) {
        if (savedScannerPosition != -1)
            savedScannerPosition -= offset;
    }
     
     
    
    /////////////// MÉTODOS PÚBLICOS SCANNER /////////
      
     public String findWithinHorizon(Pattern pattern, int horizon) {
        ensureOpen();
        if (pattern == null)
            throw new NullPointerException();
        if (horizon < 0)
            throw new IllegalArgumentException("horizon < 0");
        clearCaches();

        // Search for the pattern
        while (true) {
            String token = findPatternInBuffer(pattern, horizon);
            if (token != null) {
                matchValid = true;
                return token;
            }
            if (needInput)
                readInput();
            else
                break; // up to end of input
        }
        return null;
    }
 
    
     public MatchResult match() {
        if (!matchValid)
            throw new IllegalStateException("No match result available");
        return matcher.toMatchResult();
    } 
     
    /*public String nextLine() {
        if (hasNextPattern == linePattern())
            return getCachedResult();
        clearCaches();

        String result = findWithinHorizon(linePattern, 0);
        if (result == null)
            throw new NoSuchElementException("No line found");
        MatchResult mr = this.match();
        String lineSep = mr.group(1);
        if (lineSep != null)
            result = result.substring(0, result.length() - lineSep.length());
        if (result == null)
            throw new NoSuchElementException();
        else
            return result;
    }
    */
    //////////////////// MÉTODOS ESTÁTICOS PÚBLICOS /////////////////////////
     
   // Método para leer objetos con Object
     
  public static Object leerObjetoObject(String mensaje){
   Consola c = new Consola();
    Object objeto = null;
    try{
    c.println(mensaje);
    objeto = br.readLine();
    }catch(Exception ex){
     c.println("Error" + ex);   
    }
    return objeto;
  }   
    
    // Método para leer cadenas de texto con String
  
  public static String leerTextoString(String mensaje){
    Consola c = new Consola();
    String textoString = "";
      try {
       c.println(mensaje);
        textoString = br.readLine();
       } catch (Exception ex) {
        c.println("Error" + ex);
      }
 
     return textoString;
  }
  
  // Método para leer números enteros con byte
  
    public static byte leerEnteroByte(String mensaje){
     Consola c = new Consola();
      byte numeroByte = 0;
        try {
         c.println(mensaje);
          numeroByte = Byte.parseByte(br.readLine());
        } catch (Exception ex) {
         c.println("Error" + ex);   
        }
        return numeroByte;
    }
    
  // Método para leer números enteros con short
    
    public static short leerEnteroShort(String mensaje){
      short numeroShort = 0;
      Consola c = new Consola();
        try {
        c.println(mensaje);
        numeroShort = Short.parseShort(br.readLine());
        } catch (Exception ex) {
          c.println("Error" + ex);
        }
        return numeroShort;
    }
    
    // Método para leer números enteros con int
    
    public static int leerEnteroInt(String mensaje){
      int numeroInt = 0;
      Consola c = new Consola();
        try {
        c.println(mensaje);
        numeroInt = Integer.parseInt(br.readLine());
         } catch (Exception ex) {
          c.println("Error" + ex);
        }
        return numeroInt;
    }
    
    // Método para leer números enteros con long
    
    public static long leerEnteroLong(String mensaje){
      long numeroLong = 0;
      Consola c = new Consola();
        try {
        c.println(mensaje);
        numeroLong = Long.parseLong(br.readLine());
        } catch (Exception ex) {
          c.println("Error" + ex);
        }
        return numeroLong;
    }
    
    // Método para leer números decimales con float
    
    public static float leerDecimalFloat(String mensaje){
      float numeroFloat = 0;
      Consola c = new Consola();
        try {
        c.println(mensaje);
        Float f = new Float(br.readLine());
        numeroFloat = f.floatValue();
        } catch (Exception ex) {
         c.println("Error" + ex);
        }
        return numeroFloat;
    }
    
    // Método para leer números decimales con double
    
    public static double leerDecimalDouble(String mensaje){
      double numeroDouble = 0;
      Consola c = new Consola();
        try {
        c.println(mensaje);
        Double d = new Double(br.readLine());
        numeroDouble = d.doubleValue();
        } catch (Exception ex) {
          c.println("Error" + ex); 
        }
       return numeroDouble;    
    }
    
    // Método para leer datos lógicos con boolean
    
    public static boolean leerBoolean(String mensaje){
      boolean estado = false;
      Consola c = new Consola();
      try{
      c.println(mensaje);
      
      }catch(Exception ex){
      c.println("Error" + ex);  
      }
        return estado;  
    }

    private static Consola firstConsole = null;
    private Button quitButton;
    private ConsolaCanvas consoleCanvas;
    private static final int DEFAULT_ROWS = 25;
    private static final int DEFAULT_COLUMNS = 80;
    private static final int DEFAULT_FONT_SIZE = 14;
    private static final String DEFAULT_TITLE = "Console";
    private int currentRow;
    private int currentCol;
    private int actualRow;
    private int actualCol;
    private int maxRow;
    private int maxCol;
    private int startCol;
    private int startRow;
    private Color textColor;
    private Color textBGColor;
    private boolean echoOn;
    private boolean clearToEOL;
    private static final int BUFFER_SIZE = 2048;
    private static final int EMPTY_BUFFER = -1;
    private char kbdBuffer[];
    private int kbdBufferHead;
    private int kbdBufferTail;
    private char lineBuffer[];
    private int lineBufferHead;
    private int lineBufferTail;
    private int ungotChar;
    private Color graphicsColor;
    private Font font;
    private static int numConsoles;
    private static boolean useStandardIO;
    private boolean eofReached;
    ///////////////////////// VARIABLES SCANNER /////////////////////////////////
    private Pattern hasNextPattern;
    private static volatile Pattern separatorPattern;
    private static volatile Pattern linePattern;
    private static final String LINE_SEPARATOR_PATTERN =
                                           "\r\n|[\n\r\u2028\u2029\u0085]";
    private static final String LINE_PATTERN = ".*("+LINE_SEPARATOR_PATTERN+")|.+$";
    private int position;
    private int hasNextPosition;
    private Object typeCache = null;
    private String hasNextResult;
    private boolean matchValid = false;
    private Matcher matcher;
    private boolean needInput = false;
    private boolean closed = false;
    private CharBuffer buf;
    private boolean sourceClosed = false;
    private Readable source;
    private IOException lastException;
    private int savedScannerPosition = -1;
}

