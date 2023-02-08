package edu.ensicaen.model.maze.strategy;

import edu.ensicaen.model.maze.Maze;

public interface MazeGenerationStrategy {
    Maze generate(int width, int height);
}
