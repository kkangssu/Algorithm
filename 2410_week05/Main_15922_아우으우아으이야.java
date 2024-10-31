package s10_w5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15922_아우으우아으이야 {
	
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long s = Integer.parseInt(st.nextToken());
		long e = Integer.parseInt(st.nextToken());
		long l = 0;
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			long ns = Integer.parseInt(st.nextToken());
			long ne = Integer.parseInt(st.nextToken());
			if(ns < e) {
				e = Math.max(ne, e);
			}
			else {
				l += (e-s);
				s = ns;
				e = ne;
			}
			
			//System.out.println(s+ " " +e + " -> " + l);
		}
		l += (e-s);
		System.out.println(l);

	}

}
