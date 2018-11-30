package cn.best4.com;

import java.util.LinkedList;
import java.util.Random;

public class Pokers {
	/**
	 * 一副牌的属性，如花色，面值
	 */
	static final int COUNT = 52;
    static String color[] = {"梅花", "红桃", "方块", "黑桃"};
    static String value[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    static Cards cards[] = new Cards[COUNT];
	LinkedList<String> list = new LinkedList<String>();
    
	public Pokers () {
    	for (int i = 0; i < color.length; i++) 
			for (int j = 0; j < value.length; j++) {
				cards[i * 13 + j] = new Cards(color[i], value[j]);
    			list.add(i, color[i] + "," + value[j]);
			}
    }
    
    /**
     * 随机发牌
     */
	public String getOneCard() {
    	Random rod = new Random();
    	return list.get(rod.nextInt(COUNT));
    }

}
