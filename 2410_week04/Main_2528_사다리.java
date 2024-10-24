package s10_w4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2528_사다리 {
	
	static class Stick{
		int s;
		int e;
		int d;
		Stick(int s, int e, int d){
			this.s = s;
			this.e = e;
			this.d = d;
		}
	}
	static int N, L;
	static Stick[] f;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		f = new Stick[N+1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int di = Integer.parseInt(st.nextToken());
			if(di == 0) {
				f[i] = new Stick(1, l+1, di);
			}
			else {
				f[i] = new Stick(L-l, L, di);
			}
		}
		f[N] = new Stick(1, L, 0);
		
		System.out.println(goup());

	}

	static int goup() {
		int idx = 0;
		int time = 0;
		while(idx < N) {
			int s = f[idx].s;
			int e = f[idx].e;
			int ns = f[idx+1].s;
			int ne = f[idx+1].e;
			
			if(ns > e || ne < s) {
				time++;
				move();
			}
			else {
				idx++;
			}
		}
		return time;
	}

	static void move() {
		for (int i = 0; i < N; i++) {
			if(f[i].d == 0) {
				if(f[i].e+1 == L) f[i] = new Stick(f[i].s+1, f[i].e+1, 1);
				else f[i] = new Stick(f[i].s+1, f[i].e+1, 0);
			}
			else {
				if(f[i].s-1 == 1) f[i] = new Stick(f[i].s-1, f[i].e-1, 0);
				else f[i] = new Stick(f[i].s-1, f[i].e-1, 1);
			}
		}
		
	}

}
