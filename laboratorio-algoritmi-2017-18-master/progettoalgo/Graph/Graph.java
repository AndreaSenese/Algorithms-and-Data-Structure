package Graph;


import java.lang.Exception;
import java.util.Set;
import java.util.HashMap;

/**
* @author : Andrea Senese
* @param <V> : Generic Vertex  of Graph
* @param <E> : Generic Edge of Graph
*/

public abstract class Graph<V,E>{
		
		public abstract void addVertex(Vertex<V> vertex) throws Exception;
		public abstract boolean vertexExist(Vertex<V> vertex) throws Exception;	
		public abstract boolean addEdge(Vertex<V> startVertex,Vertex<V> endVertex,Double edge) throws Exception;
		public abstract Set<Vertex<V>> getAllVertices();
		public abstract Set<Vertex<V>> getNeighbors(Vertex<V> vertex);
		public abstract Double getWeight(Vertex<V> startVertex,Vertex<V> endVertex) throws Exception;
		public abstract boolean graphisEmpty();
		public abstract int getNumVertices();
		public abstract HashMap<Vertex<V>,Double> getEdge(Vertex<V> vertex) throws Exception;
		public abstract int getNumEdges() throws Exception;
		public abstract Double getWeight() throws Exception;
}