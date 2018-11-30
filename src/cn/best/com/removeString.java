package cn.best.com;

public class removeString {

	private char[] chars;
	private char[] a = null;
	private int count = 0;
	private int length;
	
	public removeString() {
		this.chars = new char[0];  
        this.length = 0; 
	} 

	public removeString(char[] value) {  
        this.chars = new char[value.length];  
        for (int i = 0; i < value.length; i++) {  
        	chars[i] = value[i];  
        }  
        this.length = value.length;  
    }
	
	public char[] remove(String t) {
		String string = new String(chars);
		int i = string.indexOf(t);
		if (i > 0) {
			int j = i + t.length();
			
			for (int k = j; k < chars.length; k++) {
				chars[i] = chars[k];
				i++;
			}
			
			length = length - t.length();
			a = new char[length];
			
			for (int k = 0; k < a.length; k++) {
				a[k] = chars[k];
			}
			
			count++;
			while (i != -1) {
				chars = a;
				remove(t);
				break;
			}
		} else if (count == 0) {
			throw new StringIndexOutOfBoundsException("该字符串中没有这个子串");  
		}
		return chars;
		
	}

	public static void main(String[] args) {
		
		char[] chars={'z','o','u','z','o','u','l','l','e','w','a','n','g','l','e'};  
		removeString string = new removeString(chars);
		System.out.println(string.remove("le"));
		//System.out.println(string.remove("we"));
		
	}
}
