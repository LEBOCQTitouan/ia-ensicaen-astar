package edu.ensicaen.model.cell;

import org.jetbrains.annotations.NotNull;

public class Cell implements Comparable<Cell> {
    private CellType type;
    private final int x;
    private final int y;

    public Cell(CellType type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Dummy function used for agent display.
     * @return the cost of the cell (calculated by the agent 0 otherwise)
     */
    public double getCost() {
        return 0;
    }

    @Override
    public int compareTo(@NotNull Cell c) {
        return (int) Math.round(getCost() - c.getCost());
    }
}
