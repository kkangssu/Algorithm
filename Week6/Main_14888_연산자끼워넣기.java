package study0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {

	static int n;
	static int[] num;
	static int[] oper;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		//숫자
		num = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		//연산자
		// + - * /
		oper = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
//		calcul(num[0], 1);
		calcul(num[0]);
		
		System.out.println(max);
		System.out.println(min);

	}
	
	//BFS
	public static void calcul(int number) {
		Queue<Integer> res = new LinkedList<>();	//연산 결과 queue
		Queue<int[]> opera = new LinkedList<>();	//연산자 배열 queue
		
		res.offer(num[0]);
		opera.offer(oper);
		while(!res.isEmpty()) {
			int result = res.poll();
			int[] operator = opera.poll();
			int i = operator[0]+operator[1]+operator[2]+operator[3];
			
			if(i == 0) {	//더이상 연산자가 없는 경우
				max = Math.max(max, result);
				min = Math.min(min, result);
			}
			else {
				if(operator[0] != 0) {	//더하기
					res.offer(result+num[n-i]);
					int[] arr = {operator[0]-1, operator[1], operator[2], operator[3]};
					opera.offer(arr);
				}
				if(operator[1] != 0) {	//빼기
					res.offer(result-num[n-i]);
					int[] arr = {operator[0], operator[1]-1, operator[2], operator[3]};
					opera.offer(arr);
				}
				if(operator[2] != 0) {	//곱하기
					res.offer(result*num[n-i]);
					int[] arr = {operator[0], operator[1], operator[2]-1, operator[3]};
					opera.offer(arr);
				}
				if(operator[3] != 0) {	//나누기
					res.offer(result/num[n-i]);
					int[] arr = {operator[0], operator[1], operator[2], operator[3]-1};
					opera.offer(arr);
				}
			}
			
		}
	}
	
	//DFS
//	public static void calcul(int number, int idx) {
//		if(idx == n) {
//			max = Math.max(max, number);
//			min = Math.min(min, number);
//		}
//		
//		for(int i = 0; i < 4; i++) {
//			if(oper[i] > 0) {
//				oper[i]--;
//				if(i == 0) {
//					calcul(number + num[idx], idx+1);
//				}
//				else if(i == 1) {
//					calcul(number - num[idx], idx+1);
//				}
//				else if(i == 2) {
//					calcul(number * num[idx], idx+1);
//				}
//				else {
//					calcul(number / num[idx], idx+1);
//				}
//				
//				oper[i]++;
//			}
//		}
//	}

}
