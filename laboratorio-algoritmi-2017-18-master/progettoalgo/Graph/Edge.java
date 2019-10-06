package Graph;

/**
* @author : Andrea Senese
* @param <E> : Generic Vertex and Edge of Graph
*/

public class Edge{
	
	 // this elem is used for Prim Algorithm.
	private double weight; //weight of arc of Graph.

	public Edge(double weight){
		this.weight = weight;
	}

	public double getWeight(){
		return this.weight;
	}
}