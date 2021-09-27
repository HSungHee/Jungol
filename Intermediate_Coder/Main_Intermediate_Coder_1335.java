package jungol;

/**
8
1 1 0 0 0 0 1 1
1 1 0 0 0 0 1 1
0 0 0 0 1 1 0 0
0 0 0 0 1 1 0 0
1 0 0 0 1 1 1 1 
0 1 0 0 1 1 1 1
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_Intermediate_Coder_1335 {
	private static int[][] paper;
	private static int blue=0;
	private static int white=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		// 색종이 수
		
		paper = new int[N][N];	// 색종이 정보값 담는 배열
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		fold(0, 0, N);		// 시작위치 r, c과 영역 크기
		System.out.println(white);
		System.out.println(blue);
		
	}

	private static void fold(int r, int c, int n) {
		int half = n >> 1;		// 현재 영역의 크기의 절반
		boolean same = true;	// 현재 영역의 색종이 색이 같은지 여부 판단 boolean 변수
			
		top:
		for(int i=r; i<r+n; i++) {
			for(int j=c; j<c+n; j++){
				if(paper[r][c]!=paper[i][j]) {	// 만약 현재 영역의 첫번째 색종이의 색과 다음 나오는 색들 중 다른게있다면
					same = false;				// 색종이 다른거 발견 표시후
					break top;					// 영역 탐색 종료
				}
			}
		}
	
		if(same) {	// 위의 탐색에서 현재 영역의 색종이 색이 모두 같았다면
			if(paper[r][c]==1) blue++;	// 같았던 색종이 색 값이 1이라면, blue
			else white ++;				// 				  0이라면, white
			
			return;
		} else {	// 위의 탐색에서 현재 영역의 색종이 색이 다른 것이 존재했다면, 영역을 반으로 줄이고 재탐색
			fold(r, c, half);			// 위쪽 좌측 영역
			fold(r, c+half, half);		// 위쪽 우측 영역
			fold(r+half, c, half);		// 아래쪽 좌측 영역
			fold(r+half, c+half, half);	// 아래쪽 우측 영역
		}	
	}
}
