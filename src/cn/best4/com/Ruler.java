package cn.best4.com;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 21点游戏
 * @author zoule
 *
 */
public class Ruler {

	Pokers poker = new Pokers();//创建一个扑克牌对象
    int myScore = 0;
    int computerScore = 0;//创建玩家得分和电脑得分初始化为0
	LinkedList<String> myCardsList = new LinkedList<String>();
	LinkedList<String> computerCardsList = new LinkedList<String>();//创建两个得分机制数组，一个存放玩家得分，一个存放电脑得分

    
    /**
     * 给玩家发牌
     * 计算玩家得分,并显示玩家牌的信息
     */
	public void myPlayer() {
    	for (int i = 0; i < 2; i++) {
    		myCardsList.add(poker.getOneCard());
		}
    	computeMyScore();
		extra();
		computeMyScore();
		if (computerScore > 21) {
			System.out.println("电脑引爆，玩家赢了！");
		} else if (myScore > 21) {
			computeMyScore();
			System.out.println("玩家引爆，玩家输了！");
		} else if (myScore > computerScore) {
			System.out.println("玩家总分大于电脑总分，玩家获胜！");
		}else if (myScore == computerScore) {
			System.out.println("玩家总分和电脑总分相等，平局！");
		} else if (myScore < computerScore) {
			System.out.println("玩家总分小于电脑总分，电脑获胜！");
		}
    }
    public void computeMyScore() {
    	myScore = 0;
    	for (int i = 0; i < myCardsList.size(); i++) {
    		String values = myCardsList.get(i).split(",")[1];
    		Cards card = new Cards(values);
    		//Cards card = (Cards) myCardsList.get(i).split(",")[1];
			myScore += card.count;
			System.out.println("玩家第" + (i+1) + "张牌是："+ myCardsList.get(i));
		}
    	System.out.println("玩家得分：" + myScore);
    }
    
    //电脑
	public void computerPlayer() {
    	for (int i = 0; i < 2; i++) {
    		computerCardsList.add(poker.getOneCard());
		}
    	computecomputerScore();
    	String values = computerCardsList.get(0).split(",")[1];
		new Cards(values);
    	//Cards card = (Cards) computerCardsList.get(0);
    	System.out.println("电脑第1张牌是：" + computerCardsList.get(0));
    }
    public void computecomputerScore() {
    	computerScore = 0;
    	for (int i = 0; i < computerCardsList.size(); i++) {
    		String values = computerCardsList.get(i).split(",")[1];
    		Cards card = new Cards(values);
			//Cards card = (Cards) computerCardsList.get(i);
			computerScore += card.count;
		}
    	//System.out.println("电脑得分：" + computerScore);
    }

    /**
     * 叫牌
     */
	public void extra() {
    	System.out.println("玩家是否要拿牌？请输入true或者false!");
    	Scanner scanner =new Scanner(System.in);
    	if (scanner.nextBoolean()) {
    		myCardsList.add(poker.getOneCard());
		}
    	//显示电脑隐藏的一张牌
    	String values = computerCardsList.get(1).split(",")[1];
		new Cards(values);
    	//Cards card = (Cards) computerCardsList.get(1);
    	System.out.println("电脑第2张牌是：" + computerCardsList.get(1));
    	System.out.println("电脑得分：" + computerScore);
    	scanner.close();
    }

    public static void main(String[] args) {
    	System.out.println("游戏开始！");
    	Ruler begin = new Ruler();
    	begin.computerPlayer();
    	begin.myPlayer();
    }
}
