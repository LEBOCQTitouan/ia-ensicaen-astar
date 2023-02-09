package edu.ensicaen.model.maze.generation;

import edu.ensicaen.model.cell.CellType;
import edu.ensicaen.model.maze.Maze;

import java.util.Random;

public class MazeOnlyPathGeneration implements MazeGenerationStrategy {
    @Override
    public Maze generate(int width, int height) {
        Random random = new Random();

        int startX = random.nextInt(0, width);
        int endX = random.nextInt(0, width);

        int startY = random.nextInt(0, height);
        int endY = random.nextInt(0, height);

        return generate(width, height, startX, startY, endX, endY);
    }

    @Override
    public Maze generate(int width, int height, int startX, int startY, int endX, int endY) {
        Maze maze = Maze.generateEmptyMaze(width, height);

        // set cells at the border to be walls
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i == 0 || i == width - 1 || j == 0 || j == height - 1) {
                    maze.getCell(i, j).setType(CellType.WALL);
                }
            }
        }

        maze.getCell(startX, startY).setType(CellType.START);
        maze.setStart(maze.getCell(startX, startY));
        maze.getCell(endX, endY).setType(CellType.END);
        maze.setEnd(maze.getCell(endX, endY));
        return maze;
    }
}
