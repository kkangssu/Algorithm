package Algo2412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_1644_소수의연속합 {
	
	static int N;
	static boolean[] prime;
	static long[] pSum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		prime = new boolean[N+1];

		findPrime();
		System.out.println(prefixSum());
	}

	static int prefixSum() {
		int cnt = 0;
		int s = 0;
		int e = 1;
		while(s < pSum.length && e < pSum.length) {
			long sum = pSum[e] - pSum[s];
			if(sum == N) {
				cnt++;
				e++;
			}
			else if(sum < N) e++;
			else s++;
		}
		return cnt;
	}

	static void findPrime() {
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if(prime[i]) {
				for (int j = i*i; j <= N; j += i) {
					prime[j] = false;
				}
			}
		}
		List<Integer> p = new ArrayList<>();
		for (int i = 2; i <= N; i++) {
			if(prime[i]) p.add(i);
		}
		//System.out.println(p);
		
		pSum = new long[p.size()+1];
		for (int i = 1; i <= p.size(); i++) {
			pSum[i] = pSum[i-1] + p.get(i-1);
		}
	}

}
