package cn.test7.com;

/**
 * 矩阵的应用
 * @author zoule
 *
 */
public class Matrix {

	/**
	 * 矩阵乘法
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public double[][] matrixMultiplication(double[][] arr1,double[][] arr2) {
		if (arr1[0].length != arr2.length)
			throw new  RuntimeException( "矩阵输入错误！" ); 
		double[][] arr3 = new double[arr1.length][arr2[0].length];
		for (int i = 0; i < arr1.length; i++)
			for (int j = 0; j < arr2[0].length; j++)
				 for (int k = 0; k < arr2.length; k++)  
					 arr3[i][j] += arr1[i][k] * arr2[k][j];  
		return arr3;
	}
	
	public double[][] years(int year,double arr[][]){
		double[][] a = arr;
		int i = 1;
		if (i < year) {
			a = matrixMultiplication(years(year - 1, arr), arr);
		}
		return a;
	}
	
	public static void main(String[] args) {
		double[][] arr = {{0.8,0.1,0.1},{0.1,0.7,0.2},{0.1,0.2,0.7}};
		double[][] arr2 = {{250000},{100000},{50000}};
		Matrix matrix = new Matrix();
		double[][] b = matrix.matrixMultiplication(matrix.years(3, arr), arr2);
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				System.out.print(b[i][j]);
			}
			System.out.println("");
		}
	}
}
