package Algo2410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * <다익스트라 기본 코드>
 *     static void dijkstra(int start) {
        //우선 순위 큐 사용, 가중치를 기준으로 오름차순한다.
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        //시작 노드에 대해서 초기화
        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            //현재 최단 거리가 가장 짧은 노드를 꺼내서 방문 처리 한다.
            Node now = q.poll();

            if (!visit[now.v]) {
                visit[now.v] = true;
            }

            for (Node next : graph[now.v]) {

                //방문하지 않았고, 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧을 경우
                if (!visit[next.v] && dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }
 */

public class Main_13308_주유소 {
	
	static class Node implements Comparable<Node>{
		int arrive;
		int length;
		int minPrice;	//현재까지 최소 금액
		long total;	//현재까지 주유값 합
		Node(int arrive, int minPrice, long total){	//이건 최소 가격 비교하려고
			this.arrive = arrive;
			this.minPrice = minPrice;
			this.total = total;
		}
		
		Node(int arrive, int length){	//이건 그래프 노드 저장하려고
			this.arrive = arrive;
			this.length = length;
		}
		@Override
		public int compareTo(Node o) {
			if(this.total > o.total) return 1;
			return -1;
		}
	}
	static int city, road;
	static int[] oil;
	static long[][] visited;
	static List<Node>[] list;
	static long total;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		city = Integer.parseInt(st.nextToken());
		road = Integer.parseInt(st.nextToken());
		oil = new int[city+1];
		visited = new long[city+1][2500+1];
		
		//전에 visited 배열을 같은 위치여도 방문 방향에 따라 다르게 생각함 -> 같은 도시에 방문하더라도 최소 금액이 다른 경우 다른 visited로 봐야한다
		//new long[city+1][N]으로 초기화하고 싶었는데 솔직히 2501은 낭비니까
		//Map<Integer, Integer> match = new HashMap<>();
		//for (int i = 0; i < city; i++) {
		//	match.put(oil[i+1], i);
		//}
		//으로 비용 = key value = index로 저장해서
		//visited[next.arrive][match.get(now.minPrice)] = tmp;로 매칭했는데 메모리, 시간이 더 걸림 그냥 쓰레기 배열을 만드는게 좋음
		
		for (int i = 0; i <= city; i++) {
			Arrays.fill(visited[i], Long.MAX_VALUE);
		}
		list = new ArrayList[city+1];
		
		//주유비
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= city; i++) {
			oil[i] = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<>();
		}
		//도로
		for (int i = 0; i < road; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			list[c1].add(new Node(c2, l));
			list[c2].add(new Node(c1, l));
		}
		
		Dijkstra();
		System.out.println(total);
	}

	static void Dijkstra() {
		Queue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, oil[1], 0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.arrive == city) {
				total = now.total;
				return;
			}
			for(Node next: list[now.arrive]) {
				long nextCost = now.total + now.minPrice*next.length;	//지금의 최소 주유비로 now.arrive까지 갈 때 총 비용
				
				if(visited[next.arrive][now.minPrice] <= nextCost) continue;	//근데 이 비용보다 적은 비용으로 방문한적이 있어 -> continue
				
				visited[next.arrive][now.minPrice] = nextCost;	//지금 도착이 최소 금액이야
				int nextMinPrice = Math.min(now.minPrice, oil[next.arrive]);	//다음 도시(next.arrive)까지 갈 때 최소 주유비는?
				pq.offer(new Node(next.arrive, nextMinPrice, nextCost));
			}
		}
		return;
	}

}
