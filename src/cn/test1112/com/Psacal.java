package cn.test1112.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class Psacal {

	/**
	 * 杨辉三角
	 * @throws IOException
	 */
	@Test
	public void test11() throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int row = Integer.parseInt(br.readLine());
		int[][] arr = new int[35][35];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j <= i; j++) {
				
				if(j == 0 || j == i){
					arr[i][j] = 1;
				} else {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				}
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 水仙花数
	 */
	@Test
	public void test12(){
		
		for(int i = 1; i < 10; i++)
			for(int j = 0; j < 10; j++)
				for(int k = 0; k < 10; k++){	
					int m = i * 100 + j * 10 + k;
					int n = i * i * i + j * j * j + k * k * k;
					if(m == n){
						System.out.println(m);
					}
				}
	}
}
