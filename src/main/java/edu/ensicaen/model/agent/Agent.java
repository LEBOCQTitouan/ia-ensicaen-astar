package edu.ensicaen.model.agent;

import edu.ensicaen.model.cell.Cell;
import edu.ensicaen.view.logic.CellView;

public interface Agent {
    void compute();
    void computeStep();
    Cell[][] getCells();
    Cell getCell(int x, int y);
}
