package Graph;

import java.util.ArrayList;
import java.util.Comparator; 
import Graph.PriorityQueue.*;
import Graph.*;			
import Graph.prim.*;
import java.util.HashMap;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;

/**
 * 
 * @author Senese Andrea
 */
	
	public class GraphTest{

		Vertex<Double> vertex1,vertex2,vertex3;
		private UndirectedGraph<Double,Double> undirectedGraph;
		private DirectedGraph<Double,Double> orientedgraph;
		private Prim<Double> prim;
				@Before //before each tests
				public void GraphTest(){
					vertex1 = new Vertex<Double>(new Double(10));
					vertex2 = new Vertex<Double>(new Double(25));
					vertex3 = new Vertex<Double>(new Double(30));
					undirectedGraph = new UndirectedGraph<Double,Double>();
					orientedgraph = new DirectedGraph<Double,Double>();
					prim = new Prim<Double>();
				}

				@Test
				public void test_isEmpty()throws Exception{
					assertTrue(undirectedGraph.graphisEmpty());
					assertTrue(orientedgraph.graphisEmpty());
				}

				@Test
				public void test_oneEl()throws Exception{
					undirectedGraph.addVertex(vertex1);
					undirectedGraph.addVertex(vertex2);
					undirectedGraph.addEdge(vertex1,vertex2,new Double(200.60));
					assertFalse(undirectedGraph.graphisEmpty());
					
					orientedgraph.addVertex(vertex1);
					orientedgraph.addVertex(vertex2);
					orientedgraph.addEdge(vertex1,vertex2,new Double(200.60));
					assertFalse(orientedgraph.graphisEmpty());
				}


				@Test
				public void test_numVertices()throws Exception{
					undirectedGraph.addVertex(vertex1);
					undirectedGraph.addVertex(vertex2);
					undirectedGraph.addVertex(vertex3);
					assertTrue(3 == undirectedGraph.getNumVertices());

					orientedgraph.addVertex(vertex1);
					orientedgraph.addVertex(vertex2);
					orientedgraph.addVertex(vertex3);
					assertTrue(3 == orientedgraph.getNumVertices());
				}

				@Test
				public void test_numEdges()throws Exception{
					undirectedGraph.addVertex(vertex1);
					undirectedGraph.addVertex(vertex2);
					undirectedGraph.addVertex(vertex3);
					undirectedGraph.addEdge(vertex1,vertex2,new Double(200.60));
					undirectedGraph.addEdge(vertex2,vertex3,new Double(400.60));
					assertTrue(2 == undirectedGraph.getNumEdges()); // quattro perche non orientato quindi ha 2 archi * 2 vertici.

					orientedgraph.addVertex(vertex1);
					orientedgraph.addVertex(vertex2);
					orientedgraph.addVertex(vertex3);
					orientedgraph.addEdge(vertex1,vertex2,new Double(200.60));
					orientedgraph.addEdge(vertex2,vertex3,new Double(400.60));
					assertTrue(2 == orientedgraph.getNumEdges());
				}

				@Test
				public void test_getWeight()throws Exception{
					undirectedGraph.addVertex(vertex1);
					undirectedGraph.addVertex(vertex2);
					undirectedGraph.addVertex(vertex3);
					undirectedGraph.addEdge(vertex1,vertex2,new Double(200.60));
					undirectedGraph.addEdge(vertex2,vertex3,new Double(400.60));
					assertTrue(2 == undirectedGraph.getNumEdges()); // quattro perche non orientato quindi ha 2 archi * 2 vertici.

					orientedgraph.addVertex(vertex1);
					orientedgraph.addVertex(vertex2);
					orientedgraph.addVertex(vertex3);
					orientedgraph.addEdge(vertex1,vertex2,new Double(200.60));
					orientedgraph.addEdge(vertex2,vertex3,new Double(400.60));
					assertFalse(undirectedGraph.getWeight() == orientedgraph.getWeight());
				}


			
				@Test
				public void test_Prim()throws Exception{
					prim.addVertex(vertex1);
					prim.addVertex(vertex2);
					prim.addVertex(vertex3);
					prim.addEdge(vertex1,vertex2,new Double(200.60));
					prim.addEdge(vertex2,vertex3,new Double(400.60));
					prim.addEdge(vertex3,vertex1,new Double(400.60));
					undirectedGraph = prim.primSpanningTree(vertex1);
					assertTrue(601.20 == undirectedGraph.getWeight());
				}						
}
		