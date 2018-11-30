package cn.test8910.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.junit.Test;

public class test {
	/**
	 * 字母特征
	 * @throws IOException 
	 */
	@Test
	public void test8() throws IOException {
		
		/**
		 * 输入一行，包含两个整数n和m，分别表示你要输出的图形的行数的列数。
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] string = br.readLine().split(" ");
		char[] a = new char[Integer.parseInt(string[1])];	//设置每行字母的个数
		int row = Integer.parseInt(string[0]);	//设置字母的行数
		
		/**
		 * ABCDEFG
		 * BABCDEF
		 * CBABCDE
		 * DCBABCD
		 * EDCBABC
		 * 假设一行字母已知,立一个tag
		 * 在tag之前
		 * 该行的上一行每个位上的字母为该行对应位上字母减一
		 * 该行的下一行每个位上的字母为该行对应位上字母加一
		 * tag之后相反
		 */
		
		for (int i = 0; i < a.length; i++)	//第二行
			a[i] = (char) ('B' + i);
		
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= a.length; j++) {
				if (j < i)
					a[j-1] = (char) (a[j-1] + 1);
				else
					a[j-1] = (char) (a[j-1] - 1);
			}
			System.out.print(a);
			System.out.println();
		}
	}
	
	
	/**
	 * 数列特征
	 * @throws IOException 
	 */
	@Test
	public void test9() throws IOException {
		
		/**
		 * 第一行为整数num，表示数的个数
		 * 第二行有num个数，为给定的数，每个数的绝对值都小于10000
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] arr = new int[num];
		
		Arrays.sort(str);
		int sum = 0;
		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
			sum += arr[i];
		}
		
		/**
		 * 输出三行，每行一个整数
		 * 第一行表示这些数中的最大值
		 * 第二行表示这些数中的最小值
		 * 第三行表示这些数的和
		 */
		System.out.println(str[num - 1]);
		System.out.println(str[0]);
		System.out.println(sum);
		
	}
	
	
	/**
	 * 查找整数
	 * @throws IOException 
	 */
	@Test
	public void test10() throws IOException {
		
		/**
		 * 第一行包含一个整数n
		 * 第二行包含n个非负整数，为给定的数列，数列中的每个数都不大于10000
		 * 第三行包含一个整数a，为待查找的数
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		@SuppressWarnings("unused")
		int n = Integer.parseInt(br.readLine());
		String str1 = br.readLine().replace(" ", "");
		String str2 = br.readLine();
		
		/**
		 * 如果a在数列中出现了，输出它第一次出现的位置(位置从1开始编号)，否则输出-1
		 */
		int i = str1.indexOf(str2);
		if (i != -1) 
			System.out.println(i+1);
		else
			System.out.println(i);
		
		
		
	}
	
	
}
