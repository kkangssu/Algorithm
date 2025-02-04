package Algo2502;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1003_피보나치함수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int[] arr = new int[T];
        int[][]dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 1;
        dp[1][1] = 0;
        for(int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        for(int i = 2; i <= max; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        for(int i = 0; i < T; i++) {
            sb.append(dp[arr[i]][0]).append(" ").append(dp[arr[i]][1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
