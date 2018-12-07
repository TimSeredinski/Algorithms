package by.bsu.seredinski.algorithm;

import by.bsu.seredinski.entity.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS {

    private Graph graph;
    private int[] startDFS;
    private int[] meetDFS;
    private boolean[] usedVertices;
    private List<Integer> articulationPoints;

    public DFS(Graph graph) {
        this.graph = graph;
        this.startDFS = new int[graph.getNumberOfVertices()];
        this.meetDFS = new int[graph.getNumberOfVertices()];
        this.usedVertices = new boolean[graph.getNumberOfVertices()];
        this.articulationPoints = new ArrayList<>();
    }

    public void findCutVertices(Graph graph) {
        for (boolean v : usedVertices) {
            v = false;
        }
        dfs(0, -1, 0);
    }

    private void dfs(int vertex, int parent, int level) {
        meetDFS[vertex] = startDFS[vertex] = level++;
        usedVertices[vertex] = true;
        int count = 0;
        for (Integer u : graph.getConnectedVertices(vertex)) {
            if (u == parent) {
                continue;
            }
            if (usedVertices[u]) {
                meetDFS[vertex] = Math.min(meetDFS[vertex], startDFS[u]);
            } else {
                dfs(u, vertex,level);
                meetDFS[vertex] = Math.min(meetDFS[vertex], meetDFS[u]);
                count++;
                if (parent != -1 && meetDFS[u] >= startDFS[vertex] && !articulationPoints.contains(vertex)) {
                    articulationPoints.add(vertex);
                }
            }
        }
        if (parent == -1 && count > 1) {
            articulationPoints.add(vertex);
        }

    }

    public List<Integer> getArticulationPoints() {
        return articulationPoints;
    }
}
