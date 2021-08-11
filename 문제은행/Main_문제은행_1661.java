package jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_문제은행_1661 {
	private static int[][] map;			// 인접 행렬 정보
	private static boolean[][] visited;	// Node에 대한 방문 여부
	private static int row, col;				// 미로 크기
	private static int time;
	
	// 						    상, 하, 좌, 우
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	
	private static int sr, sc, er, ec;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol_1661.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 1. 입력 처리
		col = Integer.parseInt(st.nextToken()); // 미로의 가로
		row = Integer.parseInt(st.nextToken()); // 미로의 세로
		
		// 배열들을 생성
		map = new int[row][col];
		visited = new boolean[row][col];
			
		st = new StringTokenizer(br.readLine());
		sc = Integer.parseInt(st.nextToken())-1;
		sr = Integer.parseInt(st.nextToken())-1;
		ec = Integer.parseInt(st.nextToken())-1;
		er = Integer.parseInt(st.nextToken())-1;		
		
		for(int i=0; i<row; i++) {
			String in = br.readLine();
			for(int j=0; j<col; j++) {
				map[i][j] = in.charAt(j)-'0';
			}
		}
		
		time = 0;	// 시간초기화
		
		// 그래프 탐색
		bfs();
		System.out.println();
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();	// 탐색할 노드를 담을 queue
		
		// 1. 첫 방문한 node를 queue에 담기
		queue.offer(new int[] {sr, sc});
		
		// 2. queue에 담은 node를 방문 처리
		visited[sr][sc] = true;
		
		// 3. 탐색시작
		// queue에 방문할 node를 담기 떄문에 queue가 empty라는 것은 모든 노드를 다 방문 했다는 의미, empty가 아니면 계속 방문을 해야 한다. 
		top:
		while(!queue.isEmpty()) {
			int len = queue.size();
			for(int l=0; l<len; l++) {
				int[] curr = queue.poll();		// 현재 방문할 노드를 queue에서 꺼내온다. 
				int r = curr[0];
				int c = curr[1];
				
				// 인접 node를 방문
				for(int i=0; i<4; i++) {
					int nr = r+dr[i];
					int nc = c+dc[i];
					
					// 경계 검사 && 방문하지 않았던 곳이라면 
					if(nr>-1 && nr<row && nc>-1 && nc<col && !visited[nr][nc] && map[nr][nc]==0) {
						// 인접한 node가 도착위치인지 확인
						if(nr==er && nc==ec) {
							time++;
							break top;
						} else {	// 인접 노드가 도착 위치가 아니라면 계속 탐색해야 하는 노드
							queue.offer(new int[] {nr, nc});
							visited[nr][nc] = true;
						}
					}
				}
			}
			time++;
		}
		System.out.println(time);
	}
}
