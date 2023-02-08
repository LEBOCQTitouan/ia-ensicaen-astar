package edu.ensicaen.model.maze.strategy;

import edu.ensicaen.model.cell.CellType;
import edu.ensicaen.model.maze.Maze;

public class MazeOnlyPathGeneration implements MazeGenerationStrategy {
    @Override
    public Maze generate(int width, int height) {
        int startX = (int) (Math.random() * width);
        int startY = (int) (Math.random() * height);
        int endX = (int) (Math.random() * width);
        int endY = (int) (Math.random() * height);

        return generate(width, height, startX, startY, endX, endY);
    }

    @Override
    public Maze generate(int width, int height, int startX, int startY, int endX, int endY) {
        Maze maze = Maze.generateEmptyMaze(10, 10);
        maze.getCell(startX, startY).setType(CellType.START);
        maze.getCell(endX, endY).setType(CellType.END);
        return maze;
    }
}
