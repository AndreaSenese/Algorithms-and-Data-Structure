package Graph.usage;

import Graph.*;
import Graph.PriorityQueue.*;
import Graph.prim.*;

// java utils
import java.util.ArrayList;
import java.util.HashMap;

// to read from files
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
  *
  * @author Andrea Senese
  */
public class GraphUsage {
  
  private static final Charset ENCODING = StandardCharsets.UTF_8;

  // reads from file and loads each line in the graph
  private static void loadGraph(String filepath, Prim<String> prim) throws IOException, Exception {
    System.out.print("\nLoading data from file...\n");
    Path inputFilePath = Paths.get(filepath);

    try(BufferedReader fileInputReader = Files.newBufferedReader(inputFilePath, ENCODING)){
      String line = null;
      while((line = fileInputReader.readLine()) != null) {
        String[] tmp = line.split(",");
        Vertex<String> v1 = new Vertex<>(tmp[0]);
        Vertex<String> v2 = new Vertex<>(tmp[1]);
        Double weight = new Double(tmp[2]);
        try {
            prim.addVertex(v1);
            prim.addVertex(v2);
            prim.addEdge(v1, v2, weight);
        } catch(Exception e) {}
      }
    }
    System.out.println(" Done.\n");
  } // loadGraph

  // body of the class
  private static void testWithComparisonFunction(String filepath) throws IOException, Exception, PriorityQueueException {
      Prim<String> prim = new Prim<>();
      loadGraph(filepath, prim);

      System.out.println("Vertices graph number: " + prim.getNumVertices());
      System.out.println("Edges number: " + prim.getNumEdges());
      System.out.printf("\nTotal Weight (km): %.3f\n", prim.getWeight());
     
    UndirectedGraph<String,Double> forest = prim.primSpanningTree(prim.getFirstVertex());
      System.out.println("Vertices mst number: " + forest.getNumVertices());
      System.out.println("Edges number: " + forest.getNumEdges());
      System.out.printf("\nTotal Weight (km): %.3f\n", forest.getWeight()/1000);
  } // testWithComparisonFunction

  /**
    * @param args: command line arguments. It should only contain one argument
    * specifying the filepath of the data file
    */
  public static void main(String[] args) throws IOException, Exception {

    if(args.length < 1)
      throw new Exception("Usage: GraphUsage <file_path_italian_dist_graph>");
    testWithComparisonFunction(args[0]);
  } // main

} // class