package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_KOI_2577_한성희 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 벨트에 놓인 접시 수
		int d = Integer.parseInt(st.nextToken());	// 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken());	// 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken());	// 쿠폰 번호
		
		int[] sushi = new int[N];	// 벨트위에 놓인 초밥들
		int[] visited = new int[d+1];	// 현재 먹은 초밥의 종류 표시
		
		visited[c] = 1;	// 보너스 초밥 표시
		
		// 초밥 입력받기
		for(int i=0; i<N; i++) {	
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		// 1. 처음부터 k개의 초밥 연달아 먹기 
		for(int i=0; i<k; i++) {	
			visited[sushi[i]]+=1;	// visited배열의 해당 초밥 번호에 해당하는 인덱스 1증가
		}
		int front = 0;	// 시작 인덱스
		int back = k-1;	// 끝 인덱스
		
		int cnt = 0;	// 초밥 가짓수
		for(int i=1; i<d+1; i++) {
			if(visited[i]>0) cnt++;	// 초밥 가짓수가 1이상이면 현재 먹었다는 것임으로 cnt 증가
		}
		
		int max = cnt;	// 초밥 가짓수의 최대값 (시작은 처음 k개 연달아 먹은 경우의 가짓수로 초기화)
		for(int i=1; i<N; i++) {
			// 1. list의 처음 값 처리(삭제)
			visited[sushi[front]]-=1;	// 맨 앞의 초밥 방문 표시 1 감소
			if(visited[sushi[front]]==0) cnt--;	// 해당 초밥 방문 표시 감소 후, 0이라면 가짓수에서 1 감소
			front = (front+1)%N;	// front 인덱스 1 증가
			
			// 2. list에 새로운 끝 값 넣기
			back = (back+1)%N;		// back 인덱스 1 증가
			if(visited[sushi[back]]==0) cnt++;	// 끝에 새로 넣은 초밥이 새로운 종류라면, 가짓수 1 증가
			visited[sushi[back]]+=1;	// 추가된 초밥 방문 표시 1 증가

			// 현재 연속된 k개의 초밥 가짓수와 기존의 초밥 가짓수의 최대값 중 더 큰 값으로 최대값 갱신
			max = Math.max(max, cnt);	 
		}	
		System.out.println(max);
	}
	static String src = "8 30 4 30\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"7\r\n" + 
			"30\r\n" + 
			"2\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"25";
}
