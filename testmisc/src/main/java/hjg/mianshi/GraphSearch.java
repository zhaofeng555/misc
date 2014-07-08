package hjg.mianshi;

//邻接表实现图的广搜和深搜(java模板） 

import java.util.*;

public class GraphSearch {
	private int n; // 图的顶点数，顶点为0,1,2,,,,n-1

	private List<ArrayList<Integer>> G;// 邻接表实现图。
	private boolean[] visited;// 判断顶点是否被访问过

	public GraphSearch(int n, List<ArrayList<Integer>> G) {
		this.n = n;
		this.G = G;
		visited = new boolean[n];
	}

	public static void main(String[] args) {
test();
	}
	public static void test1() {
		int n, m;
		List<ArrayList<Integer>> G;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		G = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++)
			G.add(new ArrayList<Integer>());// 初始化邻接表
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			if (!G.get(u).contains(v)) {// 避免重边的情况比如a b可能出现两次的情况
				G.get(u).add(v);

			}
			// 对于无向图
			if (!G.get(v).contains(u)) {
				G.get(v).add(u);

			}
		}
		GraphSearch ma = new GraphSearch(n, G);
		// ma.dfs(0);
		ma.bfs(0);

	}
	public static void test() {
		int n = 6;

		List<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++)
			G.add(new ArrayList<Integer>());// 初始化邻接表
		
		int a1[]={0,1,2,4};
		int a2[]={1,2,4,5};
		
		for (int i = 0; i < 4; i++) {
			int u = a1[i];
			int v = a2[i];
			if (!G.get(u).contains(v)) {// 避免重边的情况比如a b可能出现两次的情况
				G.get(u).add(v);
				
			}
			// 对于无向图
			if (!G.get(v).contains(u)) {
				G.get(v).add(u);
				
			}
		}
		GraphSearch ma = new GraphSearch(n, G);
		// ma.dfs(0);
		ma.bfs(0);
	}
	
	// 深搜
	private void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		for (int i = 0; i < G.get(v).size(); i++) {
			// 递归调用搜索没有被访问过的当前节点的下一个节点(邻接点)
			int k = G.get(v).get(i);
			if (!visited[k])
				dfs(k);
		}
	}

	// 广搜
	private void bfs(int v) {
		// 队列用来保存被访问节点的分支节点(邻接点)
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(v);
		while (!que.isEmpty()) {
			v = que.poll();
			System.out.print(v + " ");
			visited[v] = true;
			// 将被访问节点的分支节点(邻接点)加入到队列中
			for (int i = 0; i < G.get(v).size(); i++) {
				int k = G.get(v).get(i);
				if (!visited[k]) {
					que.add(k);
					visited[k] = true;
				}
			}
		}
	}
}
/*
运行： 
C:\ex>java   GraphSearch 
6 
10 
0 1 
0 2 
0 3 
1 2 
1 4 
2 4 
2 5 
2 3 
3 5 
4 5 
0 1 2 3 4 5 
*/