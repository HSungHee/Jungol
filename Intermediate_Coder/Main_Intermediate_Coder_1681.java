package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_Intermediate_Coder_1681 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		visited = new boolean[N];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		dfs(0, 0, 0);	// 현재 장소 번호, 방문한 장소 수, 현재까지 이동하는 비용의 합
		System.out.println(min);
	}
	private static void dfs(int curr, int cnt, int sum) {
		if(sum>min) return; 	// 기존의 합보다 현재까지의 비용의 합이 크다면 더 볼 필요 X, return

		if(cnt==N-1) {	// 전부다 방문했다면
			if(map[curr][0]!=0) min = Math.min(min, sum+map[curr][0]);	// 마지막좌표에서 0으로 되돌아가는 비용 누적
			return;
		}
		
		// 인접 장소 방문해보기
		for(int adj=1; adj<N; adj++) {
			if(!visited[adj] && map[curr][adj]!=0) {
				visited[adj] = true;	// 방문처리
				dfs(adj, cnt+1, sum+map[curr][adj]);
				visited[adj] = false;	// 방문취소처리
			}
		}
	}
	static String src = "6\r\n" + 
			"0 93 23 32 39 46 \r\n" + 
			"0 0 7 58 59 13 \r\n" + 
			"40 98 0 14 33 98 \r\n" + 
			"3 39 0 0 13 16 \r\n" + 
			"51 25 19 88 0 47 \r\n" + 
			"65 81 63 0 6 0 ";
}
