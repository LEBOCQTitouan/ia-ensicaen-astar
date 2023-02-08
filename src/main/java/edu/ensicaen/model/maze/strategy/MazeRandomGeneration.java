package edu.ensicaen.model.maze.strategy;

import edu.ensicaen.model.cell.CellType;
import edu.ensicaen.model.maze.Maze;

public class MazeRandomGeneration implements MazeGenerationStrategy {
    @Override
    public Maze generate(int width, int height) {
        Maze maze = Maze.generateEmptyMaze(width, height);
        // setup start and end cells
        int startX = (int) (Math.random() * width);
        int startY = (int) (Math.random() * height);
        int endX = (int) (Math.random() * width);
        int endY = (int) (Math.random() * height);
        maze.getCell(startX, startY).setType(CellType.START);
        maze.getCell(endX, endY).setType(CellType.END);
        // creating the wall randomly
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (Math.random() > 0.2) {
                    maze.getCell(i, j).setType(CellType.WALL);
                }
            }
        }
        return maze;
    }
}
