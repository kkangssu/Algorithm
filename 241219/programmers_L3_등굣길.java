import java.util.*;

class Solution {
  static int[][] dp;
	static int N, M;
	
	public int solution(int m, int n, int[][] puddles) {
		dp = new int[n][m];
		N = n;
		M = m;
		dp[0][0] = 1;
		for (int i = 0; i < puddles.length; i++) {
			int r = puddles[i][1]-1;
			int c = puddles[i][0]-1;
			dp[r][c] = -1;
		}
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if(dp[r][c] < 0) continue;
				if(r >= 1 && dp[r-1][c] >= 0) dp[r][c] = (dp[r][c] + dp[r-1][c]);
				if(c >= 1 && dp[r][c-1] >= 0) dp[r][c] = (dp[r][c] + dp[r][c-1]);
				dp[r][c] %= 1000000007;
			}
		}
		
        return dp[n-1][m-1];
    }
}
