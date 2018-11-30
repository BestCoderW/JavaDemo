package cn.test5.com;

/**
 * 舞伴配对
 * @author zoule
 *
 * @param <T>
 */
public class Dancing<T> {

	public void partnerPairing(T[] obj1,T[] obj2) {
		
		//将传入的两个数组分别压入男、女生队列
		sequenceQueue<T> qBoy = new sequenceQueue<T>();
		for (int i = 0; i < obj1.length; i++) qBoy.EnQueue(obj1[i]);
		sequenceQueue<T> qGirl = new sequenceQueue<T>();
		for (int i = 0; i < obj2.length; i++) qGirl.EnQueue(obj2[i]);

		System.out.println("第一轮舞曲开始！");
		System.out.println("下面有请女士们先生们有序入场并寻找自己的舞伴:");
		
		for (int j = 0; j < obj2.length; j++) 
			System.out.println("第" + (j+1) + "对舞侣是：" + qBoy.DeQueue() + "--" + qGirl.DeQueue());
		if (!qBoy.isEmpty() || !qGirl.isEmpty())
			System.out.println("第一轮配对已结束，还未找到舞伴的请有序离场等待下一轮配对！");
	}
	
	public static void main(String[] args) {
		String[] arr1 = {"王祖蓝","黄晓明","谢霆锋","罗志祥","许嵩","周杰伦","马天宇","胡歌"};
		String[] arr2 = {"热巴","baby","王菲","唐忆昕","刘亦菲","赵丽颖","杨幂"};
		Dancing<String> dancing =new Dancing<String>();
		dancing.partnerPairing(arr1, arr2);
	}
}
