class WeightedEdge implements Comparable<WeightedEdge> {
	public int u, v;
	public double weight;

	WeightedEdge(int u, int v, double weight) {
		this.u = u;
		this.v = v;
		this.weight = weight;
	}

	public void addWeight(int add) {
		weight += add;
	}

	@Override
	/** Compare two edges on weights */
	public int compareTo(WeightedEdge edge) {
		if (weight > edge.weight)
			return 1;
		else if (weight == edge.weight) {
			return 0;
		} else {
			return -1;
		}
	}
}