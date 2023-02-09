package edu.ensicaen.model.maze.generation;

import edu.ensicaen.model.maze.Maze;

import java.security.InvalidParameterException;

public class StructuredMazeGeneration implements MazeGenerationStrategy {
    @Override
    public Maze generate(int width, int height) throws InvalidParameterException {
        return null;
    }

    @Override
    public Maze generate(int width, int height, int startX, int startY, int endX, int endY) throws InvalidParameterException {
        if (width < 3 || height < 3)
            throw new InvalidParameterException("The maze must be at least 3x3");
        return null;
    }
}
