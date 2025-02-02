package Algo2410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15922_아우으우아으이야 {
	
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long s = Integer.parseInt(st.nextToken());	//처음 시작
		long e = Integer.parseInt(st.nextToken());	//처음 끝
		long l = 0;
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			long ns = Integer.parseInt(st.nextToken());	//다음 시작
			long ne = Integer.parseInt(st.nextToken());	//다음 끝
			if(ns < e) {
				e = Math.max(ne, e);	//시작을 기준으로 정렬했기 때문에 끝만 확인하면 된다
			}
			else {	//선분이 이어지지 않는다는 의미이므로 총 합에 지금까지 길이 더하고 새로운 시작, 끝 설정
				l += (e-s);
				s = ns;
				e = ne;
			}
		}
		l += (e-s);
		System.out.println(l);
	}
}
