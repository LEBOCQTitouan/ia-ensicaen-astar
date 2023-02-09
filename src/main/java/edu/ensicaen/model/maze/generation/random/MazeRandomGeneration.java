package edu.ensicaen.model.maze.generation.random;

import edu.ensicaen.model.cell.CellType;
import edu.ensicaen.model.maze.Maze;
import edu.ensicaen.model.maze.generation.MazeGenerationStrategy;

import java.util.Random;

public class MazeRandomGeneration implements MazeGenerationStrategy {
    private final double wallProbability = 0.2;
    @Override
    public Maze generate(int width, int height) {
        Random random = new Random();
        // generating start x and start y
        int startX = random.nextInt(width);
        int startY = random.nextInt(height);
        // generating end x and end y
        int endX = random.nextInt(width);
        int endY = random.nextInt(height);
        return generate(width, height, startX, startY, endX, endY);
    }

    @Override
    public Maze generate(int width, int height, int startX, int startY, int endX, int endY) {
        return createWalls(width, height, Maze.generateMaze(width, height, startX, startY, endX, endY));
    }

    private Maze createWalls(int width, int height, Maze maze) {
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
