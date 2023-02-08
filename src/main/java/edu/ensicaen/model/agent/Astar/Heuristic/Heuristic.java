package edu.ensicaen.model.agent.Astar.Heuristic;

public interface Heuristic {
    double compute(int startX, int startY, int endX, int endY);
}
