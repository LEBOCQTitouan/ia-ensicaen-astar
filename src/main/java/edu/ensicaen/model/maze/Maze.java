package edu.ensicaen.model.maze;

import edu.ensicaen.model.cell.Cell;
import edu.ensicaen.model.cell.CellType;
import edu.ensicaen.model.maze.generation.MazeGenerationStrategy;
import edu.ensicaen.model.maze.generation.MazeOnlyPathGeneration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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

    public static @NotNull Maze generateEmptyMaze(int width, int height) {
        return new Maze(width, height);
    }

    public static Maze generateMaze(int width, int height) {
        MazeGenerationStrategy strategy = new MazeOnlyPathGeneration();
        return strategy.generate(width, height);
    }

    public static Maze generateMaze(int width, int height, int startX, int startY, int endX, int endY) {
        MazeGenerationStrategy strategy = new MazeOnlyPathGeneration();
        return strategy.generate(width, height, startX, startY, endX, endY);
    }

    public static Maze generateMaze(int width, int height, MazeGenerationStrategy strategy) {
        return strategy.generate(width, height);
    }

    public static Maze generateMaze(int width, int height, int startX, int startY, int endX, int endY, MazeGenerationStrategy strategy) {
        return strategy.generate(width, height, startX, startY, endX, endY);
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }
}
