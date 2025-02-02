package Algo2502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2342_DanceDanceRevolution {

    static int n;
    static int[] arr;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        n = str.length()/2; //지시 사항 개수
        arr = new int[n];   //지시 사항 배열
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[5][5][n];  //[왼발 위치][오른발 위치][지시 사항 번호]
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int result = dp(0, 0, 0);

        System.out.println(result);
    }

    static int dp(int l, int r, int idx) {
        if(idx == n) return 0;
        if(dp[l][r][idx] != -1) return dp[l][r][idx];

        // 왼발 움직이는 경우 / 오른발 움직이는 경우 중 작은 값 고름
        dp[l][r][idx] = Math.min(dp(arr[idx], r, idx+1) + energy(l, arr[idx]), dp(l, arr[idx], idx+1) + energy(r, arr[idx]));

        return dp[l][r][idx];
    }

    static int energy(int s, int e){
        if(s == 0) return 2;
        int diff = Math.abs(s - e);
        if(diff == 0) return 1;
        else if(diff == 1 || diff == 3) return 3;
        return 4;
    }
}
