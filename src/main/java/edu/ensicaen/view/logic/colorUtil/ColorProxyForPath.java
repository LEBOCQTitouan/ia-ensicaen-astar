package edu.ensicaen.view.logic.colorUtil;

import edu.ensicaen.model.cell.CellType;

import java.awt.*;

public class ColorProxyForPath extends ColorProxyForCell {
    public ColorProxyForPath() {
        super(CellType.DEFAULT, 0);
    }

    @Override
    public Color getColor() {
        return Color.YELLOW;
    }
}
