package org.example;

import junit.framework.TestCase;

import java.util.ArrayList;

public class DijkstraTest extends TestCase {

    public void testAllConnected() {
        //arrlist constraints is empty, constraints will not be applied
        ArrayList<Constraints> constraints = new ArrayList<>();

        Graph graph = new Graph();

        graph.addNode("A", "B", 10, constraints);
        graph.addNode("B", "C", 20, constraints);
        graph.addNode("C", "A", 5, constraints);

        assertEquals(10, Dijkstra.getShortestPath(graph, "A", "B"));
        assertEquals(30, Dijkstra.getShortestPath(graph, "A", "C"));
        assertEquals(25, Dijkstra.getShortestPath(graph, "B", "A"));
        assertEquals(20, Dijkstra.getShortestPath(graph, "B", "C"));
        assertEquals(5, Dijkstra.getShortestPath(graph, "C", "A"));
        assertEquals(15, Dijkstra.getShortestPath(graph, "C", "B"));




    }

    public void testWrongSourceOrDestination(){

        //arrlist constraints is empty, constraints will not be applied
        ArrayList<Constraints> constraints = new ArrayList<>();

        Graph graph = new Graph();

        graph.addNode("A", "B", 4, constraints);
        graph.addNode("B", "A", 2, constraints);

        assertEquals(-1, Dijkstra.getShortestPath(graph, "A", "D"));
        assertEquals(-1, Dijkstra.getShortestPath(graph, "E", "A"));
        assertEquals(-1, Dijkstra.getShortestPath(graph, "E", "F"));

    }
    public void testTwoNodeConnection(){
        //arrlist constraints is empty, constraints will not be applied
        ArrayList<Constraints> constraints = new ArrayList<>();

        Graph graph = new Graph();

        graph.addNode("A", "B", 4, constraints);
        graph.addNode("B", "A", 2, constraints);

        assertEquals(4, Dijkstra.getShortestPath(graph, "A", "B"));
        assertEquals(2, Dijkstra.getShortestPath(graph, "B", "A"));


    }
    public void testNodeWithItself(){
        //arrlist constraints is empty, constraints will not be applied
        ArrayList<Constraints> constraints = new ArrayList<>();

        Graph graph = new Graph();

        graph.addNode("A", "B", 4, constraints);
        graph.addNode("B", "A", 2, constraints);

        assertEquals(0, Dijkstra.getShortestPath(graph, "A", "A"));
        assertEquals(0, Dijkstra.getShortestPath(graph, "B", "B"));


    }
    public void testAppliedConstraints(){

        ArrayList<Constraints> constraints = new ArrayList<>();
        constraints.add(new Constraints("A", "B", 1.0));
        constraints.add(new Constraints("B", "C", 1.0));
        constraints.add(new Constraints("C", "A", 1.0));
        Graph graph = new Graph();

        graph.addNode("A", "B", 4, constraints);
        graph.addNode("B", "C", 2, constraints);
        graph.addNode("C", "A", 8, constraints);

        assertEquals(-1, Dijkstra.getShortestPath(graph, "A", "B"));
        assertEquals(-1, Dijkstra.getShortestPath(graph, "A", "C"));
        assertEquals(-1, Dijkstra.getShortestPath(graph, "B", "A"));
        assertEquals(-1, Dijkstra.getShortestPath(graph, "B", "C"));
        assertEquals(-1, Dijkstra.getShortestPath(graph, "C", "A"));
        assertEquals(-1, Dijkstra.getShortestPath(graph, "C", "B"));
        assertEquals(-1, Dijkstra.getShortestPath(graph, "C", "F"));


    }
    public void testSampleGraph(){
        //arrlist constraints is empty, constraints will not be applied
        ArrayList<Constraints> constraints = new ArrayList<>();

        Graph graph = new Graph();

        graph.addNode("A", "B", 4, constraints);
        graph.addNode("A", "C", 2, constraints);
        graph.addNode("B", "C", 5, constraints);
        graph.addNode("B", "D", 10, constraints);
        graph.addNode("C", "D", 3, constraints);
        graph.addNode("D", "E", 4, constraints);
        graph.addNode("C", "E", 6, constraints);

        assertEquals(4, Dijkstra.getShortestPath(graph, "A", "B"));
        assertEquals(2, Dijkstra.getShortestPath(graph, "A", "C"));
        assertEquals(5, Dijkstra.getShortestPath(graph, "A", "D"));
        assertEquals(8, Dijkstra.getShortestPath(graph, "A", "E"));
        assertEquals(-1, Dijkstra.getShortestPath(graph, "B", "A"));
        assertEquals(5, Dijkstra.getShortestPath(graph, "B", "C"));
        assertEquals(8, Dijkstra.getShortestPath(graph, "B", "D"));
        assertEquals(11, Dijkstra.getShortestPath(graph, "B", "E"));
        assertEquals(-1, Dijkstra.getShortestPath(graph, "C", "A"));
        assertEquals(-1, Dijkstra.getShortestPath(graph, "C", "B"));
        assertEquals(3, Dijkstra.getShortestPath(graph, "C", "D"));
        assertEquals(6, Dijkstra.getShortestPath(graph, "C", "E"));
        assertEquals(-1, Dijkstra.getShortestPath(graph, "D", "A"));
        assertEquals(-1, Dijkstra.getShortestPath(graph, "D", "B"));
        assertEquals(-1, Dijkstra.getShortestPath(graph, "D", "C"));
        assertEquals(4, Dijkstra.getShortestPath(graph, "D", "E"));




    }

    public void testIfGraphIsEmpty(){
        //arrlist constraints is empty, constraints will not be applied
        ArrayList<Constraints> constraints = new ArrayList<>();

        Graph graph = new Graph();

        assertEquals(-1, Dijkstra.getShortestPath(graph, "A", "B"));

    }






}