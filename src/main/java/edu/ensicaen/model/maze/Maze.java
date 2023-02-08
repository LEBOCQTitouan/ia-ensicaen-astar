package edu.ensicaen.model.maze;

import edu.ensicaen.model.cell.Cell;
import edu.ensicaen.model.cell.CellType;

public class Maze {
    private final Cell[][] cells;

    private Maze(int width, int height) {
        cells = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell(CellType.PATH, i, j);
            }
        }
    }

    public static Maze generateEmptyMaze(int width, int height) {
        return new Maze(width, height);
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }
}
