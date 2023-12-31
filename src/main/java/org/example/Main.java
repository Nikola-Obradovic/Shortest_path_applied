package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {


        //Make a map for places (A -> Alipasino)
        Map<String, String> realNames = new HashMap<>();
        try {
            Scanner s = new Scanner(new File("src/main/java/org/example/places.txt"));
            if (s.hasNextLine()) s.nextLine();
            while (s.hasNext()) {
                String[] lineParts = s.nextLine().split(",");
                String letter = lineParts[0].strip();
                String name = lineParts[1].strip();
                realNames.put(letter, name);
                
            }
            s.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        ArrayList<Constraints> constraints = new ArrayList<>();
        // make arrlist of constraints
        try {
            Scanner s = new Scanner(new File("src/main/java/org/example/constraints.txt"));
            if (s.hasNextLine()) s.nextLine();
            while (s.hasNextLine()) {
                String[] parts = s.nextLine().split(",");
                String start = parts[0].strip();
                String end = parts[1].strip();
                Double p = Double.parseDouble(parts[3].strip());

                constraints.add(new Constraints(start, end, p));
            }
            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        Graph simpleGraph = newGraph("src/main/java/org/example/simple.txt", constraints);
        Graph fivePlacesGraph = newGraph("src/main/java/org/example/five_places.txt", constraints);
        Graph complexGraph = newGraph("src/main/java/org/example/complex.txt", constraints);
        Graph tenPlacesGraph = newGraph("src/main/java/org/example/ten_places.txt", constraints);
        Graph allPlaces_a_Graph = newGraph("src/main/java/org/example/all_places_a.txt", constraints);
        Graph allPlaces_b_Graph = newGraph("src/main/java/org/example/all_places_b.txt", constraints);
        writeToFile(simpleGraph, "Simple_Graph_Output", realNames);
        writeToFile(fivePlacesGraph, "Five_Places_Graph_Output", realNames);
        writeToFile(complexGraph, "Complex_Graph_Output", realNames);
        writeToFile(tenPlacesGraph, "Ten_Places_Graph_Output", realNames);
        writeToFile(allPlaces_a_Graph, "All_Places_a_Graph_Output", realNames);
        writeToFile(allPlaces_b_Graph, "All_Places_b_Graph_Output", realNames);


    }

    private static void writeToFile(Graph graph, String fileName,  Map<String, String> realNames) throws IOException {
        FileWriter fw = new FileWriter(fileName + ".txt");
        for (String startNodeLetter : graph.getNodes().keySet()) {
            String startNodeRealName = realNames.getOrDefault(startNodeLetter, startNodeLetter);

            for (String endNodeLetter : graph.getNodes().keySet()) {
                if (!startNodeLetter.equals(endNodeLetter)) {

                    String endNodeRealName = realNames.getOrDefault(endNodeLetter, endNodeLetter);
                    int shortestPath = Dijkstra.getShortestPath(graph, startNodeLetter, endNodeLetter);
                    fw.write(startNodeRealName + " to " + endNodeRealName + " - " + shortestPath + "\n");
                }
            }
        }
        fw.close();

    }


    private static Graph newGraph(String path, ArrayList<Constraints> constraints) {
        Graph graph = new Graph();

        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNext()) {
                String[] parts = scanner.nextLine().split(" ");
                String start = parts[0].strip();
                String end = parts[1].strip();
                Integer time = Integer.parseInt(parts[2].strip());

                graph.addNode(start, end, time, constraints);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return graph;

    }
}