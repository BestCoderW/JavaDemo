package cn.best.com;

import org.junit.Test;

public class CharArray {
	
	/**
	 * 关于深度复制
	 */
	
		@Test
		public void test01() {
			char[] ss = {'a','b','c','d','e','f','g','h'};
			char[] gg = ss;
			
			for (int i = 0,j = ss.length-1; i < ss.length; i++,j--)
				gg[i] = ss[j];
			
			for (int i = 0; i < gg.length; i++)
				System.out.print(ss[i] + " ");
			System.out.println(gg == ss); //true
		}

		@Test
		public void test02() {
			char[] ss = {'a','b','c','d','e','f','g','h'};
			char[] gg = {'a','b','c','d','e','f','g','h'};
			
			for (int i = 0,j = ss.length-1; i < ss.length; i++,j--)
				gg[i] = ss[j];
			
			for (int i = 0; i < gg.length; i++)
				System.out.print(ss[i] + " ");
			System.out.println(gg == ss); //false
		}
}
