package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_문제은행_2260 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		// 행렬 크기
		int[][] map = new int[N][N];
		
		// 배열 초기화
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int rflag = 0, cflag = 0;	// 행기준 오류개수, 열기준 오류개수
		int cnt = 0;	// 오류 수 count
		int x=0, y=0;	// 좌표 1개 수정 필요시, 좌표값 저장
		
		// 행 탐색
		for(int r=0; r<N; r++) {	
			cnt = 0;
			for(int c=0; c<N; c++) {
				if(map[r][c]==1) cnt++;		// 해당 행의 1의 개수 count
			}
			if(cnt%2==1) {	// 해당 행에 1이 홀수개 있다면
				if(rflag==1) {		// 이미 rflag 값이 1이라면
					rflag++;		// rflag를 2로 갱신하고
					break;			// 반복문 탈출
				}
				rflag++;	// rflag 증가
				x = r;		// 현재 행 번호 x에 저장
			}
		}
		
		// 열 탐색
		for(int c=0; c<N; c++) {
			cnt = 0;
			for(int r=0; r<N; r++) {
				if(map[r][c]==1) cnt++;		// 해당 열의 1의 개수 count
			}
			if(cnt%2==1) {			//해당 열에 1이 홀수개 있다면
				if(cflag==1) {		// 이미 cflag 값이 1이라면
					cflag++;		// cflag를 2로 갱신하고
					break;			// 반복문 탈출
				}
				cflag++;		// cflag 증가
				y = c;			// 현재 열 번호 y에 저장
			}
		}		
		
		if(rflag==0 && cflag==0) {		// 행과 열, 모두 1이 짝수개라면
			System.out.println("OK");	
		} else if(rflag==1 && cflag==1) {	// 행과 열, 모두 1이 홀수개인게 한번씩 존재한다면
			System.out.println("Change bit ("+(x+1)+","+(y+1)+")");
		} else {		// 나머지 경우
			System.out.println("Corrupt");	
		}
	}
}