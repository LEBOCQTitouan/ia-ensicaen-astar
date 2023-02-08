package edu.ensicaen.model.maze.generation;

import edu.ensicaen.model.cell.CellType;
import edu.ensicaen.model.maze.Maze;

import java.util.Random;

public class MazeRandomGeneration implements MazeGenerationStrategy {
    private final double wallProbability = 0.2;
    @Override
    public Maze generate(int width, int height) {
        return createWalls(width, height, Maze.generateMaze(width, height));
    }

    @Override
    public Maze generate(int width, int height, int startX, int startY, int endX, int endY) {
        return createWalls(width, height, Maze.generateMaze(width, height, startX, startY, endX, endY));
    }

    private Maze createWalls(int width, int height, Maze maze) {
        Random random = new Random();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (
                        Math.random() < wallProbability
                        && maze.getCell(i, j).getType() != CellType.START
                        && maze.getCell(i, j).getType() != CellType.END
                ) {
                    maze.getCell(i, j).setType(CellType.WALL);
                }
            }
        }
        return maze;
    }
}
