package edu.ensicaen.model.maze.generation.corridor;

import edu.ensicaen.model.cell.Cell;
import edu.ensicaen.model.cell.CellType;
import edu.ensicaen.model.maze.Maze;
import edu.ensicaen.model.maze.generation.MazeGenerationStrategy;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class StructuredMazeGeneration implements MazeGenerationStrategy {
    private final PriorityQueue<Cell> queue = new PriorityQueue<>();
    private final ArrayList<Cell> visited = new ArrayList<>();
    @Override
    public Maze generate(int width, int height) throws InvalidParameterException {
        Random random = new Random();
        // generating start x and start y which are odd
        int startX = random.nextInt(width / 2) * 2 + 1;
        int startY = random.nextInt(height / 2) * 2 + 1;
        // generating end x and end y which are odd
        int endX = random.nextInt(width / 2) * 2 + 1;
        int endY = random.nextInt(height / 2) * 2 + 1;
        return generate(width, height, startX, startY, endX, endY);
    }

    @Override
    public Maze generate(int width, int height, int startX, int startY, int endX, int endY) throws InvalidParameterException {
        if (width < 3 || height < 3)
            throw new InvalidParameterException("The maze must be at least 3x3");
        Maze maze = Maze.generateMaze(width, height, startX, startY, endX, endY);

        // generating grid in maze
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i % 2 == 0 || j % 2 == 0) {
                    maze.getCell(i, j).setType(CellType.WALL);
                }
            }
        }

        process(maze, startX, startY);

        return maze;
    }

    private ArrayList<Cell> getNeighbours(Cell[][] cells, Cell cell) {
        ArrayList<Cell> neighbours = new ArrayList<>();
        if (cell.getY() - 2 >= 0 && !visited.contains(cells[cell.getX()][cell.getY() - 2])) { // TOP
            neighbours.add(cells[cell.getX()][cell.getY() - 2]);
        }
        if (cell.getY() + 2 < cells[0].length && !visited.contains(cells[cell.getX()][cell.getY() + 2])) { // BOTTOM
            neighbours.add(cells[cell.getX()][cell.getY() + 2]);
        }
        if (cell.getX() - 2 >= 0 && !visited.contains(cells[cell.getX() - 2][cell.getY()])) { // LEFT
            neighbours.add(cells[cell.getX() - 2][cell.getY()]);
        }
        if (cell.getX() + 2 < cells.length && !visited.contains(cells[cell.getX() + 2][cell.getY()])) { // RIGHT
            neighbours.add(cells[cell.getX() + 2][cell.getY()]);
        }
        return neighbours;
    }

    private Cell pickRandomNeighbour(ArrayList<Cell> neighbours) {
        Random random = new Random();
        return neighbours.get(random.nextInt(neighbours.size()));
    }

    // cf https://en.wikipedia.org/wiki/Maze_generation_algorithm#Iterative_implementation
    private void process(Maze maze, int startX, int startY) {
        // 1. Choose the initial cell, mark it as visited and push it to the stack
        queue.add(maze.getCell(startX, startY));
        visited.add(maze.getCell(startX, startY));
        // 2. While the stack is not empty
        while (!queue.isEmpty()) {
            // 2.1 Pop a cell from the stack and make it a current cell
            Cell currentCell = queue.remove();
            // 2.2 If the current cell has any neighbours which have not been visited
            ArrayList<Cell> neighbours = getNeighbours(maze.getCells(), currentCell);
            if (!neighbours.isEmpty()) {
                // 2.2.1 Push the current cell to the stack
                queue.add(currentCell);
                // 2.2.2 Choose one of the unvisited neighbours
                Cell neighbour = pickRandomNeighbour(neighbours);
                // 2.2.3 Remove the wall between the current cell and the chosen cell
                maze.getCell((currentCell.getX() + neighbour.getX()) / 2, (currentCell.getY() + neighbour.getY()) / 2).setType(CellType.DEFAULT);
                // 2.2.4 Mark the chosen cell as visited and push it to the stack
                visited.add(neighbour);
                queue.add(neighbour);
            }
        }
    }
}
