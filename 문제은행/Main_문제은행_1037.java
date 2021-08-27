package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_문제은행_1037 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int changeR=0, changeC=0;	// 수정 가능시 수정할 좌표
		
		// 행 별로 탐색하며 1이 홀수개인 행 갯수 count
		int rflag = 0;
		for(int r=0; r<N; r++) {
			int cnt = 0;	// 한 열에 1의 개수
			for(int c=0; c<N; c++) {
				if(map[r][c]==1) {
					cnt++;
				}
			}
			if(cnt%2==1) {
				rflag++;
				changeR = r+1;
				if(rflag==2) break;		// 1이 홀수개인 행의 개수가 2개이상이라면 탈출
			}
		}
		
		// 열 별로 탐색하며 1이 홀수개인 열 갯수 count
		int cflag = 0;
		for(int c=0; c<N; c++) {
			int cnt = 0;
			for(int r=0; r<N; r++) {
				if(map[r][c]==1) {
					cnt++;
				}
			}
			if(cnt%2==1) {
				cflag++;
				changeC = c+1;
				if(cflag==2) break;		// 1이 홀수개인 열의 개수가 2개이상이라면 탈출
			}
		}
		
		if(rflag==0 && cflag==0) System.out.println("OK");
		else if(rflag==1 && cflag==1) System.out.println("Change bit ("+changeR+","+changeC+")");
		else System.out.println("Corrupt");
	}

}
