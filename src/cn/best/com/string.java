package cn.best.com;

public class string {

	private int maxsize = 10;
	private char[] chars;
	private int length;
	public String a = "";
	
	private string(int n) {
		this.maxsize = n;
		this.chars = new char[n];
		this.length = 0;
	}
	
	private int getLength() {
		return length;
	}
	
	public void add(char c) {
		if(length==this.maxsize) {
			char[] a = new char[this.maxsize*2];
			for(int i = 0; i<this.length; i++) {
				a[i] = this.chars[i];
			}
			chars = a;
		}
		chars[length] = c;
		length++;
	}
	
	public int compare(string t) {
		int i = 0;
		while(this.chars[i]==t.chars[i] && i<this.length && i<t.getLength()) {
			i++;
		}
		if(i==this.length && i==t.length)
			return 0;
		else if(i==t.getLength() && i<this.length)
			return 1;
		else 
			return -1;
	}

	public void concat(string t) {
		if(this.maxsize < this.maxsize + t.getLength()) {
			char[] a = new char[this.length];
			for(int i = 0; i<this.length; i++) {
				a[i] = this.chars[i];
			}
			this.maxsize = this.maxsize + t.getLength();
			this.chars = new char[this.maxsize];
			for(int i = 0; i<a.length; i++) {
				this.chars[i] = a[i];
			}
		}
		for(int i = 0; i<t.getLength(); i++) {
			this.chars[this.length] = t.chars[i];
			this.length++;
		}
	}
	
	public string subString(int pos, int len) {
		if(pos+len>=this.length)
			return null;
		string a = new string(len);
		for(int i = 0; i<len; i++) {
			a.chars[i] = this.chars[pos+1];
			a.length++;
		}
		return a;
	}
	
	public void copy(string t) {
		if(this.maxsize<t.maxsize) {
			this.maxsize = t.maxsize;
			this.chars = new char[this.maxsize];
		}
		this.length = 0;
		for(int i = 0; i<t.getLength(); i++) {
			this.chars[i]=t.chars[i];
			this.length++;
		}
	}
	
	public char[] replace(string t, string v) {
		int i = 0;	//��¼�滻�Ĵ���
		for(int n = 0; n<this.getLength(); n++) {
			if(this.chars[n] == t.chars[0]) {
				int q = 0;
				//�ҳ�t��ԭ���е�λ�ã���q���
				while(this.chars[n]==t.chars[q] && n<this.length && q<t.getLength()) {
					n++;
					q++;
				}
				if(q==t.length) {
					q--;
					n--;
					//��v�е��ַ��滻t
					for(int x = n; q>-1; q--,x--) {
						this.chars[x] = v.chars[q];
					}
				i++;
				}	
			}
		}
		System.out.println("ִ����" + i + "���滻������");
		return chars;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public char[] remove(string t) {
		int i = 0;	//��¼ɾ���Ĵ���
		for(int n = 0; n<this.getLength(); n++) {
			if(this.chars[n] == t.chars[0]) {
				int q = 0;
				int x = n;
				//�ҳ�t��ԭ���е�λ�ã���q���
				while(this.chars[n]==t.chars[q] && n<this.length && q<t.getLength()) {
					n++;
					q++;
				}
				if(q==t.length) {
					//��t����ַ�������ǰ��
					for(int y = x; y<this.length-t.length; y++) {
						this.chars[y] = this.chars[y+q];	
					}
					this.length=this.length-q;
				n=x-1;	
				i++;	
				}	
			}
		}
		System.out.println("ִ����" + i + "��ɾ��������");
		return chars;
	}
	
	public void nextOrder() {
		for(int i=0; i<length; i++)
			System.out.print(chars[i]+" ");
		System.out.println(" ");
	}
	
	public static void main(String[] args) {
		char[] a= {'a','b','a','b','b','a','f'};
		char[] b= {'a','f'};
		char[] c= {'c'};
		string st = new string(10);
		string t = new string(10);
		string v = new string(10);
		
		for(int i = 0; i<a.length; i++)
			st.add(a[i]);
		for(int i = 0; i<b.length; i++)
			t.add(b[i]);
		for(int i = 0; i<c.length; i++)
			v.add(c[i]);
		System.out.println("ԭ�ַ���Ϊ��");
		st.nextOrder();
		System.out.println(st.replace(t, v));
		System.out.println(st.remove(t));
	}
}
