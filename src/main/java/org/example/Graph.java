package org.example;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;
import java.util.Random;


public class Graph {

    private final Map<String, Nodes> nodes;
    public Graph() {
        this.nodes = new HashMap<>();
    }
    public void addNodeToMap(String name) {
        nodes.putIfAbsent(name, new Nodes(name));
    }

    public void addNode(String start, String end, Integer time, ArrayList<Constraints> constraints) {
        addNodeToMap(start);
        addNodeToMap(end);

        Nodes startNode = nodes.get(start);
        Nodes endNode = nodes.get(end);
        boolean randProbConstraint = getProbForConstraints(start, end, constraints);
        if(randProbConstraint) {
           startNode.addNeighbor(endNode, time);

        }
        else {
            startNode.addNeighbor(endNode, -1);
        }

    }

    private boolean getProbForConstraints(String start, String end, ArrayList<Constraints> constraints) {
        for(Constraints constraint : constraints) {
            if(constraint.getA().equals(start) && constraint.getB().equals(end)) {
                double p = constraint.getProbability();

                Random random = new Random();
                double randomDouble = random.nextDouble();
                if (p!=0.0 && randomDouble <= p) {
                    return false;
                }
            }
        }
        return true;
    }

    public Nodes getOneNode(String name) {
        return nodes.get(name);
    }


    public Map<String, Nodes> getNodes() {
        return nodes;
    }

}
