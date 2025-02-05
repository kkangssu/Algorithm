package Algo2502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2668_숫자고르기 {

    static int[] arr;
    static int max;
    static boolean[] visited;
    static List<Integer> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        visited = new boolean[n+1];
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= n; i++){
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);
        int s = list.size();
        sb.append(s).append("\n");
        for(int i = 0; i < s; i++){
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int num, int end){
        if(!visited[arr[num]]){
            visited[arr[num]] = true;
            dfs(arr[num], end);
            visited[arr[num]] = false;
        }
        if(arr[num] == end){
            list.add(num);
        }
    }
}
