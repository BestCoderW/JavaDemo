package cn.best4.com;

public class Cards {
	/**
	 * CardsBean：一张扑克牌的属性设置，比如花色，面值及其对应的点数；
	 */
	private String color;
	private String value;
	public int count;
	
	public Cards() {}
	
	public Cards(String value) {
		if (value.equals("J")) {
			this.count = 11;
		} else if (value.equals("Q")) {
			this.count = 12;
		} else if (value.equals("K")) {
			this.count = 13;
		} else if (value.equals("A")) {
			this.count = 1;
		} else {
			this.count = Integer.parseInt(value, 10);
		}
	}

	public Cards(String color, String value) {
		this.color = color;
		this.value = value;
	}
	
	/**
	 * 得到当前对象的花色
	 * @return
	 */
	public String getColor() {	
		return color;
	}

	/**
	 * 得到当前对象的面值
	 * @return
	 */
	public String getValue() {	
		return value;
	}
	
	/**
	 * 得到当前面值的点数
	 * @return
	 */
	public int getCount() {
		return count;
	}

}
