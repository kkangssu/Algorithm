package s09_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1922_네트워크연결 {
	
	static class Net implements Comparable<Net>{
		int s;
		int e;
		int cost;
		Net(int s, int e, int cost){
			this.s = s;
			this.e = e;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Net o) {
			return this.cost - o.cost;
		}
	}
	
	static int N;
	static int M;
	static Queue<Net> pq = new PriorityQueue<>();
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N+1];

		for (int i = 0; i <M; i++) {
			st = new StringTokenizer(br.readLine());
			Net a = new Net(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			pq.offer(a);
		}
		
		//초기화 -> 본인 부모 = 본인
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		int sum = 0;
		int num = 1;
		while(!pq.isEmpty()) {
			if(num == N) break;
			Net net = pq.poll();
			int start = net.s;
			int end = net.e;
			int cost = net.cost;
			
			if(start == end) continue;
			if(find(start) != find(end)) {
				num++;
				union(start, end);
				sum += cost;
			}
		}
		System.out.println(sum);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a > b) parent[b] = a;
		else parent[a] = b;
	}

	static int find(int a) {
		if(parent[a] == a) return a;
		return find(parent[a]);
	}

}
