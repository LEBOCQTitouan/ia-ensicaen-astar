package edu.ensicaen.model.agent.Astar;

import edu.ensicaen.model.cell.Cell;
import edu.ensicaen.model.cell.CellType;

import java.util.UUID;

public class AstarCell extends Cell {
    private AstarCell parent;
    private Double g;
    private double h;
    private double f;
    private final String uniqueID = UUID.randomUUID().toString();

    public AstarCell(CellType type, int x, int y) {
        super(type, x, y);
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

    private boolean isDiagonal(AstarCell cell) {
        return Math.abs(cell.getX() - getX()) == 1 && Math.abs(cell.getY() - getY()) == 1;
    }

    private double getDistance(AstarCell cell) {
        if (isDiagonal(cell))
            return Math.sqrt(2);
        return 1;
    }

    public double getG() {
        if (g != null) {
            return g;
        }
        // computing g
        if (parent == null)
            g = 0.0;
        else
            g = getDistance(parent) + parent.getG();
        f = g + h;
        return g;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
        if (g != null)
            f = g + h;
        else
            f = h;
    }

    public double getF() {
        return f;
    }

    @Override
    public double getCost() {
        return f;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AstarCell cell) {
            return cell.getX() == getX() && cell.getY() == getY();
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "AstarCell{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", f=" + f +
                ", h=" + h +
                ", g=" + g +
                ", uniqueID='" + uniqueID + '\'' +
                '}';
    }
}
