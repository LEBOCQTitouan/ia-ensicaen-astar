package edu.ensicaen.model.agent.Astar.Heuristic;

public class ManhattanHeuristic implements Heuristic {
    @Override
    public double compute(int startX, int startY, int endX, int endY) {
        // TODO more accurate heuristic
        return Math.abs(startX - endX) + Math.abs(startY - endY);
    }
}
