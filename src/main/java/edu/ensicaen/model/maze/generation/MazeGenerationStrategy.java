package edu.ensicaen.model.maze.generation;

import edu.ensicaen.model.maze.Maze;

import java.security.InvalidParameterException;

public interface MazeGenerationStrategy {
    Maze generate(int width, int height) throws InvalidParameterException;
    Maze generate(int width, int height, int startX, int startY, int endX, int endY) throws InvalidParameterException;
}
