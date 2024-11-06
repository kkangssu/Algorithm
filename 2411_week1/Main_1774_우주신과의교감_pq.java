package s2411_w1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1774_우주신과의교감_pq {
	
	//간선 저장용
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		double l;
		Edge(int s, int e, double l){
			this.s = s;
			this.e = e;
			this.l = l;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.l, o.l);
		}
	}
	//신 위치 저장용
	static class RC{
		int r;
		int c;
		RC(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static int N, M;
	static RC[] sin;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sin = new RC[N];
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			sin[i] = new RC(r, c);
		}
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		//이미 연결된 간선
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			union(a, b);
		}
		
		//연결 가능한 모든 간선 저장 -> PQ: 정렬할 필요 없음
		Queue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
            	double l = len(sin[i], sin[j]);
                pq.offer(new Edge(i, j, l));
            }
        }
        
        // 크루스칼 알고리즘 수행
        double result = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(find(edge.s) != find(edge.e)) {	//시작점, 끝점의 루트가 다르다면(연결되지 않았다면)
                union(edge.s, edge.e);	//연결
                result += edge.l;	//거리 더함
            }
        }
        
        System.out.printf("%.2f%n", result);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	static int find(int i) {
		if(parent[i] == i) return i;
		return parent[i] = find(parent[i]);
	}
	
	//거리 구하는 메서드
	static double len(RC a, RC b) {
		return Math.sqrt(Math.pow(a.r-b.r, 2) + Math.pow(a.c-b.c, 2));
	}

}
