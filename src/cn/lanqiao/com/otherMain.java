package cn.lanqiao.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.junit.Test;

public class otherMain {

	/**
	 * A to a
	 * @throws IOException
	 */
	@Test
	public void test01() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char i = br.readLine().charAt(0);
		i += 32;
		System.out.println(i);
		
	}
	
	/**
	 * 进制
	 * @throws IOException 
	 */
	@Test
	public void test02() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int s = Integer.parseInt(str,16);

		System.out.print("Hex: 0x");		//十六进制
		System.out.printf("%03X %n",s);
		System.out.print("Decimal: ");		//十进制
		System.out.printf("%d %n", s);
		System.out.print("Octal: ");		//八进制，不够补零
		System.out.printf("%04o",s);
		
	}
	
	/**
	 * 水分子数
	 * @throws IOException
	 */
	@Test
	public void test03() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double quart = Double.parseDouble(br.readLine());
		
		double count = quart * 950 / (Math.pow(10, -23) * 3);
		
		int nn = 0;		//判断指数的位数
		
		while (count > 10) {
			count /= 10;
			nn++;
		}
		
		System.out.printf("%7.6f",count);
		
		if (nn == 0) {
			System.out.print("E+00" + nn);
		} else {
			System.out.print("E+0" + nn);
		}
	}
	
	/**
	 * 斐波那契数列
	 * @throws IOException
	 */
	@Test
	public void test04() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int f1 = 1,f2 = 1,f3 = 0;
		
		if (n < 3) {
			
			System.out.print(1);
			return;
			
		}
		
		for (int i = 3; i <= n; i++) {
			
			if (f1 > 10007) f1 %= 10007;
			if (f2 > 10007) f2 %= 10007;
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
			
		}
		
		System.out.print(f3%10007);
	}
	
	/**
	 * 圆的面积
	 */
	@Test
	public void test05() {
		
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		
		double s = r * r * Math.PI;
		
		System.out.printf("%.7f",s);
		
		sc.close();
		
	}
	
	/**
	 * 求前n项和
	 */
	@Test
	public void test06() {
		Scanner sc = new Scanner(System.in);
		long r = sc.nextInt();
		
		long sum = (1 + r) * r / 2;
		
		System.out.print(sum);
		
		sc.close();
	}
	
}













