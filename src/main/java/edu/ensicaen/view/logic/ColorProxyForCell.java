package edu.ensicaen.view.logic;

import edu.ensicaen.model.cell.CellType;

import java.awt.*;

public class ColorProxyForCell {
    private final CellType type;
    private final double weight;
    private static double maxWeight;

    public ColorProxyForCell(CellType type, double weight) {
        this.type = type;
        this.weight = weight;
        if (weight > maxWeight) {
            maxWeight = weight;
        }
    }

    public Color getColor() {
        switch (type) {
            case WALL -> { return  new Color(0, 0, 0); }
            case START -> { return new Color(255, 0, 0); }
            case END -> { return new Color(0, 255, 0); }
            default -> {
                if (maxWeight == 0 || weight == 0)
                    return new Color(255, 255, 255);
                int color = (int) (240 * weight / maxWeight);
                return new Color(color, color, 255);
            }
        }
    }
}
