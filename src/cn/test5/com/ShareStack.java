package cn.test5.com;

/**
 * 两栈共享空间
 * @author zoule
 *
 * @param <T>
 */
public class ShareStack<T> {

	private T[] stackArray;
	private int stackSize;
	private int top1;
	private int top2;
	
	/**
	 * 初始化栈
	 * @param size 
	 */
	/*public ShareStack() {
		top1  = -1;
		top2 = stackSize;
		stackArray = (T[])new Object[];
		
	}*/
	@SuppressWarnings("unchecked")
	public ShareStack(int size) {
		if (size <= 0) {
			System.out.println("数组长度要大于0，否则退出程序运行！");
			System.exit(1);
		}
		stackSize = size;
		top1 = -1;
		top2 = stackSize;
		stackArray = (T[])new Object[size];
	}
	
	/**
	 * 入栈
	 * @param i 第几个栈
	 * @param obj 入栈元素
	 */
	@SuppressWarnings("unchecked")
	public void push(int i,T obj) {
		if (top1 == top2 - 1) {
			T []p = (T[]) new Object[stackSize * 2 + 2];
			for (int j = 0; j < stackSize; j++)
				p[j] = stackArray[j];
			stackArray = p;
		} else if (i == 1) {
			top1 ++;
			stackArray[top1] = obj;
		} else if (i == 2) {
			top2 --;
			stackArray[top2] = obj;
		} else  
			throw new  RuntimeException( "输入错误！" );   
	}
	
	/**
	 * 入栈
	 * @param i
	 * @return
	 */
	public T pop(int i) {
		if (i ==  1 ){  
            if (top1 == -1)  
                throw new  RuntimeException( "栈1为空" );   
            return  stackArray[top1--];  
        }  else if (i ==  2 ){   
            if (top2 == stackSize)  
                throw new  RuntimeException( "栈2为空" );   
            return  stackArray[top2++];  
        }  else
        	throw new  RuntimeException( "输入错误！" );   
	}
	
	/**
	 * 取栈顶元素
	 * @param i
	 * @return
	 */
	public T getHead(int i) {
		if (i ==  1 ){  
            if (top1 == -1)  
                throw new  RuntimeException( "栈1为空" );   
            return  stackArray[top1];  
        }  else if (i ==  2 ){   
            if (top2 == stackSize)  
                throw new  RuntimeException( "栈2为空" );   
            return  stackArray[top2];  
        }  else    
        	throw new  RuntimeException( "输入错误！" );   
	}
	
	/**
	 * 判栈空操作
	 * @param i
	 * @return
	 */
	public boolean isEmpty(int i) {
		if (i == 1) {
			return top1 == -1;
		} else if (i == 2) {
			return top2 == stackSize;
		} else
			throw new  RuntimeException( "输入错误！" );   
	}

	/**
	 * 置栈空
	 * @param i
	 */
	public void clear(int i) {
		if (i == 1) {
			top1 = -1;
		} else if (i == 2) {
			top2 = stackSize;
		} else
			throw new  RuntimeException( "输入错误！" );   
	}
}
