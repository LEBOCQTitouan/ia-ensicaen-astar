package edu.ensicaen.view.logic;

import edu.ensicaen.view.logic.colorUtil.ColorProxyForPath;

public class PathView extends CellView {
    public PathView(int x, int y, int width, int height) {
        super(x, y, width, height, new ColorProxyForPath());
    }
}
