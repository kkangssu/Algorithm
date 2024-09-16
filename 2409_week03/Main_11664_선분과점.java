package boj2409_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11664_선분과점 {
	
	static double[] A, B, C, D;
	static double[] AB, AC;		//벡터
	/*
	 * AB*AC < 0 -> 세타 > 90 = C가 A와 가장 가깝다
	 * AB*AC > AB*AB = C가 B와 가장 가깝다
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = new double[3];
		B = new double[3];
		C = new double[3];
		D = new double[3];
		AB = new double[3];
		AC = new double[3];

		for (int i = 0; i < 3; i++) {
			A[i] = Double.parseDouble(st.nextToken());
		}
		for (int i = 0; i < 3; i++) {
			B[i] = Double.parseDouble(st.nextToken());
			AB[i] = B[i] - A[i];
		}
		for (int i = 0; i < 3; i++) {
			C[i] = Double.parseDouble(st.nextToken());
			AC[i] = C[i] - A[i];
		}
		
		double ABAC = dotProduct(AB, AC);
		double ABAB = dotProduct(AB, AB);
		
		double x = ABAC/ABAB;
		if(x < 0) x = 0;				//A와 가장 가까운 경우
		else if(x > 1) x = 1;			//B와 가장 가까운 경우
		
		for (int i = 0; i < 3; i++) {	//선분 AB 위의 점 D와 가장 가까운 경우
			D[i] = A[i] + x*AB[i];		//0 < x < 1
		}
		
		double r = distance(C, D);
		System.out.printf("%.10f\n", r);

	}

	static double dotProduct(double[] arr1, double[] arr2) {
		double n = 0d;
		for (int i = 0; i < 3; i++) {
			n += arr1[i]*arr2[i];
		}
		return n;
	}
	
	static double distance(double[] arr1, double[] arr2) {
		double r2 = 0;
		for (int i = 0; i < 3; i++) {
			r2 += Math.pow(arr1[i] - arr2[i], 2);
		}
		return Math.sqrt(r2);
	}

}
