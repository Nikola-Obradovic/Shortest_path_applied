package org.example;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {

    public static int getShortestPath(Graph graph, String startNode, String endNode) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<NodesAndDistances> prioQ = new PriorityQueue<>(Comparator.comparingInt(NodesAndDistances::getDistance));

        distances.put(startNode, 0);
        prioQ.offer(new NodesAndDistances(graph.getOneNode(startNode), 0));

        while (!prioQ.isEmpty()) {
            NodesAndDistances current = prioQ.poll();
            Nodes tempNode = current.getNode();
            int tempDist = current.getDistance();


            // Check for node in graph
            if (tempNode != null) {
                if (tempNode.toString().equals(endNode)) {
                    return tempDist;

                }

                for (Map.Entry<Nodes, Integer> oneNeighbor : tempNode.getNeighbors().entrySet()) {
                    Nodes neighborNode = oneNeighbor.getKey();
                    int neighborDist = oneNeighbor.getValue();

                    // Check if path is blocked
                    if (neighborDist < 0) {
                        continue;
                    }
                    int finalDist = tempDist + oneNeighbor.getValue();

                    if (!distances.containsKey(neighborNode.toString()) || finalDist < distances.get(neighborNode.toString())) {
                        distances.put(neighborNode.toString(), finalDist);
                        prioQ.offer(new NodesAndDistances(neighborNode, finalDist));
                    }
                }
            }
        }
        return -1;
    }


}
