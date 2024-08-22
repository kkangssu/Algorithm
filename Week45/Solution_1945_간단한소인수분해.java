import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1945_간단한소인수분해 {
    static int T;
    static int N;
    static int[] nums = {11, 7, 5, 3, 2};
    static int[] abcde;
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t<= T; t++) {
        	N = Integer.parseInt(br.readLine());
        	abcde = new int[5];
        	factorization(N, 0);
        }
	}

	static void factorization(int num, int idx) {
		
		
	}

}
