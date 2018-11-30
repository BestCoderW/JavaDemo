package cn.test6.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
class UserCount{
	String name;
	int count;
}
class TimeAttribute{
	int time;
	int personCount;
}

public class WebLogBackground {
	final static int MAXUSE =1000;
	
	WebLogInformation [] allInformation =new WebLogInformation[MAXUSE];
	
	File webLog;
	//
	String[] everyWebLog;
	
	int informationNumber;
	
	UserCount[] userAttribute = new UserCount[MAXUSE];
	UserCount[] webUserUseCounts = new UserCount[MAXUSE];
	Integer[] allLength ={0,0};
	
	int showTimeLength =3;
	
	TimeAttribute[] userUseTime = new TimeAttribute[24];
	
	
	public WebLogBackground(){
		this.informationNumber =0;
	}
	
	public void setWebLog(File webLog){
		this.webLog = webLog;
	}
	
	public void decompostionWebLog(){
		if(webLog==null){
			System.out.println("错误！");
			return;
		}
		Reader reader =null;
		
		try {
			reader = new InputStreamReader(new FileInputStream(webLog));
			int getChar;
			informationNumber =1;
			while((getChar=reader.read())!=-1){
				if((char)getChar=='\r'){
					informationNumber++;
					
				}				
			}
			reader.close();
			reader = new InputStreamReader(new FileInputStream(webLog));
			everyWebLog = new String[informationNumber];
			
			
			int i=0;
			
			everyWebLog[0]="";
			while((getChar=reader.read())!=-1){
				if((char)getChar!='\r'&&(char)getChar!='\n'){
					everyWebLog[i]+=(char)getChar;
				}else if((char)getChar!='\n'){
					continue;
				}else{
					i++;
					everyWebLog[i]="";
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		for(int i=0;i<informationNumber;i++){
			allInformation[i] = new WebLogInformation();
			allInformation[i].oneWebLog = everyWebLog[i];
			allInformation[i].dealWithWebLog();
		}
	}
	
	public void timeUserStatistical(){
		for(int i=0;i<24;i++){
			userUseTime[i] = new TimeAttribute();
			userUseTime[i].time =i;
			userUseTime[i].personCount =0;
		}
		
		for(int i=0;i<informationNumber;i++){
			userUseTime[allInformation[i].getTime()].personCount++;
		}
		
		//bubble 
		for(int i=0;i<24;i++){
			for(int j=0;j<24-i-1;j++){
				if(userUseTime[j].personCount<userUseTime[j+1].personCount){
					TimeAttribute tmp = userUseTime[j];
					userUseTime[j] = userUseTime[j+1];
					userUseTime[j+1] = tmp;
				}
			}
		}
		
		System.out.println("��߷���������ʱ��(��ʾǰ"+showTimeLength+"��):");
		for (int i=0;i<showTimeLength;i++){
			System.out.println(userUseTime[i].time+"�� "+ userUseTime[i].personCount+" ��" );
		}
	}
	
	
	

}
