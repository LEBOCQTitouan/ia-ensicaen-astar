package edu.ensicaen.model.maze.strategy;

import edu.ensicaen.model.maze.Maze;

public interface MazeGenerationStrategy {
    Maze generate(int width, int height);
    Maze generate(int width, int height, int startX, int startY, int endX, int endY);
}
