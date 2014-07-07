package hjg.mianshi;

public class GraphLinkNode {
	class Node {
		int index;
		int data;
		Node next;

		public Node(int index, int data) {
			this.index = index;
			this.data = data;
			next = null;
		}
	}

	private int size;
	private Node[] adj;
	private int[] visit;

	public GraphLinkNode(int size) {
		this.size = size;
		adj = new Node[size];
	}

	public void setEdge(int s, int e, int value) {
		Node t = new Node(e, value);
		if (adj[s] == null) {
			adj[s] = t;
		} else {
			t.next = adj[s];
			adj[s] = t;
		}
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			Node p = adj[i];
			while (p != null) {
				System.out.print("-->("+i+"," + p.index + "," + p.data + ")");
				p = p.next;
			}
			System.out.println();
		}
	}

	public void beforeSearch() {
		visit = new int[size];
	}

	// depth first search
	public void dfs(int s) {
		visit[s] = 1;
		Node p = adj[s];
		while (p != null) {
			if (visit[p.index] == 0) {
				dfs(p.index);
			}
			p = p.next;
		}
	}

	public void afterSearch() {
		for (int i = 0, len = visit.length; i < len; i++) {
			System.out.print(i+" -> "+visit[i] + "\t");
		}
	}

	public void depthFirstSearch(int s) {
		this.beforeSearch();
		this.dfs(s);
		this.afterSearch();
	}

	public static void main(String[] args) {
		GraphLinkNode g2 = new GraphLinkNode(6);
		g2.setEdge(0, 1, 10);
		g2.setEdge(0, 2, 2);
		g2.setEdge(0, 3, 2);
		g2.setEdge(0, 5, 2);
		g2.setEdge(1, 2, 3);
		g2.setEdge(2, 3, 8);
		g2.setEdge(3, 5, 4);
		g2.setEdge(3, 0, 16);
		g2.setEdge(5, 0, 4);
		g2.setEdge(5, 3, 7);
		g2.print();
		g2.depthFirstSearch(2);
	}
}
