package Algo2408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution_1204	{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
		        //idx 0 ~ 100까지 배열을 만들어 각 점수가 나오면 배열[점수]+1
            int[] score = new int[101];
            //for문 여러번 쓰면 시간이 많이 걸려 점수 받으면서 최빈값 연산
            int max = 0;    //가장 많이 나온 횟수
            int maxScore = 0;    //가장 많이 나온 점수
            
            String s = br.readLine(); //굳이 왜?
            sb.append("#").append(i+1).append(" ");
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 1000; j++) {
                int n = Integer.parseInt(st.nextToken());
                score[n]++;
                if(max < score[n]) {
                    max = score[n];
                    maxScore = n;
                }
                else if(max == score[n]) {    //나온 횟수가 같으면 점수가 높은 걸로
                    maxScore = Math.max(maxScore, n);
                }
            }
            sb.append(maxScore).append("\n");           
        }
        System.out.println(sb.toString());
    }
}
