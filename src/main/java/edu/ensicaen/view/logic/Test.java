package edu.ensicaen.view.logic;

import java.awt.*;

public class Test implements Displayable {
    @Override
    public void display(Graphics g) {
        g.drawString("Hello World!", 100, 100);
    }
}
