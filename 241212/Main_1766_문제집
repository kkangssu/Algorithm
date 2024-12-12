import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_1766_문제집 {
	
	static ArrayList<Integer>[] graph;
	static int N, M;
	static int[] cnt;
	static int idx = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		cnt = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph[s].add(e);
			cnt[e]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if(cnt[i] == 0) {
				pq.offer(i);
			}
		}

		while(!pq.isEmpty()) {
			int now = pq.poll();
			sb.append(now).append(" ");
			for(int next: graph[now]) {
				cnt[next]--;
				if(cnt[next] == 0) pq.offer(next);
			}
		}
		
		System.out.println(sb.toString());	

	}

}
