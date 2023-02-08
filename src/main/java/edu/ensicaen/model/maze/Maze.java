package edu.ensicaen.model.maze;

import edu.ensicaen.model.agent.Agent;
import edu.ensicaen.model.agent.Astar.Astar;
import edu.ensicaen.model.agent.AvailableAgents;
import edu.ensicaen.model.cell.Cell;
import edu.ensicaen.model.cell.CellType;
import edu.ensicaen.model.maze.generation.MazeGenerationStrategy;
import edu.ensicaen.model.maze.generation.MazeOnlyPathGeneration;
import org.jetbrains.annotations.NotNull;

public class Maze {
    private final Cell[][] cells;
    private Cell start;
    private Cell end;

    private Maze(int width, int height) {
        cells = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell(CellType.DEFAULT, i, j);
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

    public Cell[][] getCells() {
        return cells;
    }

    public Agent getAgent(AvailableAgents agent) {
        // other agent not yet implemented
        switch (agent) {
            default -> {
                return new Astar(cells, start, end);
            }
        }
    }

    public Cell getStart() {
        return start;
    }

    public void setStart(Cell start) {
        this.start = start;
    }

    public Cell getEnd() {
        return end;
    }

    public void setEnd(Cell end) {
        this.end = end;
    }
}
