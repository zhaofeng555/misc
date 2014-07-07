package hjg.mianshi;

public class Graph {
	private int size;
	private int[][] edge;
	private boolean isDir;

	public Graph(int s, boolean isDir) {
		size = s;
		edge = new int[size][size];
		this.isDir = isDir;
	}

	public void setEdge(int s, int e, int value) {
		edge[s][e] = value;
		if (!isDir) {
			edge[e][s] = value;
		}
	}

	public void print() {
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				System.out.print(edge[r][c] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(6, true);
		g.setEdge(0, 1, 10);
		g.setEdge(0, 2, 25);
		g.setEdge(0, 5, 2);
		g.setEdge(1, 2, 3);
		g.setEdge(2, 3, 8);
		g.setEdge(3, 5, 4);
		g.setEdge(3, 0, 16);
		g.setEdge(5, 4, 5);
		g.setEdge(5, 0, 4);
		g.setEdge(5, 3, 7);
		g.print();

	}
}
