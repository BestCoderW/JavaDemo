package cn.test6.com;

public class WebLogInformation {
	String oneWebLog;
	String recordNumber;
	String userID;
	String clientIP;
	String accessTime;
	String accessWeb;
	final static Integer LENGTH =5;
	final static String[] ALLNAME={"记录编号","用户ID","客户端IP","访问时间","访问页面文件名"};
	
	public void init(String[] s){
		if(s.length!=LENGTH){
			System.out.println("错误！");
			return;
		}
		recordNumber = s[0];
		userID = s[1];
		clientIP =s[2];
		accessTime = s[3];
		accessWeb = s[4];
	}
	
	public void dealWithWebLog(){
		if((oneWebLog==null)||(oneWebLog=="")){
			System.out.println("错误！");
			return;
		}
		String [] allInformation = new String[LENGTH];
		allInformation = oneWebLog.split(",");
		this.init(allInformation);
	}
	
	public int getTime(){
		return Integer.valueOf(this.accessTime.split(" ")[1].split(":")[0]);
	}
	public void show(){
		System.out.println(ALLNAME[0]+":"+recordNumber+" ");
		System.out.println(ALLNAME[1]+":"+userID+" ");
		System.out.println(ALLNAME[2]+":"+clientIP+" ");
		System.out.println(ALLNAME[3]+":"+accessTime+" ");
		System.out.println(ALLNAME[4]+":"+accessWeb+" ");
	}

	public String getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getClientIP() {
		return clientIP;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	public String getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(String accessTime) {
		this.accessTime = accessTime;
	}

	public String getAccessWeb() {
		return accessWeb;
	}

	public void setAccessWeb(String accessWeb) {
		this.accessWeb = accessWeb;
	}

}
