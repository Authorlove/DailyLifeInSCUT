import java.util.ArrayList;

import java.util.PriorityQueue;

class WeightedGraph<V> {

	// Priority adjacency ArrayLists
	public ArrayList<PriorityQueue<WeightedEdge>> queues;
	private ArrayList<V> vertices; // Store vertices
	public ArrayList<WeightedEdge> edges; // Store edges

	/** Construct a WeightedGraph for vertices 0, 1, 2 and edge ArrayList */
	public WeightedGraph(ArrayList<WeightedEdge> edges, ArrayList<V> vertices) {
		this.edges = edges;
		this.vertices = vertices;
		createQueues(edges, vertices.size());
	}
	/** Create priority adjacency ArrayLists from edge ArrayLists */
	private void createQueues(ArrayList<WeightedEdge> edges,
			int numberOfVertices) {
		queues = new ArrayList<PriorityQueue<WeightedEdge>>();
		for (int i = 0; i < numberOfVertices; i++) {
			queues.add(new PriorityQueue<WeightedEdge>()); // Create a queue
		}

		for (WeightedEdge edge : edges) {
			queues.get(edge.u).offer(edge); // Insert an edge into the queue
		}
	}

	/** Clone an array of queues */
	ArrayList<PriorityQueue<WeightedEdge>> deepClone(
			ArrayList<PriorityQueue<WeightedEdge>> queues) {
		ArrayList<PriorityQueue<WeightedEdge>> copiedQueues = new ArrayList<PriorityQueue<WeightedEdge>>();

		for (int i = 0; i < queues.size(); i++) {
			copiedQueues.add(new PriorityQueue<WeightedEdge>());
			for (WeightedEdge e : queues.get(i)) {
				copiedQueues.get(i).add(e);
			}
		}

		return copiedQueues;
	}

	/** Find single source shortest paths */
	public ShortestPathTree getShortestPath(int sourceIndex, int endIndex) {
		// T stores the vertices whose path found so far
		ArrayList<Integer> T = new ArrayList<Integer>();
		// T initially contains the sourceVertex;
		T.add(sourceIndex);

		// vertices is defined in AbstractGraph
		int numberOfVertices = vertices.size();

		// parent[v] stores the previous vertex of v in the path
		int[] parent = new int[numberOfVertices];
		parent[sourceIndex] = -1; // The parent of source is set to -1

		// costs[v] stores the cost of the path from v to the source
		int[] costs = new int[numberOfVertices];
		for (int i = 0; i < costs.length; i++) {
			costs[i] = Integer.MAX_VALUE; // Initial cost set to infinity
		}
		costs[sourceIndex] = 0; // Cost of source is 0

		// Get a copy of queues
		ArrayList<PriorityQueue<WeightedEdge>> queues = deepClone(this.queues);

		// Expand verticesFound
		while (T.size() < numberOfVertices) {
			int v = -1; // Vertex to be determined
			int smallestCost = Integer.MAX_VALUE; // Set to infinity
			for (int u : T) {
				while (!queues.get(u).isEmpty()
						&& T.contains(queues.get(u).peek().v)) {
					queues.get(u).remove(); // Remove the vertex in
											// verticesFound
				}

				if (queues.get(u).isEmpty()) {
					// All vertices adjacent to u are in verticesFound
					continue;
				}

				WeightedEdge e = queues.get(u).peek();
				if (costs[u] + e.weight < smallestCost) {
					v = e.v;
					smallestCost = (int) (costs[u] + e.weight);
					// If v is added to the tree, u will be its parent
					parent[v] = u;
				}
			} // End of for
//            if(v==-1)
//            	System.out.println("source index "+sourceIndex);
			T.add(v); // Add a new vertex to T
			costs[v] = smallestCost;
			if (v == endIndex)// if reach the destination then stop the loop
				break;
		} // End of while

		// Create a ShortestPathTree
		return new ShortestPathTree(sourceIndex, parent, T, costs);
	}

	/** ShortestPathTree is an inner class in WeightedGraph */
	public class ShortestPathTree {
		private int[] costs; // costs[v] is the cost from v to source
		private int root; // The root of the tree
		private int[] parent; // Store the parent of each vertex
		private ArrayList<Integer> searchOrders; // Store the search order

		/** Construct a path */
		public ShortestPathTree(int root, int[] parent,
				ArrayList<Integer> searchOrders, int[] costs) {
			this.root = root;
			this.parent = parent;
			this.searchOrders = searchOrders;
			this.costs = costs;
		}

		/** Return the cost for a path from the root to vertex v */
		public int getCost(int v) {
			return costs[v];
		}

		/** Return the root of the tree */
		public int getRoot() {
			return root;
		}

		/** Return the parent of vertex v */
		public int getParent(int v) {
			return parent[v];
		}

		/** Return an array representing search order */
		public ArrayList<Integer> getSearchOrders() {
			return searchOrders;
		}

		/** Return number of vertices found */
		public int getNumberOfVerticesFound() {
			return searchOrders.size();
		}

		/** Return the path of vertices from a vertex index to the root */
		public ArrayList<V> getPath(int index) {

			ArrayList<V> path = new ArrayList<V>();

			do {
				path.add(vertices.get(index));
				index = parent[index];
			} while (index != -1);

			return path;
		}

		/** Print a path from the root to vertex v */
		public void printPath(int index) {
			ArrayList<V> path = getPath(index);
			System.out.print("A path from " + vertices.get(root) + " to "
					+ vertices.get(index) + ": ");
			for (int i = path.size() - 1; i >= 0; i--)
				System.out.print(path.get(i) + " ");
		}
	}
}