package edu.ensicaen.view.logic;

import edu.ensicaen.view.logic.colorUtil.ColorProxyForCell;
import edu.ensicaen.view.logic.displayInterface.Displayable;

import java.awt.*;

public class CellView implements Displayable {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final ColorProxyForCell colorProxyForCell;

    public CellView(int x, int y, int width, int height, ColorProxyForCell colorProxyForCell) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.colorProxyForCell = colorProxyForCell;
    }

    @Override
    public void display(Graphics g) {
        g.setColor(colorProxyForCell.getColor());
        g.fillRect(x, y, width, height);
    }
}
