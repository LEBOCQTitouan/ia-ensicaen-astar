package edu.ensicaen.view.logic;

import edu.ensicaen.model.cell.CellType;

import java.awt.*;

public class CellView implements Displayable {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final CellType type;

    public CellView(int x, int y, int width, int height, CellType type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    private void setColor(Graphics g) {
        switch (type) {
            case WALL -> g.setColor(Color.BLACK);
            case START -> g.setColor(Color.GREEN);
            case END -> g.setColor(Color.RED);
            case DEFAULT -> g.setColor(Color.WHITE);
            default -> g.setColor(Color.YELLOW);
        }
    }

    @Override
    public void display(Graphics g) {
        setColor(g);
        g.fillRect(x, y, width, height);
    }
}
