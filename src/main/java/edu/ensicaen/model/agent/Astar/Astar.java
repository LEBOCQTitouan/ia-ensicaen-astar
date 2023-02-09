package edu.ensicaen.model.agent.Astar;

import edu.ensicaen.model.agent.Agent;
import edu.ensicaen.model.agent.Astar.Heuristic.Heuristic;
import edu.ensicaen.model.agent.Astar.Heuristic.ManhattanHeuristic;
import edu.ensicaen.model.cell.Cell;
import edu.ensicaen.model.cell.CellType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Astar implements Agent {
    private final AstarCell[][] cells;
    private final AstarCell start;
    private final AstarCell end;
    private final PriorityQueue<AstarCell> openList;
    private final ArrayList<AstarCell> closedList;
    private final Heuristic heuristic;

    public Astar(Cell[][] cells, Cell start, Cell end) {
        this(cells, start, end, new ManhattanHeuristic());
    }
    public Astar(Cell[][] cells, Cell start, Cell end, Heuristic heuristic) {
        openList = new PriorityQueue<>();
        closedList = new ArrayList<>();
        this.heuristic = heuristic;

        this.cells = new AstarCell[cells.length][cells[0].length];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                this.cells[i][j] = new AstarCell(cells[i][j].getType(), i, j);
            }
        }
        this.end = this.cells[end.getX()][end.getY()];
        this.start = this.cells[start.getX()][start.getY()];

        openList.add(this.start);
    }

    @Override
    public AstarCell[][] getCells() {
        return cells;
    }

    @Override
    public AstarCell getCell(int x, int y) {
        return cells[x][y];
    }

    @Override
    public void compute() {
        while (!isFinished()) {
            computeStep();
        }
    }

    private List<AstarCell> getNeighbours(Cell cell) {
        List<AstarCell> neighbours = new ArrayList<>();
        int x = cell.getX();
        int y = cell.getY();

        if (x > 0) { // TOP
            if (cells[x - 1][y].getType() != CellType.WALL) {
                neighbours.add(cells[x - 1][y]);
            }
            if (y > 0 && cells[x - 1][y - 1].getType() != CellType.WALL) { // TOP LEFT
                neighbours.add(cells[x - 1][y - 1]);
            }
            if (y < cells[0].length - 1 && cells[x - 1][y + 1].getType() != CellType.WALL) { // TOP RIGHT
                neighbours.add(cells[x - 1][y + 1]);
            }
        }
        if (x < cells.length - 1) { // BOTTOM
            if (cells[x + 1][y].getType() != CellType.WALL) {
                neighbours.add(cells[x + 1][y]);
            }
            if (y > 0 && cells[x + 1][y - 1].getType() != CellType.WALL) { // BOTTOM LEFT
                neighbours.add(cells[x + 1][y - 1]);
            }
            if (y < cells[0].length - 1 && cells[x + 1][y + 1].getType() != CellType.WALL) { // BOTTOM RIGHT
                neighbours.add(cells[x + 1][y + 1]);
            }
        }
        if (y > 0 && cells[x][y - 1].getType() != CellType.WALL) { // LEFT
            neighbours.add(cells[x][y - 1]);
        }
        if (y < cells[0].length - 1 && cells[x][y + 1].getType() != CellType.WALL) { // RIGHT
            neighbours.add(cells[x][y + 1]);
        }

        return neighbours;
    }

    @Override
    public void computeStep() {
        if (openList.isEmpty()) {// no path available
            closedList.add(end);
            return;
        }
        if (isFinished())
            return;

        AstarCell current = openList.remove();
        List<AstarCell> neighbours = getNeighbours(current);
        Arrays.sort(neighbours.toArray());
        for (AstarCell neighbour : neighbours) {
            if (!closedList.contains(neighbour)) {
                neighbour.setParent(current);
                neighbour.setH(heuristic.compute(neighbour.getX(), neighbour.getY(), end.getX(), end.getY()));
                openList.add(neighbour);
            } else if (!neighbour.equals(start) && neighbour.getG() > current.getParent().getG()) {
                neighbour.setParent(current);
            }
        }
        closedList.add(current);
    }

    @Override
    public boolean isFinished() {
        return closedList.contains(end);
    }

    public List<Cell> getPath() {
        List<Cell> path = new ArrayList<>();
        if (!isFinished())
            return path;

        AstarCell cell = end;
        while (cell != null) {
            path.add(cell);
            cell = cell.getParent();
        }
        return path;
    }
}
