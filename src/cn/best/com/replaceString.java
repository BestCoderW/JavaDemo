package cn.best.com;

public class replaceString {

	private char[] chars;
	private char[] a = null;
	private int count = 0;
	private int length;
	
	public replaceString(char[] value) {  
        this.chars = new char[value.length];  
        for (int i = 0; i < value.length; i++) {  
        	chars[i] = value[i];  
        }  
        this.length = value.length;  
    }
	
	public char[] replace(String t,String v) {
		String string = new String(chars);
		char[] arr= string.replace(t, v).toCharArray();
		return arr;
		
		/*char[] oldChar = t.toCharArray();
		char newChar = v.charAt(0);
		//if (oldChar != newChar) {
			int len = chars.length;
            int i = string.indexOf(t);
            int j;
            char buf[] = new char[len];
            for (int q = 0; q < chars.length; q++) {
            	buf[q] = chars[q];
            }
            while (i < len) {
				j = string.indexOf(t, i);
				count++;
				for (int w = 0; w < oldChar.length; w++) {
					char c = chars[w+j];
					//buf[w+j] = (c == oldChar[w]) ? newChar : c;
					if (c == oldChar[w]) {
						buf[w+j] = newChar;
					} else {
						buf[w+j] = c;
					}
				}
				i = j - 1 + i;
			}
        //}
            System.out.println(count);
        return buf;*/
	}
	
	public static void main(String[] args) {
		char[] chars={'z','o','u','z','o','u','l','l','e','w','a','n','g','l','e'};  
		replaceString string = new replaceString(chars);
		System.out.println(string.replace("le",""));
	}

}
