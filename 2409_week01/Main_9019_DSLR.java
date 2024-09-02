//메모리초과????

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019_DSLR {
	
	static int T;
	static int A;
	static int B;
	static Map<Integer, String> oper;
	static String str;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			str = "";
			oper = new HashMap<>();
			makeB(A);
			sb.append(str).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void makeB(int num) {
		Queue<Integer> nq = new LinkedList<>();
		nq.offer(num);
		oper.put(num,"");
		while(!nq.isEmpty()) {
			int now = nq.poll();
			for (int i = 0; i < 4; i++) {
				int next;
				//D
				if(i == 0) {
					next = (now*2)%10000;
					if(!oper.containsKey(next)) {
						oper.put(next, oper.get(now)+"D");
						System.out.println(next + ": " + oper.get(next));
					}
				}
				//S
				else if(i == 1) {
					next = now - 1;
					if(next == 0) next = 9999;
					if(!oper.containsKey(next)) {
						oper.put(next, oper.get(now)+"S");
						System.out.println(next + ": " + oper.get(next));
					}
				}
				//L
				else if(i == 2) {
					int a = now/1000;
					next = (now*10)%10000 + a;
					if(!oper.containsKey(next)) {
						oper.put(next, oper.get(now)+"L");
						System.out.println(next + ": " + oper.get(next));
					}
				}
				else {
					int a = now%10;
					next = (now/10) + a*1000;
					if(!oper.containsKey(next)) {
						oper.put(next, oper.get(now)+"R");
						System.out.println(next + ": " + oper.get(next));
					}
				}
				if(next == B) {
					str = oper.get(next);
					return;
				}
				nq.offer(next);
			}
			
		}
	}

}
