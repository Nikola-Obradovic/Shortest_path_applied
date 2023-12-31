package org.example;

import java.util.HashMap;
import java.util.Map;

public class Nodes {
    private final String name;
    private final Map<Nodes, Integer> neighbors;

    public Nodes(String name) {
        this.name = name;
        this.neighbors = new HashMap<>();
    }


    public void addNeighbor(Nodes neighbor, int time) {
        neighbors.put(neighbor, time);
    }

    public Map<Nodes, Integer> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return name;
    }
}
