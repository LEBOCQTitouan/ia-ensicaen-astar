package edu.ensicaen.model.agent.Astar;

import edu.ensicaen.model.cell.Cell;
import edu.ensicaen.model.cell.CellType;

public class AstarCell extends Cell {
    private AstarCell parent;
    private double g;
    private double h;
    private double f;
    public AstarCell(CellType type, int x, int y) {
        super(type, x, y);
        g = 0;
        h = 0;
        f = 0;
        parent = null;
    }

    public AstarCell getParent() {
        return parent;
    }

    public void setParent(AstarCell parent) {
        this.parent = parent;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
        f = g + h;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
        f = g + h;
    }

    public double getF() {
        return f;
    }
}
