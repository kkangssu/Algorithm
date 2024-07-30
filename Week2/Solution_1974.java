package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1974 {

	static int[][] sudoku = new int[9][9];
	static boolean[] test; //1~9까지 숫자가 이미 나왔는지 확인 -> 나오면  true
	static boolean sudokuTest;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			//스도쿠가 맞으면 sdokuTest = false
			//틀린 스도쿠면 sdokuTest = true
			sudokuTest = false;

			sb.append("#").append(i+1).append(" ");
			//스도쿠 입력
			for (int j = 0; j < 9; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 9; k++) {
					sudoku[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			for (int j = 0; j < 9; j++) {
				if(tsetX(j) == false || testY(j) == false || test9(j) == false) {
					sudokuTest = true;
					break;
				}
			}
			if(sudokuTest) sb.append(0).append("\n");
			else sb.append(1).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	//9칸에 겹치는 숫자가 있는지 확인
	public static boolean test9(int j) {
		test = new boolean[10];
		boolean res = true;	//테스트 결과: 겹치는 숫자가 없으면 true
		for (int i = 0; i < 9; i++) {
			int x = 3*(j/3) + i/3;
			int y = 3*(j%3) + i%3;
			//sudoku[x][y]가 아직 나오지 않은 숫자라면
			if(test[sudoku[x][y]] == false) {
				//n이 나왔으므로 test[n]을 true로 바꿔준다
				test[sudoku[x][y]] = true;
			}
			else {
				//이미 나온 숫자가 또 나온 경우 -> test 결과가 false
				res = false;
				break;
			}
		}
		return res;
	}
	//세로줄에 겹치는 숫자 있는지 확인
	public static boolean testY(int j) {
		test = new boolean[10];
		boolean res = true;
		for (int i = 0; i < 9; i++) {
			if(test[sudoku[i][j]] == false) {
				test[sudoku[i][j]] = true;
			}
			else {
				res = false;
				break;
			}
		}
		return res;
	}
	//가로줄에 겹치는 숫자 있는지 확인
	public static boolean tsetX(int j) {
		test = new boolean[10];
		boolean res = true;
		for (int i = 0; i < 9; i++) {
			if(test[sudoku[j][i]] == false) {
				test[sudoku[j][i]] = true;
			}
			else {
				res = false;
				break;
			}
		}
		return res;
	}	

}

