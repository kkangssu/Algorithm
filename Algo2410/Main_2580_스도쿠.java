package Algo2410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2580_스도쿠 {
	
	static int[][] sudoku;
	static Set<Integer>[] R;
	static Set<Integer>[] C;
	static Set<Integer>[] nine;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		sudoku = new int[9][9];
		R = new HashSet[9];
		C = new HashSet[9];
		nine = new HashSet[9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			R[i] = new HashSet<>();
			C[i] = new HashSet<>();
			nine[i] = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				R[i].add(sudoku[i][j]);
				C[j].add(sudoku[j][i]);
			}
		}
		
		makeSudoku();
	}

	static void makeSudoku() {
		
		
	}

}
