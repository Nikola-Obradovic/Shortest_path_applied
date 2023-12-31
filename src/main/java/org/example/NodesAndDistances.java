package org.example;

public class NodesAndDistances {

    private final Nodes node;
    private final int distance;

    public NodesAndDistances(Nodes node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public Nodes getNode() {
        return node;
    }

}
