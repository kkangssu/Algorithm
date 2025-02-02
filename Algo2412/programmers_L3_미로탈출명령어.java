package Algo2412;

class programmers_L3_미로탈출명령어 {
    
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};
    static int N, M, K;
    static int[] end = new int[2];
    static boolean flag;
    static int[] result;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        K = k;
        end[0] = r-1;
        end[1] = c-1;
        
        //k번으로 도착할 수 없는 경우
        if (!possible(x-1, y-1, k)) {
            return "impossible";
        }
        
        result = new int[k+1];
        if(recur(0, x-1, y-1, 0)) {
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= k; i++) {
                if(result[i] == 0) sb.append('d');
                else if(result[i] == 1) sb.append('l');
                else if(result[i] == 2) sb.append('r');
                else sb.append('u');
            }
            return sb.toString();
        }
        return "impossible";
    }
    
    static boolean recur(int idx, int r, int c, int ch){
        result[idx] = ch;

        if(idx == K) return (r == end[0] && c == end[1]);
        
        if (!possible(r, c, K - idx)) {
            return false;
        }
        
        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(!check(nr, nc)) continue;
            if(recur(idx+1, nr, nc, i)) return true;
        }
        return false;
    }
    
    static boolean possible(int r, int c, int remainDist) {
        int minDist = Math.abs(r - end[0]) + Math.abs(c - end[1]);
        return minDist <= remainDist && (remainDist - minDist) % 2 == 0;
    }
    
    static boolean check(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
